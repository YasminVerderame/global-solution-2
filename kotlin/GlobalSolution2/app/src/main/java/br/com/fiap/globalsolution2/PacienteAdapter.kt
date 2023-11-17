package br.com.fiap.globalsolution2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.globalsolution2.databinding.ItemPacienteBinding

class PacienteAdapter : ListAdapter<PacienteComHistorico, PacienteAdapter.PacienteViewHolder>(PacienteDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacienteViewHolder {
        val binding = ItemPacienteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PacienteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PacienteViewHolder, position: Int) {
        val paciente = getItem(position)
        holder.bind(paciente)
    }

    inner class PacienteViewHolder(private val binding: ItemPacienteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(paciente: PacienteComHistorico) {
            binding.txtNome.text = "Nome: ${paciente.paciente.nome}"
            binding.txtIdade.text = "Idade: ${paciente.paciente.idade}"

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetalhesPacienteActivity::class.java)
                intent.putExtra("nome", paciente.paciente.nome)
                intent.putExtra("idade", paciente.paciente.idade)
                intent.putExtra("email", paciente.paciente.email)
                intent.putExtra("telefone", paciente.paciente.telefone)
                itemView.context.startActivity(intent)
            }
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