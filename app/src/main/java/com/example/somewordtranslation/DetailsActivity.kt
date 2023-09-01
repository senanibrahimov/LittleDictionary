package com.example.somewordtranslation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.somewordtranslation.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val intent=intent

        binding.textengilsh.text=intent.getStringExtra("engilsh")
        binding.textturk.text=intent.getStringExtra("turk")

    }
}