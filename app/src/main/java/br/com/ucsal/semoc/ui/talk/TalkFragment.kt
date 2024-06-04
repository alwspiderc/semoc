package br.com.ucsal.semoc.ui.talk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.ucsal.semoc.databinding.FragmentTalkBinding
import br.com.ucsal.semoc.model.Talk
import br.com.ucsal.semoc.repository.TalkRepository
import br.com.ucsal.semoc.ui.activity.recyclerview.adapter.ListTalkAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TalkFragment : Fragment() {

    private var _binding: FragmentTalkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTalkBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.activityListTalkRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        val talkRepository = TalkRepository()
        talkRepository.getTalks().enqueue(object : Callback<List<Talk>> {
            override fun onResponse(call: Call<List<Talk>>, response: Response<List<Talk>>) {
                println("Response: ${response.body()}")
                response.body()?.let {
                    val viewAdapter = ListTalkAdapter(requireContext(), it)
                    recyclerView.adapter = viewAdapter
                }
            }

            override fun onFailure(call: Call<List<Talk>>, t: Throwable) {
                // Handle failure
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}