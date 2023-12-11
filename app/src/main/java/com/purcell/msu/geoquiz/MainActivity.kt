package com.purcell.msu.geoquiz

import android.graphics.Color
//import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.purcell.msu.geoquiz.databinding.ActivityMainBinding

// Link to figure out the problem with androidx https://stackoverflow.com/questions/57168514/android-studio-3-4-2-unresolved-reference-v7
class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    //private lateinit var trueButton: Button
    //private lateinit var falseButton: Button
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button
    private lateinit var textViewQuestion: TextView


    /*private val questionBank = ListOf(
        Question("The Pacific Ocean is larger than the Atlantic Ocean.",  )
    )*/

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, true),
        Question(R.string.question_africa, true),
        Question(R.string.question_africa, true),
        Question(R.string.question_asia, true)
    )
    private var currentIndex = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // set an OnClickListener to the textView
        textViewQuestion = findViewById(R.id.question_textview)
        textViewQuestion.setOnClickListener{
            showNextQuestion()
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //trueButton = findViewById(R.id.true_button)
        //falseButton = findViewById(R.id.false_button)
        prevButton = findViewById(R.id.prev_button)
        nextButton = findViewById(R.id.next_button)


        /* trueButton.setOnClickListener{view: view ->
            Toast.makeText(
                this,
                R.string.true_button,
                Toast.LENGTH_SHORT)
                .show()
        }

        falseButton.setOnClickListener{view: view ->
            Toast.makeText(
                this,
                R.string.false_button,
                Toast.LENGTH_SHORT)
                .show()
    }*/
        binding.trueButton.setOnClickListener {
            var snackBar = Snackbar.make(
                it,
                "Correct",
                Snackbar.LENGTH_LONG
            )
            snackBar.show()

        }
        binding.falseButton.setOnClickListener {
            var snackBar = Snackbar.make(
                it,
                "Incorrect",
                Snackbar.LENGTH_LONG
            )
            snackBar.setTextColor(Color.BLACK)
            snackBar.setBackgroundTint(Color.RED)
            snackBar.show()

        }

        binding.nextButton.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            //val questionTextResId = questionBank[currentIndex].textResId
           // binding.questionTextview.setText(questionTextResId)
            updatedQuestion()
        }

        updatedQuestion()
    }

    private fun showNextQuestion() {
        val nextButton: Button = findViewById(R.id.next_button)
        nextButton.setOnClickListener{
            // Method to show the next question
            showNextQuestion()
        }

    }

    private fun updatedQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextview.setText(questionTextResId)
    }
}