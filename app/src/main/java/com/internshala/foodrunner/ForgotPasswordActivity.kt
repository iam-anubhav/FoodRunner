package com.internshala.foodrunner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgotPasswordActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etMobileNumber : EditText
    lateinit var etEmail : EditText
    lateinit var btnNext : Button
    lateinit var mobile : String
    lateinit var email : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        var etMobileNumber = findViewById<EditText>(R.id.etMobileNumber)
        var etEmail = findViewById<EditText>(R.id.etEmail)
        var btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            mobile = etMobileNumber.text.toString()
            email = etEmail.text.toString()

            if ((mobile.isNotEmpty())&&(email.isNotEmpty())){
                val intent = Intent (this@ForgotPasswordActivity,ForgotPasswordDetailsActivity::class.java)
                intent.putExtra("MobileNumber",mobile)
                intent.putExtra("Email",email)
                startActivity(intent)
            }else{
                Toast.makeText(this@ForgotPasswordActivity,"All fields are required",Toast.LENGTH_LONG).show()
            }
        }


    }

    override fun onClick(v: View?) {
    }
}