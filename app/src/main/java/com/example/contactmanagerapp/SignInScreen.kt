package com.example.contactmanagerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactmanagerapp.databinding.ActivitySignInScreenBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySignInScreenBinding

    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val userPassword = binding.edPassword.text.toString()
            if (userPassword.isNotEmpty()) {
                getData(userPassword)
            } else {
                Toast.makeText(this, "Please enter user id", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getData(userPassword: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")

        database.child(userPassword).get().addOnSuccessListener {


            if (it.exists()) {
                val intent = Intent(this, AddContacts::class.java)
                startActivity(intent)

                Toast.makeText(this, "User exists", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }

        }
    }
}