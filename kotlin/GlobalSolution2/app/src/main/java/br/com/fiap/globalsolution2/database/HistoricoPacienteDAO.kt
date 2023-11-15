package br.com.fiap.globalsolution2.database

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface HistoricoPacienteDAO {
    @Query("SELECT * FROM $PACIENTE_MODEL_TABLE_NAME  ORDER BY id")
    fun select() : List<PacienteModel>

    @Insert
    fun insert(historicoPacienteModel: HistoricoPacienteModel)

    @Update
    fun update(historicoPacienteModel: HistoricoPacienteModel)
}