package com.example.contactmanagerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactmanagerapp.databinding.ActivitySignupScreenBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySignupScreenBinding

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySignupScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {

            val name = binding.editName.text.toString()
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val user = User(name, email, password)
                database = FirebaseDatabase.getInstance().getReference("Users")
                database.child(password).setValue(user).addOnSuccessListener {

                    binding.editName.text?.clear()
                    binding.editEmail.text?.clear()
                    binding.editPassword.text?.clear()

                    Toast.makeText(this, "User logged In", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SignInScreen::class.java)
                    startActivity(intent)

                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

                }

            }

        }
    }
}