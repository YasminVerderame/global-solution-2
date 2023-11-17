package br.com.fiap.globalsolution2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import br.com.fiap.globalsolution2.PacienteComHistorico
@Dao
interface PacienteDAO {
    @Transaction
    @Query("SELECT * FROM pacienteTable WHERE id = :pacienteId")
    fun getPacienteComHistorico(pacienteId: Int): PacienteComHistorico?

    @Query("SELECT * FROM pacienteTable ORDER BY id")
    fun selectAllPacientes(): List<PacienteComHistorico>

    @Insert
    fun insertPaciente(pacienteModel: PacienteModel): Long

    @Transaction
    @Insert
    fun insertPacienteComHistorico(historicoPacienteModel: HistoricoPacienteModel): Long
}