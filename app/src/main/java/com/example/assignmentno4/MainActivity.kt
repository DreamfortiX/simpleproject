package com.example.assignmentno4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignmentno4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.signup.setOnClickListener()
        {
            if (binding.Fname.text.length > 12) {
                binding.Fname.setError("Name length should be less than 12 char")
            } else if (binding.email.text.equals("naseebjutt3438@gmail.com")) {
                binding.email.setError("Enter a valid email")
            } else if (binding.passwordToggle.text.length < 7) {
                binding.passwordToggle.setError(" Enter valid password")
            } else {

                var a = binding.email.text.toString()
                var b = binding.passwordToggle.text.toString()
                startActivity(Intent(this, login::class.java).putExtra("email",a).putExtra("password",b))
            }

        }
        binding.google.setOnClickListener()
        {
            val googleUri = Uri.parse("http://www.google.com")
            val intent = Intent(Intent.ACTION_VIEW, googleUri)
            startActivity(intent)
        }
        binding.facebook.setOnClickListener()
        {
            openFacebook()
        }
    }
    private fun openFacebook() {
        try {
            val facebookUri = Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com")
            val facebookIntent = Intent(Intent.ACTION_VIEW, facebookUri)
            if (facebookIntent.resolveActivity(packageManager) != null) {
                startActivity(facebookIntent)
            } else {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"))
                startActivity(browserIntent)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}