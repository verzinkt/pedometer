package com.example.pedometer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView

import android.widget.ImageView


class MainActivity3 : AppCompatActivity() {

    companion object{
        const val KEY = "key"
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main3)

        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val stepsforach = sharedPreferences.getFloat("total", 0f)


        if (stepsforach >= 1){
            var name1 = findViewById<TextView>(R.id.name1)
            var ava1 = findViewById<ImageView>(R.id.ava1)
            var zamok1 = findViewById<ImageView>(R.id.zamok1)
            name1.setTextColor(getResources().getColor(R.color.black))
            ava1.setImageResource(R.drawable.ic_flag)
            zamok1.setImageResource(R.drawable.ic_unlock)
        }
        if (stepsforach >= 50){
            var name2 = findViewById<TextView>(R.id.name2)
            var ava2 = findViewById<ImageView>(R.id.ava2)
            var zamok2 = findViewById<ImageView>(R.id.zamok2)
            name2.setTextColor(getResources().getColor(R.color.black))
            ava2.setImageResource(R.drawable.ic_ulitka)
            zamok2.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 100){
            var name3 = findViewById<TextView>(R.id.name3)
            var ava3 = findViewById<ImageView>(R.id.ava3)
            var zamok3 = findViewById<ImageView>(R.id.zamok3)
            name3.setTextColor(getResources().getColor(R.color.black))
            ava3.setImageResource(R.drawable.ic_lenivets)
            zamok3.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 250){
            var name4 = findViewById<TextView>(R.id.name4)
            var ava4 = findViewById<ImageView>(R.id.ava4)
            var zamok4 = findViewById<ImageView>(R.id.zamok4)
            name4.setTextColor(getResources().getColor(R.color.black))
            ava4.setImageResource(R.drawable.ic_turtle)
            zamok4.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 500){
            var name5 = findViewById<TextView>(R.id.name5)
            var ava5 = findViewById<ImageView>(R.id.ava5)
            var zamok5 = findViewById<ImageView>(R.id.zamok5)
            name5.setTextColor(getResources().getColor(R.color.black))
            ava5.setImageResource(R.drawable.ic_baby)
            zamok5.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 666){
            var name6 = findViewById<TextView>(R.id.name6)
            var ava6 = findViewById<ImageView>(R.id.ava6)
            var zamok6 = findViewById<ImageView>(R.id.zamok6)
            name6.setTextColor(getResources().getColor(R.color.black))
            ava6.setImageResource(R.drawable.ic_animal)
            zamok6.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 777){
            var name7 = findViewById<TextView>(R.id.name7)
            var ava7 = findViewById<ImageView>(R.id.ava7)
            var zamok7 = findViewById<ImageView>(R.id.zamok7)
            name7.setTextColor(getResources().getColor(R.color.black))
            ava7.setImageResource(R.drawable.ic_clover)
            zamok7.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 1121){
            var name8 = findViewById<TextView>(R.id.name8)
            var ava8 = findViewById<ImageView>(R.id.ava8)
            var zamok8 = findViewById<ImageView>(R.id.zamok8)
            name8.setTextColor(getResources().getColor(R.color.black))
            ava8.setImageResource(R.drawable.ic_park)
            zamok8.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 3333){
            var name9 = findViewById<TextView>(R.id.name9)
            var ava9 = findViewById<ImageView>(R.id.ava9)
            var zamok9 = findViewById<ImageView>(R.id.zamok9)
            name9.setTextColor(getResources().getColor(R.color.black))
            ava9.setImageResource(R.drawable.ic_three)
            zamok9.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 4444){
            var name10 = findViewById<TextView>(R.id.name10)
            var ava10 = findViewById<ImageView>(R.id.ava10)
            var zamok10 = findViewById<ImageView>(R.id.zamok10)
            name10.setTextColor(getResources().getColor(R.color.black))
            ava10.setImageResource(R.drawable.ic_four)
            zamok10.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 5555){
            var name11 = findViewById<TextView>(R.id.name11)
            var ava11 = findViewById<ImageView>(R.id.ava11)
            var zamok11 = findViewById<ImageView>(R.id.zamok11)
            name11.setTextColor(getResources().getColor(R.color.black))
            ava11.setImageResource(R.drawable.ic_five)
            zamok11.setImageResource(R.drawable.ic_unlock)
        }
        if (stepsforach >= 6000){
            var name12 = findViewById<TextView>(R.id.name12)
            var ava12 = findViewById<ImageView>(R.id.ava12)
            var zamok12 = findViewById<ImageView>(R.id.zamok12)
            name12.setTextColor(getResources().getColor(R.color.black))
            ava12.setImageResource(R.drawable.ic_fizruk)
            zamok12.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 7000){
            var name13 = findViewById<TextView>(R.id.name13)
            var ava13 = findViewById<ImageView>(R.id.ava13)
            var zamok13 = findViewById<ImageView>(R.id.zamok13)
            name13.setTextColor(getResources().getColor(R.color.black))
            ava13.setImageResource(R.drawable.ic_sportsman)
            zamok13.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 8000){
            var name14 = findViewById<TextView>(R.id.name14)
            var ava14 = findViewById<ImageView>(R.id.ava14)
            var zamok14 = findViewById<ImageView>(R.id.zamok14)
            name14.setTextColor(getResources().getColor(R.color.black))
            ava14.setImageResource(R.drawable.ic_zdorovyak)
            zamok14.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 8848){
            var name15 = findViewById<TextView>(R.id.name15)
            var ava15 = findViewById<ImageView>(R.id.ava15)
            var zamok15 = findViewById<ImageView>(R.id.zamok15)
            name15.setTextColor(getResources().getColor(R.color.black))
            ava15.setImageResource(R.drawable.ic_everest)
            zamok15.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 10000){
            var name16 = findViewById<TextView>(R.id.name16)
            var ava16 = findViewById<ImageView>(R.id.ava16)
            var zamok16 = findViewById<ImageView>(R.id.zamok16)
            name16.setTextColor(getResources().getColor(R.color.black))
            ava16.setImageResource(R.drawable.ic_atlet)
            zamok16.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 15000){
            var name17 = findViewById<TextView>(R.id.name17)
            var ava17 = findViewById<ImageView>(R.id.ava17)
            var zamok17 = findViewById<ImageView>(R.id.zamok17)
            name17.setTextColor(getResources().getColor(R.color.black))
            ava17.setImageResource(R.drawable.ic_profi)
            zamok17.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 20000){
            var name18 = findViewById<TextView>(R.id.name18)
            var ava18 = findViewById<ImageView>(R.id.ava18)
            var zamok18 = findViewById<ImageView>(R.id.zamok18)
            name18.setTextColor(getResources().getColor(R.color.black))
            ava18.setImageResource(R.drawable.ic_master)
            zamok18.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 25000){
            var name19 = findViewById<TextView>(R.id.name19)
            var ava19 = findViewById<ImageView>(R.id.ava19)
            var zamok19 = findViewById<ImageView>(R.id.zamok19)
            name19.setTextColor(getResources().getColor(R.color.black))
            ava19.setImageResource(R.drawable.ic_msmk)
            zamok19.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 30303){
            var name20 = findViewById<TextView>(R.id.name20)
            var ava20 = findViewById<ImageView>(R.id.ava20)
            var zamok20 = findViewById<ImageView>(R.id.zamok20)
            name20.setTextColor(getResources().getColor(R.color.black))
            ava20.setImageResource(R.drawable.ic_bolt)
            zamok20.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 40000){
            var name21 = findViewById<TextView>(R.id.name21)
            var ava21 = findViewById<ImageView>(R.id.ava21)
            var zamok21 = findViewById<ImageView>(R.id.zamok1)
            name21.setTextColor(getResources().getColor(R.color.black))
            ava21.setImageResource(R.drawable.ic_soroka)
            zamok21.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 42000){
            var name22 = findViewById<TextView>(R.id.name22)
            var ava22 = findViewById<ImageView>(R.id.ava22)
            var zamok22 = findViewById<ImageView>(R.id.zamok22)
            name22.setTextColor(getResources().getColor(R.color.black))
            ava22.setImageResource(R.drawable.ic_marafon)
            zamok22.setImageResource(R.drawable.ic_unlock)
        }


