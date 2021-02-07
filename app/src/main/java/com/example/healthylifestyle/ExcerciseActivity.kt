package com.example.healthylifestyle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.healthylifestyle.databinding.ActivityExcerciseBinding
import com.example.healthylifestyle.databinding.ActivityMainBinding

class ExcerciseActivity : AppCompatActivity() {
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0

    private var excersieTimer: CountDownTimer? = null
    private var exceriseProgress = 0

    private var excersieTimeDuration:Long =30



    private lateinit var binding: ActivityExcerciseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExcerciseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarExcersieActivity)
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
        binding.toolbarExcersieActivity.setNavigationOnClickListener {
            onBackPressed()
        }
        setUpRestView()


    }

    override fun onDestroy() {
        if(restTimer!=null){
            restTimer!!.cancel()
            restProgress=0
        }
        super.onDestroy()
    }

    private fun setRestProgressBar() {
        binding.progressBar.progress = restProgress
        restTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                binding.progressBar.progress = 10 - restProgress
                binding.tvTimer.text = (10 - restProgress).toString()
            }

            override fun onFinish() {
               setUpExcersieView()

            }
        }.start()
    }

    private fun setUpRestView(){
        if(restTimer!=null){
            restTimer!!.cancel()
            restProgress=0
        }
        setRestProgressBar()
    }

    private fun setExcersieProgressBar() {
        binding.progressBarExcersie.progress = exceriseProgress
        excersieTimer = object : CountDownTimer(excersieTimeDuration*1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                exceriseProgress++
                binding.progressBarExcersie.progress = excersieTimeDuration.toInt() - exceriseProgress
                binding.tvExcersieTimer.text = (excersieTimeDuration.toInt()- exceriseProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@ExcerciseActivity, "Here we will start next rest Timer screen", Toast.LENGTH_SHORT)
                    .show()

            }
        }.start()
    }

    private fun setUpExcersieView(){
        binding.llResultView.visibility= View.GONE
        binding.llExcersieView.visibility=View.VISIBLE
        if(excersieTimer!=null){
            excersieTimer!!.cancel()
            exceriseProgress=0
        }
        setExcersieProgressBar()
    }


}