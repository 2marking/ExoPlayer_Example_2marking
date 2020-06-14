package com.example.exoplayer_example_2marking

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class ErrorActivity : AppCompatActivity() {
//    private lateinit var viewBinding: ErrorViewBinding

    private val lastActivityIntent by lazy { intent.getParcelableExtra<Intent>(EXTRA_INTENT)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_error)
    }

    companion object {
        const val EXTRA_INTENT = "EXTRA_INTENT"
    }
}