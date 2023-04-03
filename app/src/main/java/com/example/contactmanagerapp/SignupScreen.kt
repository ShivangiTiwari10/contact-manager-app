package com.example.contactmanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactmanagerapp.databinding.ActivitySignupScreenBinding
import com.google.firebase.database.DatabaseReference

class SignupScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySignupScreenBinding

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySignupScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}