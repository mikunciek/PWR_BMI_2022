@file:Suppress("NAME_SHADOWING")

package com.example.bmi

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculate_bmi.*
import java.text.SimpleDateFormat
import java.util.*


class CalculateBMI : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_bmi)

        //initial states
        quizOpen.visibility = View.INVISIBLE
        val sdfTmp = SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY)
        showDate.text = sdfTmp.format(Date())

        ShowDialog.setOnClickListener {
            viewDatePicker()
        }

        save.setOnClickListener { //error handling - the field cannot empty - early return
            if (editWeightNumber.text.isNullOrBlank() || editHeightNumber.text.isNullOrBlank()) {
                if (editWeightNumber.text.isNullOrBlank()) {
                    weightContainer.error = "Wymagane*"
                }
                if (editHeightNumber.text.isNullOrBlank()) {
                    heightContainer.error = "Wymagane*"
                }
                return@setOnClickListener
            }
            //appears when the field is not empty
            weightContainer.helperText = "Podaj wagę"
            heightContainer.helperText = "Podaj wzrost"

            val date = showDate
            val weight = editWeightNumber.text.toString().toDouble()
            val height = editHeightNumber.text.toString().toDouble()
            val bmi = BMI(weight, height, date.text.toString())

            bmiValue.text = "Twoje BMI wynosi: " + "%.2f".format(bmi.calculateBMI())
            val info = bmi.toString()
            viewInfoBMI.text = "Twój wynik: $info"

            val dataBase = DatabaseHandler(this)
            dataBase.addBMI(bmi)
            Toast.makeText(this, "BMI dodane", Toast.LENGTH_SHORT).show()

            quizOpen.visibility = View.VISIBLE //display a hidden action - take a quiz
            quizOpen.setOnClickListener {
                this.startActivity(Intent(this, QuizLife::class.java))
            }
        }

        backMainMenu.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }

        backViewResolut.setOnClickListener {
            this.startActivity(Intent(this, PreviousTable::class.java))
        }
    }

    private fun viewDatePicker() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(this,{ _, year, month, dayOfMonth ->
                val sdfChange = SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY)
                cal.set(year, month, dayOfMonth)
                showDate.text = sdfChange.format(cal.time)
            }, year, month, day)
        datePicker.show()
    }
}