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

//i in 0..idList.size-1 - indicies zwraca zakres indeksu od pierwszej do ostatniej pozycji

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
            TableRow.LayoutParams.WRAP_CONTENT, 0.05f
        )

        val tbl = findViewById<TableLayout>(R.id.layT)
        //tbl.removeViewsInLayout(0, tbl.childCount) //we clean the "old" table and give the current data
        //tbl.removeViewAt(1) //we clean the "old" table and give the current data

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

            //style
            row.layoutParams = params1
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
}

