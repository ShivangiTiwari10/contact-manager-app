package com.example.contactmanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactmanagerapp.databinding.ActivityAddContectsBinding

class AddContacts : AppCompatActivity() {
    private lateinit var binding: ActivityAddContectsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddContectsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}