package com.example.aplikasistoragesqlite

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        email = sharedPreferences.getString("email", null)
        password = sharedPreferences.getString("password", null)

        buttonLogin.setOnClickListener {
            if(inputUsername.text.toString().isEmpty() &&
                inputPassword.text.toString().isEmpty()) {
                Toast.makeText(this, "Please input username and password", Toast.LENGTH_LONG)
            }
            else {
                val editor = sharedPreferences.edit()
                editor.putString(EMAIL_KEY, inputUsername.text.toString())
                editor.putString(PASSWORD_KEY, inputPassword.text.toString())

                editor.apply()
                val i = Intent(this,MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        if (email != null && password != null) {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}