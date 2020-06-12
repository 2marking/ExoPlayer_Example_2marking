package com.example.exoplayer_example_2marking.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exoplayer_example_2marking.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Intent(this, MainActivity::class.java).run{
            startActivity(this)
            finish()
        }
    }
}