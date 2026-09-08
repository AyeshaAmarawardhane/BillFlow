package com.example.billflow

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        progressBar = findViewById(R.id.progressBar)

        animateProgress()

        Handler(Looper.getMainLooper()).postDelayed({

            // Temporary navigation.
            // After onboarding is created,
            // this will navigate to OnboardingActivity.
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

            finish()

        }, 2500)
    }

    private fun animateProgress() {

        Thread {

            for (progress in 20..100) {

                Thread.sleep(20)

                runOnUiThread {
                    progressBar.progress = progress
                }
            }

        }.start()
    }
}