package com.example.androidhws.hw4

import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidhws.R
import android.content.Intent
import android.os.Bundle
import android.view.View

class SendMessageToFriendActivity :AppCompatActivity(){
    
    var buttonSendMessageFriend: Button?  = null
    var buttonAuthorization : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message_to_friend)
        initializeViews()
        initializeListeners()
    }


    fun initializeViews(){
        buttonSendMessageFriend = findViewById(R.id.activity_main_button_send_message_friend)
        buttonAuthorization = findViewById(R.id.activity_main_button_authorization)
    }

    fun initializeListeners(){
        buttonSendMessageFriend?.setOnClickListener(View.OnClickListener {
            sendMessageWhatsAppFriend("77074100376","Hello")
        })

        buttonAuthorization?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
        })
    }

    fun sendMessageWhatsAppFriend(number: String, message:String){
        val smsNumber = number
        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.type = "text/plain"
        sendIntent.putExtra(Intent.EXTRA_TEXT, message)
        sendIntent.putExtra("jid", "$smsNumber@s.whatsapp.net")
        sendIntent.setPackage("com.whatsapp")
        startActivity(sendIntent)
    }
}