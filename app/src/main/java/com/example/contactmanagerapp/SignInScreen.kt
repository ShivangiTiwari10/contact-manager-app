package com.example.contactmanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactmanagerapp.databinding.ActivitySignInScreenBinding

class SignInScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySignInScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}