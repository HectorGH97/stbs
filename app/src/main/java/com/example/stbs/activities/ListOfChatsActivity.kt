package com.example.stbs.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stbs.models.Chat
import com.example.stbs.adapters.ChatAdapter
import com.example.stbs.R
import com.example.stbs.databinding.ActivityListOfChatsBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_list_of_chats.*
import java.util.*

private const val TAG = "ListOfChatsActivity"

class ListOfChatsActivity : AppCompatActivity() {
    private var user = ""

    private var db = Firebase.firestore

    private val binding by lazy{
        ActivityListOfChatsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent.getStringExtra("user")?.let { user = it }

        if (user.isNotEmpty()){
            initViews()
        }
    }

    private fun initViews(){
        newChatButton.setOnClickListener { newChat() }

        binding.listChatsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.listChatsRecyclerView.adapter =
            ChatAdapter { chat ->
                chatSelected(chat)
            }

        val userRef = db.collection("users").document(user)

        Log.d(TAG, "initViews: $userRef")

        userRef.collection("chats")
            .get()
            .addOnSuccessListener { chats ->
                val listChats = chats.toObjects(Chat::class.java)

                (listChatsRecyclerView.adapter as ChatAdapter).setData(listChats)
            }

        userRef.collection("chats")
            .addSnapshotListener { chats, error ->
                if(error == null){
                    chats?.let {
                        val listChats = it.toObjects(Chat::class.java)

                        (listChatsRecyclerView.adapter as ChatAdapter).setData(listChats)
                    }
                }
            }

        binding.settingsBtn.setOnClickListener{
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun chatSelected(chat: Chat){
        val intent = Intent(this, ChatActivity::class.java)
        intent.putExtra("chatId", chat.id)
        intent.putExtra("user", user)
        intent.putExtra("name", chat.name)
        startActivity(intent)
    }

    private fun newChat(){
        val chatId = UUID.randomUUID().toString()
        val otherUser = binding.newChatText.text.toString()
        val users = listOf(user, otherUser)
        val chat_name = "Chat with $user & $otherUser"
        val chat = Chat(
            id = chatId,
            name = chat_name,
            users = users
        )
        Log.d(TAG, "newChat: $chat")

        db.collection("chats").document(chatId).set(chat)
        db.collection("users").document(user).collection("chats").document(chatId).set(chat)
        db.collection("users").document(otherUser).collection("chats").document(chatId).set(chat)

        val intent = Intent(this, ChatActivity::class.java)
        intent.putExtra("chatId", chatId)
        intent.putExtra("user", user)
        intent.putExtra("name", chat_name)
        startActivity(intent).also {
            Log.d(TAG, "newChat: entering intent $intent")
        }
    }
}