        if (stepsforach >= 100000){
            var name23 = findViewById<TextView>(R.id.name23)
            var ava23 = findViewById<ImageView>(R.id.ava23)
            var zamok23 = findViewById<ImageView>(R.id.zamok23)
            name23.setTextColor(getResources().getColor(R.color.black))
            ava23.setImageResource(R.drawable.ic_flash)
            zamok23.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 155571){
            var name24 = findViewById<TextView>(R.id.name24)
            var ava24 = findViewById<ImageView>(R.id.ava24)
            var zamok24 = findViewById<ImageView>(R.id.zamok24)
            name24.setTextColor(getResources().getColor(R.color.black))
            ava24.setImageResource(R.drawable.ic_mkad)
            zamok24.setImageResource(R.drawable.ic_unlock)
        }


        if (stepsforach >= 13065714){
            var name25 = findViewById<TextView>(R.id.name25)
            var ava25 = findViewById<ImageView>(R.id.ava25)
            var zamok25 = findViewById<ImageView>(R.id.zamok25)
            name25.setTextColor(getResources().getColor(R.color.black))
            ava25.setImageResource(R.drawable.ic_vladik)
            zamok25.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 57250000){
            var name26 = findViewById<TextView>(R.id.name26)
            var ava26 = findViewById<ImageView>(R.id.ava26)
            var zamok26 = findViewById<ImageView>(R.id.zamok26)
            name26.setTextColor(getResources().getColor(R.color.black))
            ava26.setImageResource(R.drawable.ic_ekvator)
            zamok26.setImageResource(R.drawable.ic_unlock)
        }

        if (stepsforach >= 549238571){
            var name27 = findViewById<TextView>(R.id.name27)
            var ava27 = findViewById<ImageView>(R.id.ava27)
            var zamok27 = findViewById<ImageView>(R.id.zamok27)
            name27.setTextColor(getResources().getColor(R.color.black))
            ava27.setImageResource(R.drawable.ic_moon)
            zamok27.setImageResource(R.drawable.ic_unlock)
        }



        getSupportActionBar()?.setTitle("Шагомер")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)



    }

}
