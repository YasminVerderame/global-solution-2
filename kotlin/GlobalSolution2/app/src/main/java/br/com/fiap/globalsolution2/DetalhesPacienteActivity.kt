package br.com.fiap.globalsolution2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.globalsolution2.databinding.ActivityDetalhesPacienteBinding
import java.text.SimpleDateFormat
import java.util.Date

class DetalhesPacienteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhesPacienteBinding
    private val ADICIONAR_HISTORICO_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesPacienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", 0)
        val email = intent.getStringExtra("email")
        val telefone = intent.getStringExtra("telefone")

        binding.txtDetalhesNome.text = "Nome: $nome"
        binding.txtDetalhesIdade.text = "Idade: $idade"
        binding.txtDetalhesEmail.text = "Email: $email"
        binding.txtDetalhesTelefone.text = "Telefone: $telefone"

    }

    private fun abrirTelaAdicionarHistorico() {
        val intent = Intent(this, AdicionarHistoricoActivity::class.java)
        startActivityForResult(intent, ADICIONAR_HISTORICO_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADICIONAR_HISTORICO_REQUEST && resultCode == Activity.RESULT_OK) {
            val dataUltimaConsulta = data?.getSerializableExtra("dataUltimaConsulta") as Date
            val sintomas = data.getStringExtra("sintomas")

            binding.txtDetalhesDataConsulta.text = "Data da última consulta: ${SimpleDateFormat("dd/MM/yyyy").format(dataUltimaConsulta)}"
            binding.txtDetalhesSintomas.text = "Sintomas: $sintomas"
        }
    }
}