package com.sum.viewmodel


import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var result = "0"


    companion object{
        var isCheck:Boolean = true

    }


    fun sum(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1 +num2
        result = sum.toString()

    }

    fun sub(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1-num2
        result = sum.toString()

    }

    fun multi(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1 *num2
        result = sum.toString()

    }

    fun div(number1:String,number2:String){
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        val sum = num1/num2
        result = sum.toString()

    }

    fun checkThem(){
        isCheck = if (isCheck) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            false
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            true
        }

    }

}