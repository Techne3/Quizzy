package com.example.quizzy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quizzy.databinding.ResultsBinding
import com.example.quizzy.databinding.WelcomeBinding

class ResultsFragment  :Fragment() {



    private var _binding: ResultsBinding? = null
    private val binding: ResultsBinding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ResultsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {


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