package br.com.fiap.globalsolution2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.btnListarPacientes.setOnClickListener {
            listarPacientes()
        }
    }

    private fun listarPacientes() {
        GlobalScope.launch(Dispatchers.IO) {
            val pacientesComHistorico = AppDatabase.getDatabase(applicationContext)
                .pacienteDAO().selectAllPacientes()

            launch(Dispatchers.Main) {
                pacienteAdapter.submitList(pacientesComHistorico)
            }
        }
    }
}