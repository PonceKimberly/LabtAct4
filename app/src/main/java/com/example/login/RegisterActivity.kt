package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var createAccountButton: Button
    private lateinit var signInText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        createAccountButton = findViewById(R.id.create_account_btn)
        signInText = findViewById(R.id.tv_sign_in)

        createAccountButton.setOnClickListener {
            // In a real app you'd validate + save; for now just go to dashboard
            startActivity(Intent(this, HomeAct::class.java))
        }

        signInText.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
