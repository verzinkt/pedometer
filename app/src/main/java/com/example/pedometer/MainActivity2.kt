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


//package com.example.pedometer
//
//
//import android.app.Activity
//import android.os.Bundle
//import android.view.View
//import android.widget.LinearLayout
//import com.example.pedometer.R
//import com.jjoe64.graphview.BarGraphView
//import com.jjoe64.graphview.GraphView
//import com.jjoe64.graphview.GraphViewSeries
//import com.jjoe64.graphview.GraphView.GraphViewData
//import com.jjoe64.graphview.LineGraphView
//
//class MainActivity2 : Activity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//
//        // Линейный график
//        val exampleSeries = GraphViewSeries(
//            arrayOf<GraphViewData>(
//                GraphViewData(1, 3.0),
//                GraphViewData(2, 1.5), GraphViewData(3, 2.5),
//                GraphViewData(4, 1.0), GraphViewData(5, 1.3)
//            )
//        )
//        val graphView: GraphView = LineGraphView(this, "График каких-то данных")
//        graphView.addSeries(exampleSeries)
//        val layout = findViewById<View>(R.id.layout) as LinearLayout
//        layout.addView(graphView)
//    }
//}