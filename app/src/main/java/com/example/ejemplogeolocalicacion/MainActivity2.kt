package com.example.ejemplogeolocalicacion

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplogeolocalicacion.Entidades.Pokemon
import com.example.ejemplogeolocalicacion.Utils.PokemonDataBase

class MainActivity2 : AppCompatActivity() {
    lateinit var lista: ListView
    var productos: ArrayList<Pokemon> = ArrayList<Pokemon>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        var dataBase: PokemonDataBase? =
            PokemonDataBase.getInstance(context = this);
        try {
            val threat =  Thread{productos =
                PokemonViewModel(this.application).pokemonListado as ArrayList<Pokemon>
            }
            threat.start()
            while (threat.isAlive){
            }
        }catch (_: NullPointerException) {

        }

        lista = findViewById(R.id.lista)


        val adpatador = PokemonAdapter(this, productos)
        lista.setAdapter(adpatador)

        lista.onItemClickListener =
            OnItemClickListener { adapterView, view, i, l ->
                val intent = Intent(applicationContext, MainActivity::class.java)
                intent.putExtra("longitund",productos[i].longitud)
                intent.putExtra("latitud",productos[i].longitud)
                intent.putExtra("nombre",productos[i].nombre)
                startActivity(intent)
            }
    }

}


