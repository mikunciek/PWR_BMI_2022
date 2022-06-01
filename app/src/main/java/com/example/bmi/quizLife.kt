package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlin.collections.MutableList as MutableList1

class quizLife : AppCompatActivity() {


    val questions = QuizList(
        listOf(
            Question(
                "Które produkty powinny stanowić podstawę naszej diety?",
                listOf(
                    Answer("Produkty pełnoziarniste", false),
                    Answer("Warzywa i owoce", true),
                    Answer("Mięso", false),
                )
            ),

            Question(
                "Które z tych produktów zawiera więcej kalorii?",
                listOf(
                    Answer("Awokado", true),
                    Answer("Ziemniaki", false),
                    Answer("Woda", false),
                )
            ),
            Question(
                "Czy produkty typu light ułatwiają odchudzanie?",
                listOf(
                    Answer("Tak", false),
                    Answer("Nie", true),
                    Answer("Nie wiem", false),
                )
            ),
            Question(
                "Jaki indeks glikemiczny mają banany?",
                listOf(
                    Answer("Niski", false),
                    Answer("Średni", false),
                    Answer("Wysoki", true),
                )
            ),
            Question(
                "BMI świadczące o prawidłowej masie ciała wynosi:",
                listOf(
                    Answer("17,5 - 23", false),
                    Answer("18,5 - 24,9 ", true),
                    Answer("19 - 30", false),
                )
            ),
            Question(
                "Witaminy rozpuszczalne w tłuszczach to:",
                listOf(
                    Answer("A,D, witaminy z grupy B", false),
                    Answer("A,D,C,PP", true),
                    Answer("A,D,E,K", false),
                )
            ),
            Question(
                "Która z wymienionych diet jest najzdrowsza?",
                listOf(
                    Answer("Ketogeniczna", false),
                    Answer("DASH", true),
                    Answer("Zgodna z grupą krwi", false),
                )
            ),
            Question(
                "Do produktów wysokoprzetworzonych nie zalicza się:",
                listOf(
                    Answer("Parówek", false),
                    Answer("Kiełbas", false),
                    Answer("Makaronu", true),
                )
            ),
            Question(
                "W organizmie osoby dorosłej tłuszcze zapasowy występuje w ilości od kilku do kilkunastu kg, przeciętnie to:",
                listOf(
                    Answer("7 kg", false),
                    Answer("10 kg", true),
                    Answer("12 kg", false),
                )
            ),
            Question(
                "Kwasy DHA są zdrowe:",
                listOf(
                    Answer("Tak", true),
                    Answer("Nie", false),
                    Answer("Nie wiem", false),
                )
            ),
            Question(
                "Istnieje lista ryb niezalecanych kobietom w ciaży, karmiącym piersią oraz małym dzieciom. Nie znajdziemy tam:",
                listOf(
                    Answer("Szprotek", true),
                    Answer("Tuńczyka", false),
                    Answer("Makreli", false),
                )
            ),
            Question(
                "Które z tych produktów zawiera najwięcej cholesterolu w 100g",
                listOf(
                    Answer("Mleko 3,2%", false),
                    Answer("Smalec", false),
                    Answer("Mózg wieprzowy", true),
                )
            ),
            Question(
                "Najwięcej błonnika w 100g zawierają",
                listOf(
                    Answer("Otręby pszenne", true),
                    Answer("Morele suszone", false),
                    Answer("Chleb żytni pełnoziarnisty", false),
                )
            ),
            Question(
                "Tygodniowo, na aktywność fizyczną powinniśmy poświęcić, co najmniej:",
                listOf(
                    Answer("120 min", false),
                    Answer("150 min", true),
                    Answer("180 min", false),
                )
            ),
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        var answers = loadQuestion()

        if (answers === null) {
            throw Exception("Puste pytania")
        }

        ok.setOnClickListener {
            val selId = answersGroup.indexOfChild(
                findViewById(answersGroup.checkedRadioButtonId)
            )

            this.questions.addPoint(answers!![selId])

            answers = loadQuestion()
            if (answers === null) { //koniec listy pytań

                val point = this.questions.points.toString()
                showPoint.text = point
                ok.text = "Zobacz wyniki"

                //return point

                val ok: Button = findViewById(R.id.ok)
                ok.setOnClickListener {
                    this.startActivity(Intent(this, showResultQuiz::class.java))
                }

            }

        }
    }

    fun loadQuestion(): List<Answer>? {

        val quest = this.questions.getNextQuestion();
        if (quest === null) {
            return null
        }

        questionText.text = quest.questionText

        val answers = quest.answers.shuffled()
        aButton.text = answers[0].answerText
        bButton.text = answers[1].answerText
        cButton.text = answers[2].answerText

        return answers
    }

   fun sumPoint (point: String): String {

        val point = this.questions.points.toString()
        return point
    }



}

