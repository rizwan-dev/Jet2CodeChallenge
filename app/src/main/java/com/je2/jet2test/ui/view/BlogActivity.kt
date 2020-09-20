package com.je2.jet2test.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.je2.jet2test.R
import com.je2.jet2test.databinding.ActivityBlogBinding

class BlogActivity : AppCompatActivity() {
    lateinit var binding: ActivityBlogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}