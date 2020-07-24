package com.example.androidhws.hw2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.androidhws.R



class MainActivity : AppCompatActivity() {

    val LOGIN:String="icarus"
    val PASSWORD:String="fallen"

    var visibilityStatus:Boolean=true
    var buttonChangeVisibility: Button?=null
    var buttonSignIn: Button?=null
    var buttonGoto:Button?=null
    var textViewSignInStatus:TextView?=null
    var editTextLogin:EditText?=null
    var editTextPassword:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews(){
        buttonSignIn=findViewById(R.id.button_activity_main_sign_in)
        buttonChangeVisibility=findViewById(R.id.button_activity_main_change_visibility)
        textViewSignInStatus=findViewById(R.id.textview_activity_main_sign_in_status)
        editTextLogin=findViewById(R.id.edittext_activity_main_login)
        editTextPassword=findViewById(R.id.edittext_activity_main_password)
        buttonGoto=findViewById(R.id.button_activity_main_goto_second_task)
    }

    fun initializeListeners(){
        buttonSignIn!!.setOnClickListener(View.OnClickListener {
            if(editTextLogin?.text.toString().equals(LOGIN)&&editTextPassword?.text.toString().equals(PASSWORD)){
                textViewSignInStatus?.setText(R.string.activity_main_textview)
            }else{
                textViewSignInStatus?.setText("Incorrect")
            }
        })
        buttonChangeVisibility!!.setOnClickListener(View.OnClickListener {
            if (visibilityStatus==true){
                buttonSignIn?.visibility=View.INVISIBLE
                textViewSignInStatus?.visibility=View.INVISIBLE
                editTextLogin?.visibility=View.INVISIBLE
                editTextPassword?.visibility=View.INVISIBLE
                visibilityStatus=false
            }
            else{
                buttonSignIn?.visibility=View.VISIBLE
                textViewSignInStatus?.visibility=View.VISIBLE
                editTextLogin?.visibility=View.VISIBLE
                editTextPassword?.visibility=View.VISIBLE
                visibilityStatus=true
            }
        })
        buttonGoto!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,ShoppingListActivity::class.java))
        })


    }

}
