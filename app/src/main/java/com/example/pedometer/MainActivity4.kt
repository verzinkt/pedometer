package com.example.pedometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

import android.view.View.OnClickListener
import android.widget.Button


import android.app.Activity
import android.provider.Settings
import android.view.Menu



class MainActivity4 : Activity(), OnClickListener {



    var etLName: EditText? = null
    var btnSubmit: Button? = null

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        etLName = findViewById<View>(R.id.etLName) as EditText
        btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        btnSubmit!!.setOnClickListener(this)

    }



    override fun onClick(v: View?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("lname", etLName!!.text.toString())

        startActivity(intent)
    }



    fun allSettings (view: View) {
        startActivity(Intent(Settings.ACTION_SETTINGS))
    }

}