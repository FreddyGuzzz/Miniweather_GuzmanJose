package com.guzmanjose.miniweather_guzmanj

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.guzmanjose.miniweather_guzmanj.utilities.WeatherService

class CityActivity : AppCompatActivity() {

    var citySelected: String = ""
    private lateinit var btnSaveCity: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
        btnSaveCity = findViewById(R.id.btn_save_city)
        btnSaveCity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val service: WeatherService = WeatherService(this)
        val nextButton:Button = findViewById<Button>(R.id.btn_save_city)
        val citySelector: Spinner = findViewById<Spinner>(R.id.city_selector)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, service.getCities())

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        citySelector.adapter = adapter

        citySelector.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                citySelected = p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}