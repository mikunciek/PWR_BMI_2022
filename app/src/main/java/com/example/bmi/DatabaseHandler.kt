package com.example.bmi

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // Creating Tables
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_CONTACTS_TABLE =
            ("CREATE TABLE $TABLE_CONTACTS ($KEY_WEIGHT INTEGER, $KEY_HEIGHT INTEGER, " +
                    "$KEY_VALUE_BMI INTEGER, $KEY_DESCRIPTION_BMI TEXT)")
        db.execSQL(CREATE_CONTACTS_TABLE)
    }

    // Upgrading database
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")

        // Create tables again
        onCreate(db)
    }

    // code to add the new contact
    fun addBMI(bmi: BMI) {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(KEY_WEIGHT, bmi.weight)
        values.put(KEY_HEIGHT, bmi.height)
        values.put(KEY_VALUE_BMI, bmi.valueBMI)
        values.put(KEY_DESCRIPTION_BMI, bmi.descriptionBMI)


        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
    }

    // code to get the single contact
    fun getEmployee(pesel: String): BMI? {
        val db = this.readableDatabase
        val cursor: Cursor? = db.query(
            TABLE_CONTACTS,
            arrayOf(
                KEY_WEIGHT,
                KEY_HEIGHT,
                KEY_VALUE_BMI,
                KEY_DESCRIPTION_BMI
            ),
            "$KEY_WEIGHT=?",
            arrayOf(pesel),
            null,
            null,
            null,
            null
        )
        cursor?.moveToFirst()
        // return contact

        if (cursor == null) return null

        return BMI(

            cursor.getDouble(0),
            cursor.getDouble(1),
            cursor.getDouble(2),
            cursor.getString(3)
        )


    }


    // looping through all rows and adding to list
    // code to get all contacts in a list view
    /*
    val allEmployee: List<BMI>
        get() {
            val employees: MutableList<BMI> = ArrayList()
            // Select All Query
            val selectQuery = "SELECT  * FROM $TABLE_CONTACTS"
            val db = this.writableDatabase
            val cursor: Cursor = db.rawQuery(selectQuery, null)

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    val contact = BMI(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3).toInt()
                    )
                    employees.add(contact)
                } while (cursor.moveToNext())
            }

            // return employees list
            return employees
        }

     */

    // code to update the single contact

    /*
    fun updateEmployee(emp: BMI): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_PESEL, emp.pesel)
        values.put(KEY_NAME, emp.name)
        values.put(KEY_LAST_NAME, emp.lastName)
        values.put(KEY_DEP, emp.department.ordinal)

        // updating row
        return db.update(
            TABLE_CONTACTS,
            values,
            "$KEY_PESEL = ?",
            arrayOf(emp.pesel)
        )
    }

    // Deleting single contact
    fun deleteEmployee(emp: BMI) {
        val db = this.writableDatabase
        db.delete(TABLE_CONTACTS, "$KEY_PESEL = ?", arrayOf(emp.pesel))
        db.close()
    }// return count

    // Getting contacts Count
    val employeesCount: Int
        get() {
            val countQuery = "SELECT  * FROM $TABLE_CONTACTS"
            val db = this.readableDatabase
            val cursor: Cursor = db.rawQuery(countQuery, null)
            cursor.close()

            // return count
            return cursor.count
        }

     */

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "bmi"
        private const val TABLE_CONTACTS = "value_bmi"
        private const val KEY_WEIGHT = "weight"
        private const val KEY_HEIGHT = "height"
        private const val KEY_VALUE_BMI = "value_bmi"
        private const val KEY_DESCRIPTION_BMI = "description_bmi"
    }
}
