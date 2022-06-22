package com.example.bmi

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "bmi"
        private const val TABLE_BMI_STATS = "bmi_stats"
        private const val KEY_DATE = "date"
        private const val KEY_WEIGHT = "weight"
        private const val KEY_HEIGHT = "height"
    }
    //$key - by ułatwić pracę w zapytaniach, drukowane - typy danych
    // Creating Tables
    override fun onCreate(db: SQLiteDatabase) {
        val createTableBMIStatistic =
            ("CREATE TABLE $TABLE_BMI_STATS  (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " $KEY_DATE DATE, $KEY_WEIGHT DOUBLE, $KEY_HEIGHT DOUBLE)")
        db.execSQL(createTableBMIStatistic)
    }

    // Upgrading database - zmiany między wersjami, czysta baza
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS $TABLE_BMI_STATS")
        // Create tables again
        onCreate(db)
    }

    //clear base
    fun clear() {
        val db = this.writableDatabase
        db.execSQL("DROP TABLE IF EXISTS $TABLE_BMI_STATS")
        // Create tables again
        onCreate(db)
    }

    // code to add the new value - dodaje nowy wiersz do bazy
    fun addBMI(bmi: BMI) {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(KEY_DATE, bmi.date)
        values.put(KEY_WEIGHT, bmi.weight)
        values.put(KEY_HEIGHT, bmi.height)

        db.insert(
            TABLE_BMI_STATS,
            null,
            values
        )  // Inserting Row - creates new row in table
        db.close() // Closing database connection
    }

    @SuppressLint("Range", "Recycle")
    fun allData(): List<BMI> { //creates a list of objects
        //* - stands for any string, extracts all columns here

        val date: MutableList<BMI> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_BMI_STATS"
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {  // looping through all rows and adding to list
            do {
                val bmi = BMI( //create object
                    cursor.getDouble(cursor.getColumnIndex(KEY_WEIGHT)),
                    cursor.getDouble(cursor.getColumnIndex(KEY_HEIGHT)),
                    cursor.getString(cursor.getColumnIndex(KEY_DATE)),
                    cursor.getInt(cursor.getColumnIndex("id"))
                )
                date.add(bmi) //add to list
            } while (cursor.moveToNext())
        }
        return date
    }

    @SuppressLint("Recycle")
    fun delLastItem() { //delete last element of list
        val selectQuery = "SELECT id FROM $TABLE_BMI_STATS ORDER BY id DESC LIMIT 1"
        var db = this.readableDatabase
        var id: String? = null
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            id = cursor.getString(0)
        }

        if (id === null) {
            return
        }

        db = this.writableDatabase
        db.delete(TABLE_BMI_STATS, "id=?", arrayOf(id))
        db.close() //closes the connection
    }
}