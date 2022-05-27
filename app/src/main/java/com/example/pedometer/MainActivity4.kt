package com.example.pedometer


import android.os.Bundle
import android.content.Intent
import android.view.View

import android.widget.EditText


import android.view.View.OnClickListener
import android.widget.Button


import android.app.Activity
import android.content.Context
import android.provider.Settings




class MainActivity4 : Activity(), OnClickListener {



    var evarInte: EditText? = null
    var btnSubmit: Button? = null


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        evarInte = findViewById<View>(R.id.evarInte) as EditText
        btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        btnSubmit!!.setOnClickListener(this)

    }



    override fun onClick(v: View?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("varInte", evarInte!!.text.toString())

        startActivity(intent)
    }



    fun allSettings (view: View) {
        startActivity(Intent(Settings.ACTION_SETTINGS))
    }


}