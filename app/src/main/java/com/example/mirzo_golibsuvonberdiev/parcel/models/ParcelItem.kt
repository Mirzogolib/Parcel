package com.example.mirzo_golibsuvonberdiev.parcel.models

import com.google.gson.annotations.SerializedName

/**
 * Created by mirzo-golibsuvonberdiev on 12/7/18.
 */
data class ParcelItem(
        val sender: Int =0,
        val receiver: Int =0,
        val code: String?=null,
        val note:String?=null
)