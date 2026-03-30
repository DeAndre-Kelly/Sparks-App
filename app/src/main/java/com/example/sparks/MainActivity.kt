/*
*
*
*
*
*
* */


package com.example.sparks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    //Declaration of variables
    private var timeOfDay: EditText? = null

    private var responseTxt: TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Initialising UI elements
        timeOfDay = findViewById(R.id.timeofday)
        responseTxt = findViewById(R.id.responseTxt)


        val sparkBtn = findViewById<Button>(R.id.sparkBtn)
        val resetBtn = findViewById<Button>(R.id.resetBtn)
        val responseTxt = findViewById<TextView>(R.id.responseTxt)






        //OnClickListner event for Spark button
        sparkBtn.setOnClickListener {
            checkTime()



        }

        //OnClickListner event for Reset button
        resetBtn.setOnClickListener {
            timeOfDay?.text?.clear()
            responseTxt?.text = "Spark Suggestions To Be Displayed Here!"






        }

    }
            private fun isNotEmpty(): Boolean {
                var b = true
                if (timeOfDay?.text.toString().isEmpty()) {
                    timeOfDay?.error = "PLEASE ENTER A TIME!"
                    b = false
                }
                return b
            }

    private fun checkTime() {
        if (isNotEmpty()) {

            val time = timeOfDay?.text.toString().trim().toInt()
            val response = when (time) {
                in 500..959 -> "Grab a coffee with a friend and catch up"
                in 1000..1159 -> "Take a morning walk with someone nearby"
                in 1200..1559 -> "Study or work together (in person or online)"
                in 1600..1759 -> "Go out for a quick shopping trip with a friend"
                in 1800..2059 -> "Host a small game night"
                in 2100..2359 -> "Have a deep conversation with someone you trust"
                else -> "Invalid Time! Please enter a valid time"
            }
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("responseTxt", response)
            responseTxt?.text = response

    }

            }

        }


