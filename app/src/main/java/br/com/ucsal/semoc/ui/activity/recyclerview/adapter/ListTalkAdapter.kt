package br.com.ucsal.semoc.ui.activity.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.ucsal.semoc.R
import br.com.ucsal.semoc.model.Talk
import br.com.ucsal.semoc.utils.formatDateInBrazilianFormat

interface OnTalkClickListener {
    fun onTalkClick(talk: Talk)
}

class ListTalkAdapter(
    private val context: Context,
    private val talks: List<Talk>,
    private val listener: OnTalkClickListener
) : RecyclerView.Adapter<ListTalkAdapter.ViewHolder>(
) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(talk: Talk) {
            val title = itemView.findViewById<TextView>(R.id.title_talk)
            title.text = talk.nome
            val data = itemView.findViewById<TextView>(R.id.date_talk)
            data.text = talk.data.formatDateInBrazilianFormat()
            val time = itemView.findViewById<TextView>(R.id.time_talk)
            time.text = talk.hora
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.talk_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int  = talks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val talk = talks[position]
        holder.bind(talk)
        holder.itemView.setOnClickListener { listener.onTalkClick(talk) }
    }


}

