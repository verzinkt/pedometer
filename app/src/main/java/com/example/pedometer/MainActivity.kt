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
import android.widget.ImageView


class MainActivity : AppCompatActivity(), SensorEventListener {


    fun func_history (view: View) {
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, MainActivity2::class.java)
        // Start the new activity.
        startActivity(randomIntent)

    }


    fun func_achievement (view: View) {
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, MainActivity3::class.java)
        // Start the new activity.
        startActivity(randomIntent)
    }




    // Added SensorEventListener the MainActivity class
    // Implement all the members in the class MainActivity
    // after adding SensorEventListener

    // we have assigned sensorManger to nullable
    private var sensorManager: SensorManager? = null

    // Creating a variable which will give the running status
    // and initially given the boolean value as false
    private var running = false

    // !!!Creating a variable which will counts total steps
    // and it has been given the value of 0 float
    private var totalSteps = 0f




    // !!!Creating a variable which counts previous total
    // steps and it has also been given the value of 0 float
    private var previousTotalSteps = 0f

    private var futurePurpose = 0L
    //private var prevStepPurpose = 0
    public var STEP = 15;

    public final var SDF = SimpleDateFormat("dd/MM/yyyy")
    public var currentDayDate = SDF.format(Date()).toString();
    //
    public var startDayStepCount = 0f;

//    var tvView: TextView? = null
//    var imageView: ImageView? = null


    var newvar = 8000f





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadData()


        // Adding a context of SENSOR_SERVICE aas Sensor Manager
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        var tvView = findViewById<TextView>(R.id.tvView)
        val intent = intent
        val lName = intent.getStringExtra("lname")


        if (lName !== null){
            newvar = lName.toString().toFloat()
            tvView!!.text = "$newvar"
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


//            val randomIntent = Intent(this, MainActivity4::class.java)
//            startActivity(randomIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        running = true

        // !!!Returns the number of steps taken by the user since the last reboot while activated
        // This sensor requires permission android.permission.ACTIVITY_RECOGNITION.
        // So don't forget to add the following permission in AndroidManifest.xml present in manifest folder of the app.
        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)


        if (stepSensor == null) {
            // This will give a toast message to the user if there is no sensor in the device
            Toast.makeText(this, "No sensor detected on this device", Toast.LENGTH_SHORT).show()
        } else {
            // Rate suitable for the user interface
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {

        // Calling the TextView that we made in activity_main.xml
        // by the id given to that TextView
        var tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)



        //var tv_stepsPre = findViewById<TextView>(R.id.tv_stepsPre)

        if (running) {



            totalSteps = event!!.values[0]

            // !!!Current steps are calculated by taking the difference of total steps
            // and previous steps

            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()


            // It will show the current steps to the user
            tv_stepsTaken.text = ("$currentSteps")





            val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)

            circularProgressBar.apply {

                // or with animation
                setProgressWithAnimation(currentSteps.toFloat(), 1000) // =1s

                progressMax = newvar

                // Set ProgressBar Color
                progressBarColor = Color.GREEN

                // Set Width
                progressBarWidth = 7f // in DP
                backgroundProgressBarWidth = 3f // in DP
            }

            //tv_stepsTotal.text = ("$totalSteps")
            //tv_stepsPre.text = ("$previousTotalSteps")
        }
        // check purpose
        if (futurePurpose == 0L || futurePurpose <= totalSteps.toInt()) {
            var currentLevel = totalSteps.toInt() / STEP;
            //Toast.makeText(this, "LOG: " + totalSteps.toInt() + "/ futurePurpose=" + futurePurpose, Toast.LENGTH_SHORT).show();
            futurePurpose = (currentLevel * STEP + STEP).toLong();
        }

        //
        // backup days step count
        if (startDayStepCount == 0f)
            startDayStepCount = totalSteps

        var currentDate = SDF.format(Date())
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getFloat(currentDayDate, 0f)
        //Toast.makeText(this, "1_currentDayDate=" + currentDayDate + "; savedNumber=" + savedNumber, Toast.LENGTH_SHORT).show();

        if (!currentDayDate.equals(currentDate.toString(), true)) {
            saveData(currentDayDate, totalSteps - startDayStepCount)
            Toast.makeText(this, "За " + currentDayDate + " число было пройдено Шагов =  " + (totalSteps - startDayStepCount - 10), Toast.LENGTH_SHORT).show();
            //val dalIntent = Intent(this, MainActivity2::class.java)
            //dalIntent.putExtra(MainActivity2.KEY, daily)
            //startActivity(dalIntent)

            currentDayDate = currentDate.toString()
            saveData("currentDayDate", currentDayDate)

            startDayStepCount = totalSteps
            saveData("startDayStepCount", startDayStepCount)
        }
        else {
            saveData("currentDayDate", currentDayDate)
            saveData("startDayStepCount", startDayStepCount)
        }
       //all
        saveData("total", totalSteps)
        Toast.makeText(this,  currentDayDate + "; Шагов за сегодня = " + (totalSteps - startDayStepCount), Toast.LENGTH_SHORT).show();
    }

    fun resetSteps() {
        var tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)
        tv_stepsTaken.setOnClickListener {
            // This will give a toast message if the user want to reset the steps
            Toast.makeText(this, "Долгое нажатия для сброса шагов", Toast.LENGTH_SHORT).show()


        }

        tv_stepsTaken.setOnLongClickListener {

            val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)

            circularProgressBar.apply {

                // or with animation
                setProgressWithAnimation(0f, 1000) // =1s

                // Set Progress Max
                //progressMax = 100f

                // Set ProgressBar Color
                progressBarColor = Color.GREEN

                // Set Width
                progressBarWidth = 7f // in DP
                backgroundProgressBarWidth = 3f // in DP
            }


            previousTotalSteps = totalSteps

            // When the user will click long tap on the screen,
            // the steps will be reset to 0
            tv_stepsTaken.text = 0.toString()

            // This will save the data
            saveData("key1", previousTotalSteps)

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

        // In this function we will retrieve data
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getFloat("key1", 0f)
        val savedDayNumber = sharedPreferences.getFloat("startDayStepCount", 0f)

        val sharedPreferencesString = getSharedPreferences("myPrefsString", Context.MODE_PRIVATE)
        val currentDayDateFromDB = sharedPreferencesString.getString("currentDayDate", SDF.format(Date()).toString())
        // Log.d is used for debugging purposes
        Log.d("MainActivity", "$savedNumber")

        previousTotalSteps = savedNumber
        startDayStepCount = savedDayNumber
        currentDayDate = currentDayDateFromDB!!
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // We do not have to write anything in this function for this app
    }
}
