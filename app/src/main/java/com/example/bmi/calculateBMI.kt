package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class calculateBMI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_bmi)

        val weight = (EditText(findViewById(R.id.editweightNumber))) as Double
        val height = (EditText(findViewById(R.id.editheightNumber))) as Double

        val bmi = BMI(weight,height)

        val valueBMI = bmi.calculateBMI()

    }
}


