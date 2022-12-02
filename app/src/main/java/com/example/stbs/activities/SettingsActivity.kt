package com.example.stbs.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.stbs.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_settings.*


private const val TAG = "SettingsActivity"
class SettingsActivity : AppCompatActivity() {

    private val auth = Firebase.auth

    private val current_mail = auth.currentUser?.email

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        Log.d(TAG, "onCreate: hello $current_mail")

        welcome_user.text = "Welcome $current_mail"

        change_pwd_btn.setOnClickListener { changePwd() }

        logout_btn.setOnClickListener { signOut() }

        settings_back_btn.setOnClickListener { pressBack() }

    }

    private fun pressBack(){
        onBackPressed()
    }

    private fun signOut(){
        auth.signOut().also {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

    private fun changePwd(){
        auth.sendPasswordResetEmail(current_mail.toString())
        Toast.makeText(this,"A mail to change password has been sent to $current_mail",Toast.LENGTH_LONG).show()
    }
}