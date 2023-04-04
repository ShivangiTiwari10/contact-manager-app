package com.example.contactmanagerapp

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactmanagerapp.contact.userInfo
import com.example.contactmanagerapp.databinding.ActivityAddContectsBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddContacts : AppCompatActivity() {
    private lateinit var binding: ActivityAddContectsBinding
    private lateinit var dialog: Dialog

    private lateinit var database: DatabaseReference
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddContectsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {

            val name = binding.editName.text.toString()
            val email = binding.editEmail.text.toString()
            val phone = binding.editPhone.text.toString()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val contacts = userInfo(name, email, phone)
                database = FirebaseDatabase.getInstance().getReference("Contacts")
                database.child(phone).setValue(contacts).addOnSuccessListener {

                    binding.editName.text?.clear()
                    binding.editEmail.text?.clear()
                    binding.editPhone.text?.clear()

                    Toast.makeText(this, "Contact saved", Toast.LENGTH_SHORT).show()

                    dialog = Dialog(this)
                    dialog.setContentView(R.layout.custom_dialog)
                    dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_custom_box))
                    dialog.show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()

                }

            }
        }
    }
}