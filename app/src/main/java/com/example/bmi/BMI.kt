package com.example.bmi

class BMI(
    val weight : Double,
    val height : Double,

) {
    fun calculateBMI():Double {
        return weight/(height*height)
    }


}