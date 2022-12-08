package com.example.cookingmama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress) as EditText
        var editTextTextPassword = findViewById(R.id.editTextTextPassword) as EditText
        var btn_submit = findViewById(R.id.login_button) as Button

        btn_submit.setOnClickListener {
            val email = editTextTextEmailAddress.text;
            val password = editTextTextPassword.text;
            if(email.length > 5 && password.length > 8) {
                val intent = Intent(this, ListingActivity::class.java)
                startActivity(intent)
            }
        }
    }
}