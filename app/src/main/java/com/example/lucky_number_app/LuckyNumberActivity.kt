package com.example.lucky_number_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val text1: TextView= findViewById(R.id.textView2)
        val luckyText: TextView= findViewById(R.id.edt2)
        val shareBtn: Button = findViewById(R.id.btn2)

        var user_name= receiveUserName()
        Toast.makeText(this,"HELLO "+user_name, Toast.LENGTH_LONG).show()

        var random_number = generateRandomNumber()
        //Toast.makeText(this,""+random_number, Toast.LENGTH_LONG).show()

        luckyText.setText(""+random_number)

        shareBtn.setOnClickListener(){
            shareData(user_name,random_number)
        }

    }
    //receiving user name from main activity
    fun receiveUserName(): String {
        var bundle: Bundle? = intent.extras
        var username = bundle?.get("name").toString()
        return username
    }

    //generating random number
    fun generateRandomNumber():Int{
        val random = Random.nextInt(1000)
        return random
    }

    //Sharing lucky number
    fun shareData(username:String, num : Int){
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today")
        i.putExtra(Intent.EXTRA_TEXT,"his lucky number is $num")
        startActivity(i)
    }
}