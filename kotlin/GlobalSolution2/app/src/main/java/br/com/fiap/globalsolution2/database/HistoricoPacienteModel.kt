package br.com.fiap.globalsolution2.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import androidx.versionedparcelable.VersionedParcelize
import java.util.Date

const val HISTORICO_MODEL_TABLE_NAME = "historicoPacienteTable"
@Entity(tableName = HISTORICO_MODEL_TABLE_NAME)
@VersionedParcelize
data class HistoricoPacienteModel(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "paciente_id")
    var pacienteId: Int,

    @NonNull
    @TypeConverters(Converters::class)
    @ColumnInfo
    val dtUltimaConsulta: Date,


    @NonNull
    @ColumnInfo
    val sintomas: String
)
