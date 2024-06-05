package br.com.ucsal.semoc.ui.activity.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.ucsal.semoc.R
import br.com.ucsal.semoc.model.Minicourse

interface OnMinicourseClickListener {
    fun onMinicourseClick(minicourse: Minicourse)
}

class ListMinicourseAdapter(
    private val context: Context,
    private val minicourses: List<Minicourse>,
    private val listener: OnMinicourseClickListener
) : RecyclerView.Adapter<ListMinicourseAdapter.ViewHolder>(
) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(minicourse: Minicourse) {
            val title = itemView.findViewById<TextView>(R.id.title_minicourse)
            title.text = minicourse.nome
            val data = itemView.findViewById<TextView>(R.id.date_minicourse)
            data.text = minicourse.data
            val time = itemView.findViewById<TextView>(R.id.time_minicourse)
            time.text = minicourse.hora
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.minicourse_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int  = minicourses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val minicourse = minicourses[position]
        holder.bind(minicourse)
        holder.itemView.setOnClickListener { listener.onMinicourseClick(minicourse) }
    }

}