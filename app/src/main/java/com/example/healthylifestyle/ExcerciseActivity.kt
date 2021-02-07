package com.example.healthylifestyle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.healthylifestyle.databinding.ActivityExcerciseBinding
import com.example.healthylifestyle.databinding.ActivityMainBinding

class ExcerciseActivity : AppCompatActivity() {
private lateinit var binding :ActivityExcerciseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExcerciseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarExcersieActivity)
        val actionbar=supportActionBar
        if(actionbar!=null){
          actionbar.setDisplayHomeAsUpEnabled(true)
        }
        binding.toolbarExcersieActivity.setNavigationOnClickListener{
            onBackPressed()
        }
    }


}