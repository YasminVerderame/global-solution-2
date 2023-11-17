package br.com.fiap.globalsolution2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.fiap.globalsolution2.database.AppDatabase
import br.com.fiap.globalsolution2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        val intent = Intent(this, DetalhesPacienteActivity::class.java)
        startActivity(intent)
    }

    private fun abrirTelaCadastroPaciente() {
        val intent = Intent(this, CadastroPacienteActivity::class.java)
        startActivity(intent)
    }
}