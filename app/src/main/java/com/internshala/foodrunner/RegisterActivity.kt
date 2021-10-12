package com.internshala.foodrunner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etMobileNo: EditText
    lateinit var etDeliveryAddress: EditText
    lateinit var etChoosePassword: EditText
    lateinit var etConfirmPassword: EditText
    lateinit var btnRegister: Button
    lateinit var name: String
    lateinit var email: String
    lateinit var mobile: String
    lateinit var deliveryAddress: String
    lateinit var choosePassword: String
    lateinit var confirmPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var etName = findViewById<EditText>(R.id.etName)
        var etEmail = findViewById<EditText>(R.id.etEmail)
        var etMobileNo = findViewById<EditText>(R.id.etMobileNo)
        var etDeliveryAddress = findViewById<EditText>(R.id.etDeliveryAddress)
        var etChoosePassword = findViewById<EditText>(R.id.etChoosePassword)
        var etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        var btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            name = etName.text.toString()
            email = etEmail.text.toString()
            mobile = etMobileNo.text.toString()
            deliveryAddress = etDeliveryAddress.text.toString()
            choosePassword = etChoosePassword.text.toString()
            confirmPassword = etConfirmPassword.text.toString()

            if ((name.isNotEmpty()) && (email.isNotEmpty()) && (mobile.isNotEmpty()) && (deliveryAddress.isNotEmpty()) && (choosePassword.isNotEmpty()) && (confirmPassword.isNotEmpty())) {
                if (choosePassword == confirmPassword) {
                    val intent = Intent(this@RegisterActivity, RegistrationDetailsActivity::class.java)
                    intent.putExtra("Name", name)
                    intent.putExtra("Email", email)
                    intent.putExtra("MobileNo", mobile)
                    intent.putExtra("DeliveryAddress", deliveryAddress)
                    intent.putExtra("Password", choosePassword)
                    startActivity(intent)
                }else{
                    Toast.makeText(this@RegisterActivity,"Passwords do not match",Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this@RegisterActivity, "All fields are required", Toast.LENGTH_LONG)
                    .show()
            }


        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}