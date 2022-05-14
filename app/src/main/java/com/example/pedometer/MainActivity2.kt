package com.example.pedometer


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView

import androidx.annotation.RequiresApi
import java.lang.String

import java.time.LocalDateTime

import java.time.format.DateTimeFormatter



class MainActivity2 : AppCompatActivity() {






    public final var SDF = "dd/MM/yyyy"
    companion object{
        const val KEY = "key"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun takeStats () {

        var day1 = findViewById<TextView>(R.id.day1)


        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        var formatter = DateTimeFormatter.ofPattern(SDF)
        var dateTime = LocalDateTime.now()
        var content = "";

        for (i in 1 until 8){




            var date = dateTime.minusDays(i.toLong()).format(formatter)
            val dayStat_i = sharedPreferences.getFloat(date, 0f)
            content = content + date + " кол-во шагов : " + String.format("%.0f", dayStat_i) + "\n" + "\n"




        }


        day1.setText(content)


    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)

        takeStats()

        getSupportActionBar()?.setTitle("Шагомер")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)



    }



}
