package com.example.pedometer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import java.util.*
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import android.widget.ImageView


class MainActivity3 : AppCompatActivity() {

    companion object{
        const val KEY = "key"
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main3)

        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val steps = sharedPreferences.getFloat("total", 0f)


        if (steps >= 10){
            var imageView = findViewById<ImageView>(R.id.imageView1)
            var imageView_Second = findViewById<ImageView>(R.id.imageView11)
            var text = findViewById<TextView>(R.id.textView1)
            imageView.setImageResource(R.drawable.blacksun)
            imageView_Second.setImageResource(R.drawable.blacksun)
            text.setText("okey")
        }


        if (steps >= 50){
            var imageView = findViewById<ImageView>(R.id.imageView2)
            var imageView_Second = findViewById<ImageView>(R.id.imageView22)
            var text = findViewById<TextView>(R.id.textView2)
            imageView.setImageResource(R.drawable.blacksun)
            imageView_Second.setImageResource(R.drawable.blacksun)
            text.setText("yes")
        }

        if (steps >= 100){
            var imageView = findViewById<ImageView>(R.id.imageView3)
            var imageView_Second = findViewById<ImageView>(R.id.imageView33)
            var text = findViewById<TextView>(R.id.textView3)
            imageView.setImageResource(R.drawable.blacksun)
            imageView_Second.setImageResource(R.drawable.blacksun)
            text.setText("complite")
        }


        getSupportActionBar()?.setTitle("Pedometer")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)



    }

}
