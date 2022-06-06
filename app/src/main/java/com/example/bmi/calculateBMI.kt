package com.example.bmi

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculate_bmi.*
import java.text.SimpleDateFormat
import java.util.*


class calculateBMI : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_bmi)

        //wybór daty
        ShowDialog.setOnClickListener{
            showDatePicker()
        }

        save.setOnClickListener {

            //if (answers === null) {
            //            throw Exception("Puste pytania")
            //        }

            //data
            val date = showDate
            //waga
            val weight = editweightNumber.text.toString().toDouble()
            //wzrost
            val height = editheightNumber.text.toString().toDouble()
            //obliczenie bmi
            val bmi = BMI(weight, height, date.text.toString())

            bmiValue.text = "Twoje BMI wynosi: " + "%.2f".format(bmi.calculateBMI())
            //info o bmi
            val info = bmi.toString()
            viewInfoBMI.text = "Twój wynik: $info"
            //wyświetlenie ukrytej akcji - zrób quiz

            //dodanie do bazy danych
            val dataBase = databaseHandler(this)
            dataBase.addBMI(bmi)
            Toast.makeText(this, "BMI dodane", Toast.LENGTH_SHORT).show()

        }

        //akcje powrotu

        backMainMenu.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }

        backViewResolut.setOnClickListener {
            this.startActivity(Intent(this, previousTable::class.java))
        }
    }


    @SuppressLint("SetTextI18n")
    private fun showDatePicker() {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        //create dialog

        val datePicker = DatePickerDialog(this,
        { _, year, month, dayOfMonth ->

            val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY)
            showDate.text = sdf.format(c.time)

        },year,month,day)

            datePicker.show()

        }
    }



