package com.example.ejemplogeolocalicacion.servicios

import com.example.ejemplogeolocalicacion.Entidades.Pokemon
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    suspend fun getUserPost():ArrayList<Pokemon>
}
