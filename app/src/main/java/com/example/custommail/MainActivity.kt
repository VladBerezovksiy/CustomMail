package com.example.custommail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        val recipientEditText: EditText = findViewById(R.id.recipient_edit_text)
        val messageEditText: EditText = findViewById(R.id.message_edit_text)
        val sendButton: Button = findViewById(R.id.send_button)

        sendButton.setOnClickListener {
            val recipient = recipientEditText.text.toString()
            val message = messageEditText.text.toString()

            if (recipient.isNotEmpty() || message.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_EMAIL, recipient)
                intent.putExtra(Intent.EXTRA_TEXT, message)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please, fill in all fields", Toast.LENGTH_LONG).show()
            }
        }
    }
}