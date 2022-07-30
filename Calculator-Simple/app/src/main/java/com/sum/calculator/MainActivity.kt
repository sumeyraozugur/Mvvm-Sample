package com.sum.calculator

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.sum.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var numberOne: Int? = null
    private var numberTwo: Int? = null
    private var result: Int? = null

    companion object {
        private var isCheck: Boolean = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSum.setOnClickListener(this)
        binding.btnSub.setOnClickListener(this)
        binding.btnMulti.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.change_theme_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.changeTheme -> changeTheme()
        }
        Log.v("ChangeTheme", isCheck.toString())
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSum -> sumNumbers()
            R.id.btnSub -> subNumbers()
            R.id.btnMulti -> multiNumbers()
            R.id.btnDiv -> divNumbers()
        }
    }

    private fun sumNumbers() {
        numberOne = binding.editNumber1.text.toString().toIntOrNull()
        numberTwo = binding.editNumber2.text.toString().toIntOrNull()
        if (numberOne == null || numberTwo == null) {
            Toast.makeText(this, "Enter Numbers!!!", Toast.LENGTH_SHORT).show()
        } else {
            result = (numberOne!! + numberTwo!!)
            binding.textResult.text = result.toString()
        }
    }

    private fun subNumbers() {
        numberOne = binding.editNumber1.text.toString().toIntOrNull()
        numberTwo = binding.editNumber2.text.toString().toIntOrNull()
        if (numberOne == null || numberTwo == null) {
            Toast.makeText(this,"Enter Numbers!!!", Toast.LENGTH_SHORT).show()
        } else {
            result = (numberOne!! - numberTwo!!)
            binding.textResult.text = result.toString()
        }
    }

    private fun multiNumbers() {
        numberOne = binding.editNumber1.text.toString().toIntOrNull()
        numberTwo = binding.editNumber2.text.toString().toIntOrNull()
        if (numberOne == null || numberTwo == null) {
            Toast.makeText(this, "Enter Numbers!!!", Toast.LENGTH_SHORT).show()
        } else {
            result = (numberOne!! * numberTwo!!)
            binding.textResult.text = result.toString()
        }
    }

    private fun divNumbers() {
        numberOne = binding.editNumber1.text.toString().toIntOrNull()
        numberTwo = binding.editNumber2.text.toString().toIntOrNull()
        if (numberOne == null || numberTwo == null) {
            Toast.makeText(this,"Enter Numbers!!!", Toast.LENGTH_SHORT).show()
        } else {
            result = (numberOne!! / numberTwo!!)
            binding.textResult.text = result.toString()
        }
    }

    private fun changeTheme() {
        isCheck = if (isCheck) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            false
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            true
        }
    }
}