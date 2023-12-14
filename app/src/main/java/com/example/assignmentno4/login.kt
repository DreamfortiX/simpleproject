package com.example.assignmentno4

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.assignmentno4.databinding.ActivityLoginBinding

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var SharedPreferences:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor
    private  lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SharedPreferences = this.getSharedPreferences("Assignment",Context.MODE_PRIVATE)
        editor= SharedPreferences.edit()
        var a = intent.getStringExtra("email").toString()
        var b = intent.getStringExtra("password").toString()

        binding.login.setOnClickListener()

        {
            dialog = Dialog(this@login)
            if (binding.email.equals(a) && binding.password.equals(b)) {
                dialog.setContentView(R.layout.loadinganim)
                dialog.show()
                startActivity(Intent(this@login,firstact::class.java))
            }




        }
        binding.forgotPss.setOnClickListener()
        {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.forgotpass)
            dialog.show()

            var oldPassword = dialog.findViewById<EditText>(R.id.oldpass)
            var newPassword = dialog.findViewById<EditText>(R.id.newpass)
            var newAgainPassword = dialog.findViewById<EditText>(R.id.renew)

            dialog.findViewById<Button>(R.id.submit).setOnClickListener()
            {
                var getpass = SharedPreferences.getString("password",b)
                if (getpass.toString().equals(oldPassword))
                {
                    editor.putString("newPassword", newPassword.toString())
                    editor.apply()
                }


            }


        }
    }
}