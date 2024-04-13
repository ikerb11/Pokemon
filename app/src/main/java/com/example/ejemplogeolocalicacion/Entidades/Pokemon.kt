package com.example.ejemplogeolocalicacion.Entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "pokemon_tabla")
data class Pokemon(
    @PrimaryKey val nombre: String,
    @ColumnInfo(name = "tipo") val tipo: String?,
    @ColumnInfo(name = "altura") val altura: Double?,
    @ColumnInfo(name = "peso") val peso: Double?,
    @ColumnInfo(name = "latitud") val latitud: Double?,
    @ColumnInfo(name = "longitud") val longitud: Double?,
    @ColumnInfo(name = "Habilidades") val habilidades: String?,
)