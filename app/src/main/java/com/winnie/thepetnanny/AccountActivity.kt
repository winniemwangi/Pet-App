package com.winnie.thepetnanny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.winnie.thepetnanny.databinding.ActivityAccountBinding
import com.winnie.thepetnanny.databinding.ActivityAccountBinding.inflate

class AccountActivity : AppCompatActivity() {

    lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }


}