package br.com.fiap.globalsolution2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.globalsolution2.database.AppDatabase
import br.com.fiap.globalsolution2.databinding.ActivityListarPacienteBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetalhesPacienteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListarPacienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarPacienteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        GlobalScope.launch(Dispatchers.IO) {
            val pacientes = AppDatabase.getDatabase(applicationContext).pacienteDAO().selectAllPacientes()

            Log.d("MainActivity", "Pacientes: $pacientes")

            withContext(Dispatchers.Main) {
                binding.recyclerViewPaciente.layoutManager =
                    LinearLayoutManager(this@DetalhesPacienteActivity)

                val pacienteAdapter = PacienteAdapter(pacientes)
                binding.recyclerViewPaciente.adapter = pacienteAdapter
            }
        }
    }
}