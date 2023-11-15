package br.com.fiap.globalsolution2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class PacienteAdapter : ListAdapter<PacienteComHistorico, PacienteAdapter.PacienteViewHolder>(PacienteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacienteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_paciente, parent, false)
        return PacienteViewHolder(view)
    }

    override fun onBindViewHolder(holder: PacienteViewHolder, position: Int) {
        val paciente = getItem(position)
        holder.bind(paciente)
    }

    inner class PacienteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtNome: TextView = itemView.findViewById(R.id.txtNome)
        private val txtIdade: TextView = itemView.findViewById(R.id.txtIdade)

        fun bind(paciente: PacienteComHistorico) {
            txtNome.text = "Nome: ${paciente.paciente.nome}"
            txtIdade.text = "Idade: ${paciente.paciente.idade}"
        }
    }

    private class PacienteDiffCallback : DiffUtil.ItemCallback<PacienteComHistorico>() {
        override fun areItemsTheSame(oldItem: PacienteComHistorico, newItem: PacienteComHistorico): Boolean {
            return oldItem.paciente.id == newItem.paciente.id
        }

        override fun areContentsTheSame(oldItem: PacienteComHistorico, newItem: PacienteComHistorico): Boolean {
            return oldItem == newItem
        }
    }
}