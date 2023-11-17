package br.com.fiap.globalsolution2

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.globalsolution2.databinding.ItemPacienteViewBinding

class PacienteAdapter(val pacientes: List<PacienteComHistorico>) : RecyclerView.Adapter<PacienteAdapter.PacienteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacienteViewHolder {
        val binding = ItemPacienteViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PacienteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PacienteViewHolder, position: Int) {
        val paciente = pacientes[position]
        holder.bind(paciente)
    }

    inner class PacienteViewHolder(private val binding: ItemPacienteViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(paciente: PacienteComHistorico) {
            binding.txtNome.text = "Nome: ${paciente.paciente.nome}"
            binding.txtIdade.text = "Idade: ${paciente.paciente.idade}"
            binding.btnCadastrarPaciente.setOnClickListener(View.OnClickListener {
                Log.d(
                    "TAG",
                    "bind:" +paciente.paciente.nome
                ) })

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

    override fun getItemCount(): Int {
        return pacientes.size
    }
}