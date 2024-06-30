package br.edu.utfpr.money_fuel_save_calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.utfpr.money_fuel_save_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var fuelOne: String
    private lateinit var fuelTwo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.main)

        fuelOne = intent.getStringExtra("fuelOne") ?: getString(R.string.fuel_one)
        fuelTwo = intent.getStringExtra("fuelTwo") ?: getString(R.string.fuel_two)

        updateHints()

        binding.searchFuelOneButton.setOnClickListener {
            onSearchButtonClick("fuelOne")
        }

        binding.searchFuelTwoButton.setOnClickListener {
            onSearchButtonClick("fuelTwo")
        }
    }

    private fun updateHints() {
        binding.fuelOneInputContainer.hint = fuelOne
        binding.fuelTwoInputContainer.hint = fuelTwo
        binding.priceOneInputContainer.hint = getString(R.string.value_per_l) + fuelOne
        binding.priceTwoInputContainer.hint = getString(R.string.value_per_l) + fuelTwo
    }

    private fun onSearchButtonClick(fuel: String) {
        val intent = Intent(this, FuelTypeListActivity::class.java)
        intent.putExtra("fuel", fuel)
        getResult.launch(intent)
    }

    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK && it.data != null) {
            val fuelOneResult = it.data?.getStringExtra("fuelOne")

            if (fuelOneResult != null) {
                fuelOne = fuelOneResult
            }

            val fuelTwoResult = it.data?.getStringExtra("fuelTwo")
            if (fuelTwoResult != null) {
                fuelTwo = fuelTwoResult
            }

            updateHints()
        }
    }
}