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

        //deklaracja stanów początkowych
        quizOpen.visibility = View.INVISIBLE
        val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY)
        showDate.text = sdf.format(Date())



        ShowDialog.setOnClickListener { //wybór daty
            viewDatePicker()
        }

        save.setOnClickListener {
            //obsługa błędów, żeby pole nie było puste - wczesne zwrócenie
            if(editWeightNumber.text.isNullOrBlank() || editHeightNumber.text.isNullOrBlank()){

               if(editWeightNumber.text.isNullOrBlank()){
                   weightContainer.error = "Wymagane*"
               }

                if(editHeightNumber.text.isNullOrBlank()){
                    heightContainer.error ="Wymagane*"
                }
                return@setOnClickListener
            }

            weightContainer.helperText = "Podaj wagę"
            heightContainer.helperText = "Podaj wzrost"


            val date = showDate   //data
            val weight = editWeightNumber.text.toString().toDouble()    //waga
            val height = editHeightNumber.text.toString().toDouble()   //wzrost


            val bmi = BMI(weight, height, date.text.toString())    //obliczenie bmi
            bmiValue.text = "Twoje BMI wynosi: " + "%.2f".format(bmi.calculateBMI())

            val info = bmi.toString()   //info o bmi
            viewInfoBMI.text = "Twój wynik: $info"

            val dataBase = DatabaseHandler(this)    //dodanie do bazy danych
            //dataBase.clear()
            dataBase.addBMI(bmi)
            Toast.makeText(this, "BMI dodane", Toast.LENGTH_SHORT).show()

            quizOpen.visibility = View.VISIBLE //wyświetlenie ukrytej akcji - zrób quiz


            quizOpen.setOnClickListener {
                this.startActivity(Intent(this, QuizLife::class.java))
            }
        }

        backMainMenu.setOnClickListener { //powrót do menu
            this.startActivity(Intent(this, MainActivity::class.java))
        }

        backViewResolut.setOnClickListener { //zobacz poprzednie wyniki
            this.startActivity(Intent(this, PreviousTable::class.java))
        }

    }

    private fun viewDatePicker() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(   //okno kalendarza
            this,
            { _, year, month, dayOfMonth ->
                val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY)
                showDate.text = sdf.format(c.time)
            }, year, month, day
        )
        datePicker.show()
    }
}




