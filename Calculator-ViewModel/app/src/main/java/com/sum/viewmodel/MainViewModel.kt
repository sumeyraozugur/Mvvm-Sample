package com.sum.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var result = MutableLiveData<String>()
    var isCheck = MutableLiveData<Boolean>()
    var mRepo = Repository()

    init {
        isCheck = mRepo.isCheck
        // result = mRepo.mathResult()
        result = mRepo.mathResult
    }


    fun sum(number1: String, number2: String) {
        mRepo.sumNum(number1, number2)
    }

    fun sub(number1: String, number2: String) {
        mRepo.subNum(number1, number2)
    }

    fun multi(number1: String, number2: String) {
        mRepo.multiNum(number1, number2)
    }

    fun div(number1: String, number2: String) {
        mRepo.divNum(number1, number2)
    }

    fun checkThem() {
        mRepo.controlThem()
    }

}