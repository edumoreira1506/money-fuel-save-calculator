package br.edu.utfpr.money_fuel_save_calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.utfpr.money_fuel_save_calculator.databinding.ActivityFuelTypeListBinding
import br.edu.utfpr.money_fuel_save_calculator.databinding.ActivityMainBinding

class FuelTypeListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFuelTypeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFuelTypeListBinding.inflate(layoutInflater)
        setContentView(binding.listFuelType)

        binding.listFuelType.setOnItemClickListener { parent, view, position, id ->
            val selected = if(position == 0 ) getString(R.string.gas) else getString(R.string.alcohol)
            val fuel = intent.getStringExtra("fuel")!!

            intent.putExtra(fuel, selected)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}