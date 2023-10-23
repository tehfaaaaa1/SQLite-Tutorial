package com.example.aplikasistoragesqlite

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import java.util.prefs.Preferences

class LoginActivity : AppCompatActivity() {

    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val EMAIL_KEY = "daud"
        const val PASSWORD_KEY = "daudimpek"
    }
    private lateinit var sharedPreferences: SharedPreferences
    private var email: String? = null
    private var password: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val inputUsername: EditText = findViewById(R.id.inputUsername)
        val inputPassword: TextInputEditText = findViewById(R.id.inputPassword)
        val buttonLogin : Button = findViewById(R.id.loginButton)
    }
}