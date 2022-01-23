package com.example.quizzy

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.quizzy.databinding.QustionLayoutBinding

class QuestionsFragment :Fragment() {







    private var _binding: QustionLayoutBinding? = null
    private val binding: QustionLayoutBinding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = QustionLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }


//      val tvMyTextView = findViewById<TextView>(R.id.textView)





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            var correct = 0
            var questionNumber = 0
            var bundle = Bundle()


            fun quiz(){
                questionNumber++
                answer1.setBackgroundColor (Color.parseColor("#2196F3"))
                answer2.setBackgroundColor (Color.parseColor("#2196F3"))
                answer3.setBackgroundColor (Color.parseColor("#2196F3"))
                answer4.setBackgroundColor (Color.parseColor("#2196F3"))






                if(questionNumber  > 3){
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view, ResultsFragment::class.java, bundle)
                        .addToBackStack(null)
                        .commit()
                }
            }




            val Questions = arrayListOf<String>("What is the value of pie?", "What is this shit","What is this place")

            val AnswerKey = arrayListOf<String>("3.14", "No one knows","hows it going")


            val choice0 = arrayListOf<String>("3.14","what is going on here","7")
            val choice1 = arrayListOf<String>("3.24","No one knows","7")
            val choice2 = arrayListOf<String>("3.23","your on question 2","hows it going")
            val choice3 = arrayListOf<String>("3.244443","Hooora","3")


            nextBtn.setOnClickListener{
                quiz()


             nextBtn.text = "Next Question"

            scoreBoard.text = "Question: $questionNumber correct $correct"
            questionTv.text ="${Questions[questionNumber-1]}"

                answer1.text = "${choice0[questionNumber - 1]}"
                answer2.text = "${choice1[questionNumber-1]}"
                answer3.text = "${choice2[questionNumber-1]}"
                answer4.text = "${choice3[questionNumber-1]}"




       answer1.setOnClickListener {

           if ("${AnswerKey[questionNumber-1]}" === "${choice0[questionNumber -1]}") {
               correct++
               answer1.setBackgroundColor(Color.GREEN)
           }
       }
                answer2.setOnClickListener {

                    if ("${AnswerKey[questionNumber - 1]}" === "${choice1[questionNumber - 1]}") {
                        correct++
                        answer2.setBackgroundColor(Color.GREEN)
                    }

                }
                answer3.setOnClickListener {

                    if ("${AnswerKey[questionNumber - 1]}" === "${choice2[questionNumber - 1]}") {
                        correct++
                        answer3.setBackgroundColor(Color.GREEN)
                    }

                }
                answer4.setOnClickListener {

                    if ("${AnswerKey[questionNumber - 1]}" === "${choice3[questionNumber - 1]}") {
                        correct++
                        answer4.setBackgroundColor(Color.GREEN)
                    }

                }

            }

        }
    }









    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}