package com.example.quizzy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {


        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}