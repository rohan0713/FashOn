package com.kotlin.fashon

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.fashon.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    lateinit var binding: ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.WHITE
        binding.btnNext.setOnClickListener {
            Intent(this@OnboardingActivity, HomeActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}