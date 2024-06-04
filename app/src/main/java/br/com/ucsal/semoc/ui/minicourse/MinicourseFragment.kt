package br.com.ucsal.semoc.ui.minicourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.ucsal.semoc.databinding.FragmentMinicourseBinding

class minicourseFragment : Fragment() {

    private var _binding: FragmentMinicourseBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val minicourseViewModel =
            ViewModelProvider(this).get(minicourseViewModel::class.java)

        _binding = FragmentMinicourseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMinicourse
        minicourseViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}