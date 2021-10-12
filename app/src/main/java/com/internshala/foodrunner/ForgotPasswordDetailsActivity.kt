package com.internshala.foodrunner

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class ForgotPasswordDetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        var mobile : String? = ""
        var email :String? = ""

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password_details)

        var txtShowMobile : TextView = findViewById(R.id.txtMobile)
        var txtShowEmail : TextView = findViewById(R.id.txtEmail)

        mobile = intent.getStringExtra("MobileNumber")
        email = intent.getStringExtra("Email")

        txtShowMobile.text = "Mobile No. : $mobile"
        txtShowEmail.text = "Email : $email "


    }
}