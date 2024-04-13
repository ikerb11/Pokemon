package com.example.ejemplogeolocalicacion.Utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ejemplogeolocalicacion.Dao.PokemonDao
import com.example.ejemplogeolocalicacion.Entidades.Pokemon
import java.util.concurrent.Executors


@Database(entities = [Pokemon::class], version = 1, exportSchema = false)
abstract class PokemonDataBase : RoomDatabase() {
    //Exposición de los DAOs: Se crea un método get*() abstracto por cada DAO que tengamos
    abstract fun PokemonDao(): PokemonDao

    companion object {
        private const val DATABASE_NAME = "hotel_db"

        //Patrón SINGLETON: Para tener una única instancia abierta
        private var INSTANCE: PokemonDataBase? = null
        private const val THREADS = 4

        // Declaramos un ExecutorService para ejecutar operaciones de bases de datos en otros hilos de trabajo
        val dbExecutor = Executors.newFixedThreadPool(THREADS)

        //Patrón SINGLETON
        fun getInstance(context: Context): PokemonDataBase? {
            if (INSTANCE == null) {
                synchronized(PokemonDataBase::class.java) {
                    if (INSTANCE == null) {
                        //Creamos la base de datos
                        INSTANCE = databaseBuilder(
                            context.applicationContext,
                            PokemonDataBase::class.java,
                            DATABASE_NAME

                        )

                            .addCallback(mRoomCallback)
                            .build()
                    }


                }
            }
            return INSTANCE
        }

        /*
    * Room proporciona la clase RoomDatabase.Callback en su última versión, que tiene
    * métodos callback onCreate y onOpen. Estos se invocan cuando la base de datos se crea o se abre.
    * Para usarlos se deben implementar y añadirlos en el databaseBuilder
    * */
        private val mRoomCallback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                dbExecutor.execute {


                }
            }
        }
    }
}