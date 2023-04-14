package com.example.app01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var boton: Button
    private lateinit var texto: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()
    }

    fun bind(){
        boton = findViewById(R.id.button)
        texto = findViewById(R.id.texto)
    }

    fun addListener(){

        boton.setOnClickListener {
            var intent = Intent(MainActivity@this, MainActivity2::class.java)
            intent.putExtra("nobre", texto.text.toString())
            startActivity(intent)
        }

    }
}