package com.example.bmi

class QuestionsPoint(
    private val questions: List<Question>
) {
    private var counter: Int = 0
    var points: Int = 0

    fun addPoint(answer: Answer){
        this.points += if (answer.isCorrect) 1 else 0;
    }

    fun getNextQuestion(): Question?{
        if(this.counter >= this.questions.size) {
            return null
        }
        val quest = this.questions[this.counter]
        counter++
        return quest;
    }
}
