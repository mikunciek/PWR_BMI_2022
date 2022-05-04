package com.example.bmi

class BMI(
    val weight : Double,
    val height : Double,
    val valueBMI : Double,
    val descriptionBMI : String

) {
    fun calculateBMI():Double {
        return weight/(height*height)
    }


}