package br.com.fiap.globalsolution2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.globalsolution2.databinding.ActivityAdicionarHistoricoBinding
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat

class AdicionarHistoricoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdicionarHistoricoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdicionarHistoricoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdicionarHistorico.setOnClickListener {
            adicionarHistorico()
        }

        binding.buttonBackToDetalhesPaciente.setOnClickListener {
            finish()
        }
    }

    private fun adicionarHistorico() {
        val dataUltimaConsultaStr = binding.textInputEditTextDataUltimaConsulta.text.toString()
        val sintomas = binding.textInputEditTextSintomas.text.toString()

        if (dataUltimaConsultaStr.isNotBlank() && sintomas.isNotBlank()) {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy")
            val dataUltimaConsulta = dateFormat.parse(dataUltimaConsultaStr)

            val intent = Intent()
            intent.putExtra("dataUltimaConsulta", dataUltimaConsulta)
            intent.putExtra("sintomas", sintomas)
            setResult(Activity.RESULT_OK, intent)
            finish()
        } else {
            exibirMensagemErro("Erro ao cadastrar histório do paciente. Verifique os dados inseridos.")
        }
    }

    private fun exibirMensagemErro(mensagem: String) {
        Snackbar.make(binding.root, mensagem, Snackbar.LENGTH_LONG).show()
    }
}