package br.com.fiap.globalsolution2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HistoricoPacienteDAO {
    @Query("SELECT * FROM $HISTORICO_MODEL_TABLE_NAME  ORDER BY id")
    fun select() : List<HistoricoPacienteModel>

    @Insert
    fun insert(historicoPacienteModel: HistoricoPacienteModel)

    @Update
    fun update(historicoPacienteModel: HistoricoPacienteModel)
}