package com.example.ejemplogeolocalicacion

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.ejemplogeolocalicacion.Dao.PokemonDao
import com.example.ejemplogeolocalicacion.Entidades.Pokemon
import com.example.ejemplogeolocalicacion.Utils.PokemonDataBase
import kotlinx.coroutines.CoroutineScope


class PokemonRepositorio {
    private var listadoOcio: List<Pokemon?>? = null
    private var ocioDao: PokemonDao? = null

    constructor(context: Context) {
        val db: PokemonDataBase? = PokemonDataBase.getInstance(context)
        ocioDao = db?.PokemonDao()
        this.ocioDao?.eliminarTodos();
        this.ocioDao?.insertar(Pokemon("Raichu", "Electrico", 0.5,20.2, -0.45656 , 38.55678, "Ataque rapido, Rayo, Pararayos, Carga" ))
        this.ocioDao?.insertar(Pokemon("Pikachu", "Electrico", 0.5,20.2, -0.35656 , 38.45678, "Ataque ferreo, Rayo, Pararayos, Bola Voltio" ))
        listadoOcio = ocioDao!!.obtenerPokemonsOrdenados()
    }

    fun getAllOcio(): List<Pokemon?>? {
        return listadoOcio
    }

    fun insert(objetoOcio: Pokemon?) {
        PokemonDataBase.dbExecutor.execute() {
            if (objetoOcio != null) {
                ocioDao!!.insertar(objetoOcio)
            }
        }
    }
    fun borrar() {
        PokemonDataBase.dbExecutor.execute() {
            ocioDao?.eliminarTodos()
        }
    }
}