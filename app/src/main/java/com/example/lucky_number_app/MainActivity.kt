package com.example.lucky_number_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val b1: Button = findViewById(R.id.btn)
        val txt: TextView=findViewById(R.id.textView)
        val editTxt: EditText= findViewById(R.id.edt)

        b1.setOnClickListener(){
            var username = editTxt.text

            //explicit intents
            var i= Intent(this, LuckyNumberActivity::class.java )

            //passing the username
            i.putExtra("name",username)

            startActivity(i)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }
}
















