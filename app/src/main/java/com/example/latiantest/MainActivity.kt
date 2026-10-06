package com.example.latiantest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val _email = findViewById<TextView>(R.id.email)

        _email.setOnClickListener {
            val _emailintent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:winter@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Subject")
            }
            startActivity(_emailintent)
        }

        val _phone = findViewById<TextView>(R.id.phone)

        _phone.setOnClickListener {
            val _phoneintent = Intent (Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+62 991 9110")
            }
            startActivity(_phoneintent)
        }
    }
}