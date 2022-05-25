package com.example.bmi

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_previous_result.*
import kotlinx.android.synthetic.main.activity_previous_result.bmi
import kotlinx.android.synthetic.main.activity_previous_table.*
import java.util.*

class previousResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_result)


        val db = databaseHandler(this)
        val list = db.allData() //zwraca listę obiektów


        // access the listView from xml file
        val adapter: ArrayAdapter<BMI> =
            ArrayAdapter<BMI>(
                this,
                android.R.layout.simple_list_item_1, list
            )
        bmi.adapter = adapter
    }
}


