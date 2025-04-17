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
            price = "\$ 1,000.00"
            containerDescription.description1.tvTitle.text = "Today: Start trial"
            containerDescription.description1.tvDescription.text =
                "Gain full access for your Premium subscription"
            containerDescription.description2.tvTitle.text = "Day 2: Get reminded"
            containerDescription.description2.tvDescription.text =
                "Receive a notification when your trial is about to end"
            containerDescription.description3.tvTitle.text = "Day 3: Free trial ends"
            containerDescription.description3.tvDescription.text =
                "Your Premium subscription begins and you’ll be charged"
        }
    }
}