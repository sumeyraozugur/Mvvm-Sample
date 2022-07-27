package com.sum.viewmodel

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.MutableLiveData

class Repository {

    var mathResult = MutableLiveData<String>()
    var isCheck = MutableLiveData<Boolean>()

    init {
        isCheck = MutableLiveData<Boolean>(true)
        mathResult =MutableLiveData<String>("0")
    }

    fun mathResult():MutableLiveData<String>{
        return mathResult
    }




    fun sumNum(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1 +num2
        mathResult.value= sum.toString()

    }

    fun subNum(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1-num2
        mathResult.value= sum.toString()

    }

    fun multiNum(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1 *num2
        mathResult.value= sum.toString()

    }

    fun divNum(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1/num2
        mathResult.value= sum.toString()

    }

    fun controlThem(){
        isCheck.value= if (isCheck.value==true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            false
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            true
        }

    }
}