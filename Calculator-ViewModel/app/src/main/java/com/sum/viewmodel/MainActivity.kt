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
    private var numberOne: Int? = null
    private var numberTwo: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        numberOne = binding.editNumber1.text.toString().toIntOrNull()
        numberTwo = binding.editNumber2.text.toString().toIntOrNull()
        if (numberOne == null || numberTwo == null) {
            Toast.makeText(this, "Enter Numbers!!!", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.sum(numberOne.toString(), numberTwo.toString())
        }
    }

    private fun subNumbers() {
        numberOne = binding.editNumber1.text.toString().toIntOrNull()
        numberTwo = binding.editNumber2.text.toString().toIntOrNull()
        if (numberOne == null || numberTwo == null) {
            Toast.makeText(this, "Enter Numbers!!!", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.sub(numberOne.toString(), numberTwo.toString())
        }
    }

    private fun multiNumbers() {
        numberOne = binding.editNumber1.text.toString().toIntOrNull()
        numberTwo = binding.editNumber2.text.toString().toIntOrNull()
        if (numberOne == null || numberTwo == null) {
            Toast.makeText(this, "Enter Numbers!!!", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.multi(numberOne.toString(), numberTwo.toString())
        }
    }

    private fun divNumbers() {
        numberOne = binding.editNumber1.text.toString().toIntOrNull()
        numberTwo = binding.editNumber2.text.toString().toIntOrNull()
        if (numberOne == null || numberTwo == null) {
            Toast.makeText(this, "Enter Numbers!!!", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.div(numberOne.toString(), numberTwo.toString())
        }
    }

    private fun changeTheme() {
        viewModel.checkTheme()
    }
}