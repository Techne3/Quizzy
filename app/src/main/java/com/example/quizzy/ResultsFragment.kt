package com.example.quizzy

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quizzy.databinding.ResultsBinding
import com.example.quizzy.databinding.WelcomeBinding

class ResultsFragment  :Fragment() {



    private var _binding: ResultsBinding? = null
    private val binding: ResultsBinding get() = _binding!!

    private lateinit var viewModel: ViewModelHolder



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ResultsBinding.inflate(inflater, container, false)
        return binding.root
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ViewModelHolder::class.java]
        with(binding) {

            viewModel.correctNum.observe(viewLifecycleOwner){ correct ->

                 resultsTV.text = "Congrats you got ${correct.toString()} Correct. Play Again?"

            }

            backBtn.setOnClickListener{

                val bundle = Bundle()


                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, Welcome::class.java, bundle)
                    .addToBackStack(null)
                    .commit()


            }


        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}