package com.example.quizzy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelHolder : ViewModel() {

private var _correctNum : MutableLiveData<Int> = MutableLiveData(0)
val correctNum : LiveData<Int> get() = _correctNum


    fun getCorrect(num:Int){
        _correctNum.value = num
    }
}