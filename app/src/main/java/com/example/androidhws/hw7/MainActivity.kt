package com.example.androidhws.hw7


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.androidhws.R

class MainActivity : AppCompatActivity() {

    var buttonTask1 : Button? = null
    var buttonTask2 : Button? = null
    var buttonTask3 : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews(){
        buttonTask1 = findViewById(R.id.activity_main_button_task1);
        buttonTask2 = findViewById(R.id.activity_main_button_task2);
        buttonTask3 = findViewById(R.id.activity_main_button_task3);
    }

    fun initializeListeners(){
        buttonTask1?.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Task1Activity::class.java))
        })

        buttonTask2?.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Task2Activity::class.java))
        })

        buttonTask3?.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Task3Activity::class.java))
        })
    }
}