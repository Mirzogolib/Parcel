package com.example.mirzo_golibsuvonberdiev.parcel.models

import java.io.Serializable

/**
 * Created by mirzo-golibsuvonberdiev on 12/11/18.
 */
class Customer(
        val id: Int = 0,
        val first_name: String? = null,
        val last_name: String? = null,
        val company: String? = null,
        val address: String? = null,
        val country: String? = null,
        val city: String? = null,
        val postal_code: String? = null,
        val phone: String? = null,
        val email: String? = null

) : Serializable