package com.example.stbs.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stbs.R
import com.example.stbs.adapters.MessageAdapter
import com.example.stbs.databinding.ActivityChatBinding
import com.example.stbs.models.Message
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_chat.*

private const val TAG = "ChatActivity"

class ChatActivity : AppCompatActivity() {
    private var chatId = ""
    private var user = ""
    private var name = ""

    private var db = Firebase.firestore

    private val binding by lazy{
        ActivityChatBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent.getStringExtra("chatId")?.let { chatId = it }
        intent.getStringExtra("user")?.let { user = it }
        intent.getStringExtra("name")?.let{name = it}
        Log.d(TAG, "onCreate: $user")

        if(chatId.isNotEmpty() && user.isNotEmpty()) {
            initViews()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initViews(){
        messagesRecylerView.layoutManager = LinearLayoutManager(this)
        messagesRecylerView.adapter = MessageAdapter(user)

        binding.chatName.text = name

        binding.chatBackBtn.setOnClickListener {
            onBackPressed()
        }

        Log.d(TAG, "initViews: ${db.collection("chats").document(chatId).path}")
        binding.sendMessageButton.setOnClickListener { sendMessage() }

        val chatRef = db.collection("chats").document(chatId)


        chatRef.collection("messages").orderBy("dob", Query.Direction.ASCENDING)
            .get()
            .addOnSuccessListener { messages ->
                val listMessages = messages.toObjects(Message::class.java)
                (messagesRecylerView.adapter as MessageAdapter).setData(listMessages)
            }

        chatRef.collection("messages").orderBy("dob", Query.Direction.ASCENDING)
            .addSnapshotListener { messages, error ->
                if(error == null){
                    messages?.let {
                        val listMessages = it.toObjects(Message::class.java)
                        (messagesRecylerView.adapter as MessageAdapter).setData(listMessages)
                    }
                }
            }
    }

    private fun sendMessage(){
        val message = Message(
            message = binding.messageTextField.text.toString(),
            from = user
        )
        Log.d(TAG, "sendMessage: sent $message")
        var messageDB = db.collection("chats").document(chatId).collection("messages").document().set(message)
        Log.d(TAG, "sendMessage: $messageDB ")
        binding.messageTextField.setText("")

    }
}