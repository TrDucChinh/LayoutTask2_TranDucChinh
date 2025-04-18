package com.eco.layouttask2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.eco.layouttask2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val imeHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom + imeHeight
            )
            insets
        }
        setUpUI()
    }

    private fun setUpUI() {
        binding.apply {
            price = getString(R.string.price)
            with(containerDescription){
                tvTitle1.text = getString(R.string.title1)
                tvDescription1.text = getString(R.string.description1)
                tvTitle2.text = getString(R.string.title2)
                tvDescription2.text = getString(R.string.description2)
                tvTitle3.text = getString(R.string.title3)
                tvDescription3.text = getString(R.string.description3)
            }
        }
    }
}