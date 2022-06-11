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

    // Creating Tables
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE_BMI_STATS =

            //$key - by ułatwić pracę w zapytaniach, drukowane - typy danych

            ("CREATE TABLE $TABLE_BMI_STATS  (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " $KEY_DATE DATE, $KEY_WEIGHT DOUBLE, $KEY_HEIGHT DOUBLE)")
        db.execSQL(CREATE_TABLE_BMI_STATS)
    }

    // Upgrading database - zmiany między wersjami, czysta baza

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS $TABLE_BMI_STATS ")
        // Create tables again
        onCreate(db)
    }

    fun clear() {
        val db = this.writableDatabase
        db.execSQL("DROP TABLE IF EXISTS $TABLE_BMI_STATS ")
        // Create tables again
        onCreate(db)
    }

    // code to add the new value - dodaje nowy wiersz do bazy
    fun addBMI(bmi: BMI) {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(KEY_DATE, bmi.date.toString())
        values.put(KEY_WEIGHT, bmi.weight)
        values.put(KEY_HEIGHT, bmi.height)

        // Inserting Row - utworzenie nowego wiersza w tabeli
        db.insert(TABLE_BMI_STATS, null, values)
        db.close() // Closing database connection
    }


    @SuppressLint("Range")
    fun allData(): List<BMI> { //tworzy listę obiektów bmi

        val date: MutableList<BMI> = ArrayList()
        // select - wybiera wszystko co jest w bazie wg określonych kryteriów
        //* - oznacza dowolny ciąg znaków, tutaj wyciąga wszystkie kolumny
        val selectQuery = "SELECT * FROM $TABLE_BMI_STATS"

        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery(selectQuery, null)

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                val bmi = BMI( //stworzenie obiektu
                    cursor.getDouble(cursor.getColumnIndex(KEY_WEIGHT)),
                    cursor.getDouble(cursor.getColumnIndex(KEY_HEIGHT)),
                    cursor.getString(cursor.getColumnIndex(KEY_DATE)),
                    cursor.getInt(cursor.getColumnIndex("id"))
                )

                date.add(bmi) //dodanie do listy
            } while (cursor.moveToNext()) //pętla się kończy w momencie gdy nie ma kolejnego
        }
        return date
    }

    fun delLastItem()
    {
        val selectQuery = "SELECT id FROM $TABLE_BMI_STATS ORDER BY id DESC LIMIT 1"
        val deleteQuery = "DELETE FROM $TABLE_BMI_STATS WHERE id=?"
        var db = this.readableDatabase
        var id: String? = null;

        val cursor = db.rawQuery(selectQuery, null)

        if(cursor.moveToFirst()) {
            id = cursor.getString(0)
        }

        if(id === null) {
            return
        }

        db = this.writableDatabase
        db.delete(
            TABLE_BMI_STATS,"id=?", arrayOf(id)
        )
        db.close() //zamyka połaczenie
    }
}
