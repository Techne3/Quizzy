package com.example.quizzy

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quizzy.databinding.QustionLayoutBinding

class QuestionsFragment :Fragment() {





    private var _binding: QustionLayoutBinding? = null
    private val binding: QustionLayoutBinding get() = _binding!!

    private lateinit var viewModel : ViewModelHolder



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = QustionLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ViewModelHolder::class.java]
        with(binding) {


            var correct = 0
            var questionNumber = 0
            val bundle = Bundle(correct)


            fun quiz(){


                questionNumber++
                answer1.setBackgroundColor (Color.parseColor("#2196F3"))
                answer2.setBackgroundColor (Color.parseColor("#2196F3"))
                answer3.setBackgroundColor (Color.parseColor("#2196F3"))
                answer4.setBackgroundColor (Color.parseColor("#2196F3"))

                answer1.setEnabled(true);
                answer2.setEnabled(true);
                answer3.setEnabled(true);
                answer4.setEnabled(true);




                if( questionNumber >= 5){
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view, ResultsFragment::class.java, bundle)
                        .addToBackStack(null)
                        .commit()
                }
            }




            val Questions = arrayListOf<String>("What is the value of pie?", "How much money do you give the Lock Ness Monster?","What is the best Programming language","What year was the Moon landing?","How's it going?", "Do we live in the Matrix?")
            val AnswerKey = arrayListOf<String>("3.14", "3.50","Kotlin","1969","Stupendous","Yes")


            val choice0 = arrayListOf<String>("3.14","100","JavaScript","1960","Great","Yes")
            val choice1 = arrayListOf<String>("3.24","90","Java","1959","Fine","Yes")
            val choice2 = arrayListOf<String>("3.23","666","Kotlin","1972","Stupendous","Yes")
            val choice3 = arrayListOf<String>("3.244443","3.50","Python","1969","Wonderful","Yes")


            nextBtn.setOnClickListener{
                quiz()


             nextBtn.text = "Next Question"

            scoreBoard.text = "Question: $questionNumber correct $correct"
            questionTv.text = Questions[questionNumber-1]

                answer1.text = choice0[questionNumber - 1]
                answer2.text = choice1[questionNumber-1]
                answer3.text = choice2[questionNumber-1]
                answer4.text = choice3[questionNumber-1]




                answer1.setOnClickListener {

                   if (AnswerKey[questionNumber-1] === choice0[questionNumber -1]) {
                       correct++
                       answer1.setBackgroundColor(Color.GREEN)
                       answer1.isEnabled = false;
                       answer2.isEnabled =false;
                       answer3.isEnabled =false;
                       answer4.isEnabled =false;
                   }else{
                       answer1.setBackgroundColor(Color.RED)
                       answer1.isEnabled = false;
                       answer2.isEnabled =false;
                       answer3.isEnabled =false;
                       answer4.isEnabled =false;
                   }
               }
                answer2.setOnClickListener {

                    if (AnswerKey[questionNumber - 1] === choice1[questionNumber - 1]) {
                        correct++
                        answer2.setBackgroundColor(Color.GREEN)
                        answer1.isEnabled = false;
                        answer2.isEnabled =false;
                        answer3.isEnabled =false;
                        answer4.isEnabled =false;
                    }else{
                        answer2.setBackgroundColor(Color.RED)
                        answer1.isEnabled = false;
                        answer2.isEnabled =false;
                        answer3.isEnabled =false;
                        answer4.isEnabled =false;
                    }

                }
                answer3.setOnClickListener {

                    if (AnswerKey[questionNumber - 1] === choice2[questionNumber - 1]) {
                        correct++
                        answer3.setBackgroundColor(Color.GREEN)
                        answer1.isEnabled = false;
                        answer2.isEnabled =false;
                        answer3.isEnabled =false;
                        answer4.isEnabled =false;
                    }else{
                        answer3.setBackgroundColor(Color.RED)
                        answer1.isEnabled = false;
                        answer2.isEnabled =false;
                        answer3.isEnabled =false;
                        answer4.isEnabled =false;



                    }

                }
                answer4.setOnClickListener {

                    if (AnswerKey[questionNumber - 1] === choice3[questionNumber - 1]) {
                        correct++
                        answer4.setBackgroundColor(Color.GREEN)
                        answer1.isEnabled = false;
                        answer2.isEnabled =false;
                        answer3.isEnabled =false;
                        answer4.isEnabled =false;
                    }else{
                        answer4.setBackgroundColor(Color.RED)
                        answer1.isEnabled = false;
                        answer2.isEnabled =false;
                        answer3.isEnabled =false;
                        answer4.isEnabled =false;
                    }

                }

                viewModel.getCorrect(correct)

            }

        }
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}