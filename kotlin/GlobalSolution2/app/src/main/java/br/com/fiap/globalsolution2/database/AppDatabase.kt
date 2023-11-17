package br.com.fiap.globalsolution2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

const val GS_DATABASE_NAME = "GS_DATABASE_NAME"

@Database(entities = [PacienteModel::class, HistoricoPacienteModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun pacienteDAO(): PacienteDAO
    abstract fun historicoPacienteDAO(): HistoricoPacienteDAO

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE != null) {
                return INSTANCE!!
            } else {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    GS_DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}