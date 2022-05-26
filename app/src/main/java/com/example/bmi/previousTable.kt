package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_calculate_bmi.*
import kotlinx.android.synthetic.main.activity_calculate_bmi.height
import kotlinx.android.synthetic.main.activity_calculate_bmi.weight
import java.util.*

class previousTable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_table)

        val db = databaseHandler(this)
        val list = db.allData()

        //db.clear()

        //make sure that the lists contain data or else display will be blank screen

        val params1 = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT, 1.0f
        )

        val params2 = TableRow.LayoutParams(
            TableRow.LayoutParams.FILL_PARENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )

        val tbl = findViewById<TableLayout>(R.id.layT)

        //i in 0..idList.size-1 - indicies zwraca zakres indeksu od pierwszej do ostatniej pozycji
        for (bmi in list) {

            //Creating new tablerows and textviews

            val row = TableRow(this)

            val idText = TextView(this)
            val dateText = TextView(this)
            val weightText = TextView(this)
            val heightText = TextView(this)
            val bmiText = TextView(this)
            val infoText = TextView(this)



            //setting the text

            idText.text = bmi.id.toString()
            dateText.text = bmi.date.toString()
            weightText.text = bmi.weight.toString()
            heightText.text = bmi.height.toString()
            bmiText.text = "%.2f".format(bmi.calculateBMI())
            infoText.text = bmi.toString()


            row.layoutParams = params2

            idText.layoutParams = params1
            dateText.layoutParams = params1
            weightText.layoutParams = params1
            heightText.layoutParams = params1
            bmiText.layoutParams = params1
            infoText.layoutParams = params1


            //the textviews have to be added to the row created

            row.addView(idText)
            row.addView(dateText)
            row.addView(weightText)
            row.addView(heightText)
            row.addView(bmiText)
            row.addView(infoText)

            tbl.addView(row)
        }
    }
}
