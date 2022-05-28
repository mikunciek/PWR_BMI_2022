package com.example.bmi

class QuizList(
    val questions: List<Question>
) {
    private var counter: Int = 0

    var points: Int = 0

    public fun addPoint(answer: Answer)
    {
        this.points += if (answer.isCorrect) 1 else 0;
    }

    public fun getNextQuestion(): Question?
    {
        if(this.counter >= this.questions.size) {
            return null
        }
        val quest = this.questions.get(this.counter)
        counter++
        return quest;
    }
}
