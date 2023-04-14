package com.example.app01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    private lateinit var nombre: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        nombre=findViewById(R.id.nombre)
        val obj: Intent=intent
        var name = obj.getStringExtra("nobre")
        nombre.text = "HOla $name"
    }

}