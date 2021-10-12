package com.internshala.foodrunner

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etMobileNumber : EditText
    lateinit var etPassword : EditText
    lateinit var btnLogin : Button
    lateinit var txtForgotPassword : TextView
    lateinit var txtSignup : TextView
    lateinit var mobile : String
    lateinit var password : String

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        sharedPreferences = getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE)

        var isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn){
            val intent = Intent(this@LoginActivity,GreetingActivity::class.java)
            startActivity(intent)
            finish()
        }

        var etMobileNumber = findViewById<EditText>(R.id.etMobileNumber)
        var etPassword = findViewById<EditText>(R.id.etPassword)
        var btnLogin = findViewById<Button>(R.id.btnLogin)
        var txtForgotPassword = findViewById<TextView>(R.id.txtForgotPassword)
        var txtSignup = findViewById<TextView>(R.id.txtSignup)



        btnLogin.setOnClickListener {

            mobile = etMobileNumber.text.toString()
            password = etPassword.text.toString()

            if ((mobile.isNotEmpty())&&(password.isNotEmpty())) {
                val intent = Intent(this@LoginActivity, GreetingActivity::class.java)
                intent.putExtra("Mobile", mobile)
                intent.putExtra("Password", password)
                savePreference(mobile,password)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this@LoginActivity,"All fields are required",Toast.LENGTH_LONG).show()
            }
        }

        txtForgotPassword.setOnClickListener{
            val intent = Intent(this@LoginActivity,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        txtSignup.setOnClickListener {
            val intent = Intent(this@LoginActivity,RegisterActivity::class.java)
            startActivity(intent)

        }

    }
    fun savePreference(mobile:String,password:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Mobile",mobile).apply()
        sharedPreferences.edit().putString("Password",password).apply()
    }

    override fun onClick(v: View?) {

    }
}

