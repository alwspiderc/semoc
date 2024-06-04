package br.com.ucsal.semoc.ui.activity.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.ucsal.semoc.R
import br.com.ucsal.semoc.model.Talk

class ListTalkAdapter(
    private val context: Context,
    private val talks: List<Talk>
) : RecyclerView.Adapter<ListTalkAdapter.ViewHolder>(
) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(talk: Talk) {
            val nome = itemView.findViewById<TextView>(R.id.produto_item_nome)
            nome.text = talk.nome
            val descricao = itemView.findViewById<TextView>(R.id.produto_item_descricao)
            descricao.text = talk.descricao

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
    }

//    fun update(talks: List<Talk>) {
//        this.talks.clear()
//        this.talks.addAll(talks)
//        notifyDataSetChanged()
//    }
}