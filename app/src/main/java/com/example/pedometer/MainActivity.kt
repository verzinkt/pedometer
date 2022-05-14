package com.example.pedometer

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import java.text.SimpleDateFormat
import java.util.*



class MainActivity : AppCompatActivity(), SensorEventListener {


    fun func_history (view: View) {

        val randomIntent = Intent(this, MainActivity2::class.java)

        startActivity(randomIntent)

    }


    fun func_achievement (view: View) {

        val randomIntent = Intent(this, MainActivity3::class.java)

        startActivity(randomIntent)
    }


    private var sensorManager: SensorManager? = null
    private var isrunning = false
    private var totalS = 0f
    private var prTotal = 0f

    public final var SDF = SimpleDateFormat("dd/MM/yyyy")
    public var currentDayDate = SDF.format(Date()).toString();
    public var startDayStepCount = 0f;



    var newvar = 8000f





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadData()


        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        var goal = findViewById<TextView>(R.id.goal)
        val intent = intent
        val varInte = intent.getStringExtra("varInte")





        if (varInte !== null){
            newvar = varInte.toString().toFloat()
            goal!!.text = String.format("%.0f", newvar)
        }

        resetSteps()




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_third_menu -> {val randomIntent = Intent(this, MainActivity4::class.java);
                                    startActivity(randomIntent)}

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        isrunning = true

        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)


        if (stepSensor == null) {

            Toast.makeText(this, "Необходимый сенсор не найден на устройстве", Toast.LENGTH_SHORT).show()
        } else {

            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {


        var steps = findViewById<TextView>(R.id.steps)


        if (isrunning) {


            totalS = event!!.values[0]


            val currentSteps = totalS.toInt() - prTotal.toInt()


            steps.text = ("$currentSteps")


            val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)

            circularProgressBar.apply {


                setProgressWithAnimation(currentSteps.toFloat(), 1000) // =1s

                progressMax = newvar

                progressBarColor = Color.BLUE

                progressBarWidth = 7f // in DP
                backgroundProgressBarWidth = 3f // in DP
            }


        }


        if (startDayStepCount == 0f)
            startDayStepCount = totalS

        var currentDate = SDF.format(Date())
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getFloat(currentDayDate, 0f)


        if (!currentDayDate.equals(currentDate.toString(), true)) {
            saveData(currentDayDate, totalS - startDayStepCount)


            currentDayDate = currentDate.toString()
            saveData("currentDayDate", currentDayDate)

            startDayStepCount = totalS
            saveData("startDayStepCount", startDayStepCount)
        } else {
            saveData("currentDayDate", currentDayDate)
            saveData("startDayStepCount", startDayStepCount)
        }

        saveData("total", totalS)
    }

    fun resetSteps() {
        var steps = findViewById<TextView>(R.id.steps)
        steps.setOnClickListener {

            Toast.makeText(this, "Долгое нажатия для сброса шагов", Toast.LENGTH_SHORT).show()


        }

        steps.setOnLongClickListener {

            val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)

            circularProgressBar.apply {

                setProgressWithAnimation(0f, 1000) // =1s

                progressBarColor = Color.BLUE

                progressBarWidth = 7f // in DP
                backgroundProgressBarWidth = 3f // in DP
            }


            prTotal = totalS


            steps.text = 0.toString()


            saveData("firstKey", prTotal)

            true
        }
    }

    private fun saveData(key: String, value: Float) {
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    private fun saveData(key: String, value: String) {
        val sharedPreferences = getSharedPreferences("myPrefsString", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    private fun loadData()  {

        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getFloat("firstKey", 0f)
        val savedDayNumber = sharedPreferences.getFloat("startDayStepCount", 0f)

        val sharedPreferencesString = getSharedPreferences("myPrefsString", Context.MODE_PRIVATE)
        val currentDayDateFromDB = sharedPreferencesString.getString("currentDayDate", SDF.format(Date()).toString())

        Log.d("MainActivity", "$savedNumber")

        prTotal = savedNumber
        startDayStepCount = savedDayNumber
        currentDayDate = currentDayDateFromDB!!
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}
