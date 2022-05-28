package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlin.collections.MutableList as MutableList1

class quizLife : AppCompatActivity() {


    val questions = QuizList(listOf(
            Question(
                "q1",
                listOf(
                    Answer("1a1", true),
                    Answer("1a2", false),
                    Answer("1a3", false),
                )
            ),

            Question(
                "q2",
                listOf(
                    Answer("2a1", true),
                    Answer("2a2", false),
                    Answer("2a3", false),
                )
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        var answers = loadQuestion()

        if(answers === null) {
            throw Exception("Puste pytania")
        }

        ok.setOnClickListener {
            val selId = answersGroup.indexOfChild(
                findViewById(answersGroup.checkedRadioButtonId)
            )

            this.questions.addPoint(answers!![selId])

            answers = loadQuestion()
            if(answers === null) { //koniec listy pytań
                ok.text = this.questions.points.toString()
            }

        }
    }

    fun loadQuestion(): List<Answer>? {

        val quest = this.questions.getNextQuestion();

        if(quest === null) {
            return null
        }

        questionText.text = quest.questionText

        val answers = quest.answers.shuffled()
        aButton.text = answers[0].answerText
        bButton.text = answers[1].answerText
        cButton.text = answers[2].answerText


        return answers
    }


    //fun questionList(): MutableList1 {


}

