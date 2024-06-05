package br.com.ucsal.semoc.ui.talk

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
    private lateinit var talkViewModel: TalkViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTalkBinding.inflate(inflater, container, false)
        val root: View = binding.root

        talkViewModel = ViewModelProvider(this).get(TalkViewModel::class.java)

        setupRecyclerView()
        setupSearchView()

//        talkViewModel.getTalks().observe(viewLifecycleOwner, { talks ->
//            updateRecyclerView(talks)
//        })

        talkViewModel.talks.observe(viewLifecycleOwner) { talks ->
            updateRecyclerView(talks)
        }

        return root
    }

    private fun setupRecyclerView() {
        binding.activityListTalkRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun setupSearchView() {
        binding.searchFragmentTalk.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    if (newText.isEmpty()) {
                        talkViewModel.resetTalks()
                    } else {
                        if (newText.trim().length == 8 || newText.trim().length == 10) {
                            talkViewModel.filterTalksByDate(newText)
                        }

//                        if (newText.trim().matches("\\d{2}/\\d{2}/\\d{4}".toRegex())) {
//                            talkViewModel.filterTalksByDate(newText)
//                        }
                    }
                }
                return false
            }
        })
    }

    private fun updateRecyclerView(talks: List<Talk>) {
        val viewAdapter = ListTalkAdapter(requireContext(), talks, object :
            OnTalkClickListener {
            override fun onTalkClick(talk: Talk) {
                val intent = Intent(context, TalkDetailActivity::class.java)
                intent.putExtra("talk", talk)
                startActivity(intent)
            }
        })
        binding.activityListTalkRecyclerView.adapter = viewAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
