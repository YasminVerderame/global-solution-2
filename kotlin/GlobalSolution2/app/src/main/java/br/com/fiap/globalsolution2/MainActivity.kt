package br.com.fiap.globalsolution2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.globalsolution2.database.AppDatabase
import br.com.fiap.globalsolution2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pacienteAdapter: PacienteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pacienteAdapter = PacienteAdapter()

        binding.recyclerView.adapter = pacienteAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnListarPacientes.setOnClickListener {
            Log.d("MainActivity", "Clicou em Listar Pacientes")
            listarPacientes()
        }

        binding.btnCadastrarPaciente.setOnClickListener {
            Log.d("MainActivity", "Clicou em Cadastrar Paciente")
            abrirTelaCadastroPaciente()
        }
    }

    private fun listarPacientes() {
        Log.d("MainActivity", "Clicou em Listar Pacientes")
        GlobalScope.launch(Dispatchers.IO) {
            val pacientes = AppDatabase.getDatabase(applicationContext).pacienteDAO().selectAllPacientes()

            Log.d("MainActivity", "Pacientes: $pacientes")

            launch(Dispatchers.Main) {
                pacienteAdapter.submitList(pacientes)
            }
        }
    }

    private fun abrirTelaCadastroPaciente() {
        val intent = Intent(this, CadastroPacienteActivity::class.java)
        startActivity(intent)
    }
}