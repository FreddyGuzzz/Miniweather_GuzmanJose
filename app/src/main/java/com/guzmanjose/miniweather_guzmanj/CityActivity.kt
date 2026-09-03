package com.guzmanjose.miniweather_guzmanj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CityActivity : AppCompatActivity() {
    private lateinit var btnSaveCity: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
        btnSaveCity = findViewById(R.id.btn_save_city)
        btnSaveCity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}