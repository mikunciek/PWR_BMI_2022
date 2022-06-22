package com.example.bmi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculate_bmi.backMainMenu
import kotlinx.android.synthetic.main.activity_previous_table.*

class PreviousTable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_table)

        //initial states
        graph.visibility = View.INVISIBLE
        val db = DatabaseHandler(this)
        updateTable()

        backMainMenu.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }

        deleteRow.setOnClickListener() {
            db.delLastItem()
            updateTable()
        }
    }


    @SuppressLint("SetTextI18n")
    private fun updateTable() {
        val db = DatabaseHandler(this)
        val list = db.allData()

        //make sure that the lists contain data or else display will be blank screen
        val params1 = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT, 0.05f)

        val tbl = findViewById<TableLayout>(R.id.layT)
        tbl.removeAllViews()

        var i = 1
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
            idText.text = i.toString()
            dateText.text = bmi.date
            weightText.text = bmi.weight.toString()
            heightText.text = bmi.height.toString()
            bmiText.text = "%.2f".format(bmi.calculateBMI())
            infoText.text = bmi.toString()


            //the textviews have to be added to the row created with style
            row.addView(idText,params1)
            row.addView(dateText, params1)
            row.addView(weightText,params1)
            row.addView(heightText,params1)
            row.addView(bmiText,params1)
            row.addView(infoText,params1)
            tbl.addView(row,params1)

            i++
        }

        if (list.size > 2) { //view graph if we have min. 3 resoult
            graph.visibility = View.VISIBLE
            graph.setOnClickListener {
                this.startActivity(Intent(this, GraphResult::class.java))
            }
        } else {
            graph.visibility = View.INVISIBLE
        }
    }


    private fun baseTable(){

        val params1 = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT, 0.05f
        )

        val row = TableRow(this)
        val idText = TextView(this)
        val dateText = TextView(this)
        val weightText = TextView(this)
        val heightText = TextView(this)
        val bmiText = TextView(this)
        val infoText = TextView(this)

        //setting the text
        idText.text = "ID"
        dateText.text = "DATE"
        weightText.text = "WAGA"
        heightText.text = "WZROST"
        bmiText.text = "BMI"
        infoText.text = "INFO"

        //the textviews have to be added to the row created with style
        row.addView(idText,params1)
        row.addView(dateText, params1)
        row.addView(weightText,params1)
        row.addView(heightText,params1)
        row.addView(bmiText,params1)
        row.addView(infoText,params1)
    }


}


