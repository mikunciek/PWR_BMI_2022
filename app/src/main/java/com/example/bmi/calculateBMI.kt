package com.example.bmi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculate_bmi.*
import kotlinx.android.synthetic.main.activity_view_pdf.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class calculateBMI : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_bmi)

        //val date: Button = findViewById(R.id.editDate)



        val saveDate: Button = findViewById(R.id.save)
        saveDate.setOnClickListener {

            //data
            val date = findViewById<TextView>(R.id.editDate)

            //waga
            val weight = findViewById<TextView>(R.id.editweightNumber).text.toString().toDouble()

            //wzrost
            val height = findViewById<TextView>(R.id.editheightNumber).text.toString().toDouble()

            //obliczenie bmi
            val bmi = BMI(weight, height, date.text.toString())
            findViewById<TextView>(R.id.bmiValue).text = "Twoje BMI wynosi: "+"%.2f".format(bmi.calculateBMI())

            //info o bmi
            val info = bmi.toString()
            findViewById<TextView>(R.id.viewInfoBMI).text = "Twój wynik: $info"

            //wyświetlenie ukrytej akcji - zrób quiz


            //dodanie do bazy danych
            val dataBase = databaseHandler(this)
            dataBase.addBMI(bmi)
            Toast.makeText(this, "BMI dodane", Toast.LENGTH_SHORT).show()
        }



    }
}


