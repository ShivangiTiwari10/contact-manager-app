package com.example.contactmanagerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.contactmanagerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        supportActionBar!!.hide()

        Handler().postDelayed({

            val intent = Intent(this, SignupScreen::class.java)
            startActivity(intent)
            finish()
        },2000)

        setContentView(binding.root)
    }
}