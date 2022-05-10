package com.example.pedometer

import android.app.ActionBar
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.lang.String
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*


class MainActivity2 : AppCompatActivity() {


//    var daysteps1 = findViewById<TextView>(R.id.daysteps1)



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


//            daysteps1!!.text = dayStat_i.toString()

        }

//        day1!!.text = content
        day1.setText(content)


    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)

        takeStats()

        getSupportActionBar()?.setTitle("Pedometer")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)



    }



}
