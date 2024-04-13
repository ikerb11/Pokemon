package com.example.ejemplogeolocalicacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Login_Layout : AppCompatActivity() {
    private lateinit var boton: Button
    private lateinit var nombre: EditText
    private lateinit var contrasena: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_layout)
        boton = findViewById(R.id.button);
        nombre = findViewById(R.id.nombre);
        contrasena = findViewById(R.id.contrasena);
    }

    override fun onStart() {
        super.onStart()
        boton.setOnClickListener{
            //Compruebo el login antes de entrar a la siguiente pagina
            if (nombre.getText().toString() == "ikerberna0@gmail.com" && contrasena.getText()
                    .toString() == "1234"
            ) {
                val intent = Intent(applicationContext, MainActivity2::class.java)
                startActivity(intent)
            }
        }
    }
}