package br.com.ucsal.semoc.ui.minicourse

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.ucsal.semoc.databinding.FragmentMinicourseBinding
import br.com.ucsal.semoc.model.Minicourse
import br.com.ucsal.semoc.ui.activity.recyclerview.adapter.ListMinicourseAdapter
import br.com.ucsal.semoc.ui.activity.recyclerview.adapter.OnMinicourseClickListener


class MinicourseFragment : Fragment() {

    private var _binding: FragmentMinicourseBinding? = null

    private val binding get() = _binding!!
    private lateinit var minicourseViewModel: MinicourseViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMinicourseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        minicourseViewModel = ViewModelProvider(this).get(MinicourseViewModel::class.java)

        setupRecyclerView()
        setupSearchView()

        minicourseViewModel.minicourse.observe(viewLifecycleOwner) { minicourse ->
            updateRecyclerView(minicourse)
        }

        return root
    }
    private fun setupRecyclerView() {
        binding.activityListMinicourseRecyclerView.layoutManager = LinearLayoutManager(context)
    }


    private fun setupSearchView() {
        binding.searchFragmentMinicourse.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    if (newText.isEmpty()) {
                        minicourseViewModel.reset()
                    } else {
                        if (newText.trim().length == 8 || newText.trim().length == 10) {
                            minicourseViewModel.filterByDate(newText)
                        }

                    }
                }
                return false
            }
        })
    }

    private fun updateRecyclerView(minicourse: List<Minicourse>) {
        val viewAdapter = ListMinicourseAdapter(requireContext(), minicourse, object :
            OnMinicourseClickListener {
            override fun onMinicourseClick(minicourse: Minicourse) {
                val intent = Intent(context, MinicourseDetailActivity::class.java)
                intent.putExtra("minicourse", minicourse)
                startActivity(intent)
            }
        })
        binding.activityListMinicourseRecyclerView.adapter = viewAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}