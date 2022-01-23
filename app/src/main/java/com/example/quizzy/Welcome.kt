package com.example.quizzy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quizzy.databinding.WelcomeBinding

class Welcome :Fragment() {

    private var _binding: WelcomeBinding? = null
    private val binding: WelcomeBinding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {


            play.setOnClickListener{

                val bundle = Bundle()


                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, QuestionsFragment::class.java, bundle)
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