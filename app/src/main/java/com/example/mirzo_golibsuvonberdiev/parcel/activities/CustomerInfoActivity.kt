package com.example.mirzo_golibsuvonberdiev.parcel.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mirzo_golibsuvonberdiev.parcel.R
import com.example.mirzo_golibsuvonberdiev.parcel.models.Customer
import kotlinx.android.synthetic.main.activity_customer_info.*

class CustomerInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_info)
        val customer = intent.getSerializableExtra("customer") as Customer
        user_name_info.text = customer.first_name + " "+ customer.last_name
        user_company_info.text = customer.company
        user_address_info.text = customer.address
        user_country_info.text = customer.country
        user_city_info.text = customer.city
        user_postal_code_info.text = customer.postal_code
        user_phone_info.text = customer.phone
        user_email_info.text = customer.email



    }
}
