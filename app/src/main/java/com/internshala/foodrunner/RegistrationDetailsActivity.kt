package com.internshala.foodrunner

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegistrationDetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

         var name : String? = ""
         var email : String? = ""
         var mobile : String? = ""
         var deliveryAddress : String? = ""
         var password : String? = ""

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_details)

        var txtShowName : TextView = findViewById(R.id.txtName)
        var txtShowEmail : TextView = findViewById(R.id.txtEmail)
        var txtShowMobile : TextView = findViewById(R.id.txtMobile)
        var txtShowDeliveryAddress : TextView = findViewById(R.id.txtDeliveryAddress)
        var txtShowPassword : TextView = findViewById(R.id.txtPassword)

        name = intent.getStringExtra("Name")
        email = intent.getStringExtra("Email")
        mobile = intent.getStringExtra("MobileNo")
        deliveryAddress = intent.getStringExtra("DeliveryAddress")
        password = intent.getStringExtra("Password")

        txtShowName.text = "Name: $name"
        txtShowEmail.text = "Email : $email"
        txtShowMobile.text = "Mobile No. : $mobile"
        txtShowDeliveryAddress.text = "Delivery Address : $deliveryAddress"
        txtShowPassword.text = "Password : $password"




    }
}