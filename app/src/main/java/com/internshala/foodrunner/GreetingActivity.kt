package com.internshala.foodrunner

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SharedMemory
import android.widget.TextView

class GreetingActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        var mobile : String? = ""
        var password : String? = ""
        lateinit var sharedPreferences : SharedPreferences

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

        var txtShowMobile : TextView = findViewById<TextView>(R.id.txtMobile)
        var txtShowPassword : TextView = findViewById<TextView>(R.id.txtPassword)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE)
        mobile = sharedPreferences.getString("Mobile",mobile)
        password = sharedPreferences.getString("Password",password)


        txtShowMobile.text = "Mobile No. : $mobile"
        txtShowPassword.text = "Password : $password"


    }
}