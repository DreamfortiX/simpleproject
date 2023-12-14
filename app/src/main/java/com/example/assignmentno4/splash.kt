package com.example.assignmentno4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.assignmentno4.databinding.ActivitySplashBinding

class splash : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val SPLASH_TIME_OUT: Long = 3000 // 3 seconds
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(100)
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)







            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                // Close this activity
                finish()
            }, SPLASH_TIME_OUT)
    }
}