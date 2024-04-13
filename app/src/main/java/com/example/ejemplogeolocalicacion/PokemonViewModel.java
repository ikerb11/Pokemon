package com.example.ejemplogeolocalicacion;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.ejemplogeolocalicacion.Entidades.Pokemon;
import com.example.ejemplogeolocalicacion.Utils.PokemonDataBase;

import java.util.List;

public class PokemonViewModel extends Thread {
    private PokemonRepositorio pokemonRepositorio;
    private List<Pokemon> pokemonListado;

    public PokemonViewModel(@NonNull Application application) {
        PokemonDataBase db= PokemonDataBase.Companion.getInstance(application);
        pokemonRepositorio = new PokemonRepositorio(application);
        pokemonListado = pokemonRepositorio.getAllOcio();

    }

    public List<Pokemon> getPokemonListado(){

        return pokemonListado;
    }
    public  void insert(Pokemon objetoPokemon){
        pokemonRepositorio.insert(objetoPokemon);
    }
}
