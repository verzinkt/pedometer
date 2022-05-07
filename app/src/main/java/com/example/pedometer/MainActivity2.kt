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
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*


class MainActivity2 : AppCompatActivity() {

    public final var SDF = "dd/MM/yyyy"
    companion object{
        const val KEY = "key"
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)

        getSupportActionBar()?.setTitle("Pedometer")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

    }






    @RequiresApi(Build.VERSION_CODES.O)
    fun takeStats () {


        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        var formatter = DateTimeFormatter.ofPattern(SDF)
        var dateTime = LocalDateTime.now()


        for (i in 1 until 11){
            var date = dateTime.minusDays(i.toLong()).format(formatter)
            val dayStat_i = sharedPreferences.getFloat(date, 0f)

        }



    }

}
