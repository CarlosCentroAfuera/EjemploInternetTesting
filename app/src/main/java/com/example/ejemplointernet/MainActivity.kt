package com.example.ejemplointernet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.ejemplointernet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObserver()

        binding.bDescargaUno.setOnClickListener {
           viewModel.getPlanet()
        }

        binding.bDescargaTodos.setOnClickListener {
            viewModel.getAllPlanets()
        }
    }
    private fun initObserver() {
        viewModel.isVisible.observe(this) { isVisible ->
            if (isVisible) setVisible() else setGone()
        }

        viewModel.responseText.observe(this) { responseText ->
            showToast(responseText)
        }
    }

    private fun setVisible(){
        binding.pbDownloading.visibility = View.VISIBLE
    }
    private fun setGone(){
        binding.pbDownloading.visibility = View.GONE
    }
    private fun showToast(text : String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()

    }

}