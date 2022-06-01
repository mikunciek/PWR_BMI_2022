package com.example.bmi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class calculateBMI : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_bmi)

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
            findViewById<TextView>(R.id.bmiValue).text =
                "Twoje BMI wynosi: " + "%.2f".format(bmi.calculateBMI())
            //info o bmi
            val info = bmi.toString()
            findViewById<TextView>(R.id.viewInfoBMI).text = "Twój wynik: $info"
            //wyświetlenie ukrytej akcji - zrób quiz

            //dodanie do bazy danych
            val dataBase = databaseHandler(this)
            dataBase.addBMI(bmi)
            Toast.makeText(this, "BMI dodane", Toast.LENGTH_SHORT).show()

        }

        //akcje powrotu
        val back: Button = findViewById(R.id.backMainMenu)
        back.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }


        val library: Button = findViewById(R.id.backViewResolut)
        library.setOnClickListener {
            this.startActivity(Intent(this, libraryPDF::class.java))
        }


    }
}


