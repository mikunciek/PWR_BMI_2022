package com.example.bmi

class BMI(
    val weight: Double,
    val height: Double,
    val date: String,
    val id: Int? = null

    ) {


    fun calculateBMI(): Double {
        val bmi = weight / ((height / 100.00) * (height / 100.00))
        return bmi
    }

    override fun toString (): String {

        when (weight / ((height / 100.00) * (height / 100.00))) {
            in 0.00..15.99 ->return "wygłodzenie"
            in 16.00..16.99 -> return "wychudzenie"
            in 17.00..18.49 -> return "niedowaga"
            in 18.50..24.99 -> return "waga prawidłowa"
            in 25.00..29.99 -> return "nadwaga"
            in 30.00..34.99 -> return "otyłość I stopnia"
            in 35.00..39.99 -> return "otyłość II stopnia"
            in 40.00..100.00 -> return "otyłość II stopnia"
        }
        throw Exception("Za duża wartość BMI")
    }
}
