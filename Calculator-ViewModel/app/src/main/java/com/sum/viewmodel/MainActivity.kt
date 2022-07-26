package com.sum.viewmodel


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sum.viewmodel.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var number1: Int? = null
    private var number2: Int? = null
    private lateinit var toastMessage: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        toastMessage = "Enter Numbers!!!"


        viewModel.result.observe(this) {
            binding.textResult.text = it

        }


        binding.btnSum.setOnClickListener(this)
        binding.btnSub.setOnClickListener(this)
        binding.btnMulti.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.change_theme_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.changeTheme -> changeTheme()
        }
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
        number1 = binding.editNumber1.text.toString().toIntOrNull()
        number2 = binding.editNumber2.text.toString().toIntOrNull()
        if (number1 == null || number2 == null) {
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        } else {
            viewModel.sum(number1.toString(), number2.toString())

        }

    }

    private fun subNumbers() {
        number1 = binding.editNumber1.text.toString().toIntOrNull()
        number2 = binding.editNumber2.text.toString().toIntOrNull()
        if (number1 == null || number2 == null) {
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        } else {
            viewModel.sub(number1.toString(), number2.toString())

        }

    }

    private fun multiNumbers() {
        number1 = binding.editNumber1.text.toString().toIntOrNull()
        number2 = binding.editNumber2.text.toString().toIntOrNull()

        if (number1 == null || number2 == null) {
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        } else {
            viewModel.multi(number1.toString(), number2.toString())

        }

    }

    private fun divNumbers() {
        number1 = binding.editNumber1.text.toString().toIntOrNull()
        number2 = binding.editNumber2.text.toString().toIntOrNull()

        if (number1 == null || number2 == null) {
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        } else {
            viewModel.div(number1.toString(), number2.toString())

        }

    }

    private fun changeTheme() {
        viewModel.checkThem()

    }


}