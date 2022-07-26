package com.sum.viewmodel

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var result = MutableLiveData<String>()
    var isCheck =MutableLiveData<Boolean>()

    init {
        isCheck = MutableLiveData<Boolean>(true)
    }




    fun sum(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1 +num2
        result.value= sum.toString()

    }

    fun sub(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1-num2
        result.value= sum.toString()

    }

    fun multi(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1 *num2
        result.value= sum.toString()

    }

    fun div(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1/num2
        result.value= sum.toString()

    }

    fun checkThem(){
        isCheck.value= if (isCheck.value==true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            false
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            true
        }

    }

}