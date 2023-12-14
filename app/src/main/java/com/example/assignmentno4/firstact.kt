package com.example.assignmentno4

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignmentno4.databinding.ActivityFirstactBinding

class firstact : AppCompatActivity() {
    private lateinit var binding: ActivityFirstactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logout.setOnClickListener()
        {
            var dialog = AlertDialog.Builder(this)
            dialog.setTitle("Aleart!!!!")
            dialog.setMessage("Are you sure you want to logout")
            dialog.setPositiveButton("yes")
            {
                    dialog , which->
                startActivity(Intent(this,login::class.java))
                finish()
            }
            dialog.setNegativeButton("cancel")
            {
                    dialog,which->
                Toast.makeText(this , "cancal button is clicked", Toast.LENGTH_SHORT).show()
            }
            var alert = dialog.create()
            alert.show()
        }



    }



}