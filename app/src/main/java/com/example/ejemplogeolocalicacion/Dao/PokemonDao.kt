package com.example.ejemplogeolocalicacion.Dao;

import androidx.room.Dao;
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query;
import com.example.ejemplogeolocalicacion.Entidades.Pokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * from pokemon_tabla ORDER BY nombre ASC")
    fun obtenerPokemonsOrdenados(): List<Pokemon>
    @Query ("DELETE from pokemon_tabla")
    fun eliminarTodos()
    @Insert
    fun insertar(tarea: Pokemon)

}