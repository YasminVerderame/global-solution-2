package br.com.fiap.globalsolution2

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import androidx.versionedparcelable.VersionedParcelize
import br.com.fiap.globalsolution2.database.HistoricoPacienteModel
import br.com.fiap.globalsolution2.database.PacienteModel

@VersionedParcelize
 data class PacienteComHistorico(
    @Embedded val paciente: PacienteModel,
    @Relation(
        parentColumn = "id",
        entityColumn = "paciente_id"
    )
    val historicos: List<HistoricoPacienteModel>
)