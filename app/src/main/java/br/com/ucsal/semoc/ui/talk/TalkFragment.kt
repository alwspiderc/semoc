package br.com.ucsal.semoc.ui.talk

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.ucsal.semoc.databinding.FragmentTalkBinding
import br.com.ucsal.semoc.model.Talk
import br.com.ucsal.semoc.repository.TalkRepository
import br.com.ucsal.semoc.ui.activity.recyclerview.adapter.ListTalkAdapter
import br.com.ucsal.semoc.ui.activity.recyclerview.adapter.OnTalkClickListener
import br.com.ucsal.semoc.utils.formatDateInUSFormat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Locale

class TalkFragment : Fragment() {

    private var _binding: FragmentTalkBinding? = null
    private val binding get() = _binding!!
    private var talks: List<Talk> = listOf()
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTalkBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = binding.activityListTalkRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        val talkRepository = TalkRepository()
        talkRepository.getTalks().enqueue(object : Callback<List<Talk>> {
            override fun onResponse(call: Call<List<Talk>>, response: Response<List<Talk>>) {
                response.body()?.let {
                    talks = it
                    val viewAdapter = ListTalkAdapter(requireContext(), it, object :
                        OnTalkClickListener {
                        override fun onTalkClick(talk: Talk) {
                            val intent = Intent(context, TalkDetailActivity::class.java)
                            intent.putExtra("talk", talk)
                            startActivity(intent)
                        }
                    })
                    recyclerView.adapter = viewAdapter
                }
            }

            override fun onFailure(call: Call<List<Talk>>, t: Throwable) {
                // no caso de falha, podemos exibir uma mensagem de erro

            }
        })

        val searchView = binding.searchFragmentTalk
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    if (newText.isEmpty()) {
                        val viewAdapter = ListTalkAdapter(requireContext(), talks, object :
                            OnTalkClickListener {
                            override fun onTalkClick(talk: Talk) {
                                val intent = Intent(context, TalkDetailActivity::class.java)
                                intent.putExtra("talk", talk)
                                startActivity(intent)
                            }
                        })
                        recyclerView.adapter = viewAdapter
                    } else {
                        if (newText.trim().length == 8 || newText.trim().length == 10) {
                            filterTalksByDate(newText)
                        }
                    }
                }
                return false
            }
        })

        return root
    }

    private fun filterTalksByDate(date: String) {

        val filteredTalks = talks.filter { it.data == date.formatDateInUSFormat() }
        val viewAdapter = ListTalkAdapter(requireContext(), filteredTalks, object :
            OnTalkClickListener {
            override fun onTalkClick(talk: Talk) {
                val intent = Intent(context, TalkDetailActivity::class.java)
                intent.putExtra("talk", talk)
                startActivity(intent)
            }
        })
        recyclerView.adapter = viewAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

