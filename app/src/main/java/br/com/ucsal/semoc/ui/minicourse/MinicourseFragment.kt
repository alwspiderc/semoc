package br.com.ucsal.semoc.ui.minicourse

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.ucsal.semoc.databinding.FragmentMinicourseBinding
import br.com.ucsal.semoc.model.Minicourse
import br.com.ucsal.semoc.repository.MinicourseRepository
import br.com.ucsal.semoc.ui.activity.recyclerview.adapter.ListMinicourseAdapter
import br.com.ucsal.semoc.ui.activity.recyclerview.adapter.OnMinicourseClickListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MinicourseFragment : Fragment() {

    private var _binding: FragmentMinicourseBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMinicourseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.activityListMinicourseRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        val minicourseRepository = MinicourseRepository()
        minicourseRepository.getMinicourses().enqueue(object : Callback<List<Minicourse>> {
            override fun onResponse(call: Call<List<Minicourse>>, response: Response<List<Minicourse>>) {
                response.body()?.let {
                    val viewAdapter = ListMinicourseAdapter(requireContext(), it, object :
                        OnMinicourseClickListener {
                        override fun onMinicourseClick(minicourse: Minicourse) {
                            val intent = Intent(context, MinicourseDetailActivity::class.java)
                            intent.putExtra("minicourse", minicourse)
                            startActivity(intent)
                        }
                    })
                    recyclerView.adapter = viewAdapter
                }
            }

            override fun onFailure(call: Call<List<Minicourse>>, t: Throwable) {
                // no caso de falha, podemos exibir uma mensagem de erro
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}