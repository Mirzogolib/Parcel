package com.example.mirzo_golibsuvonberdiev.parcel

/**
 * Created by mirzo-golibsuvonberdiev on 11/24/18.
 */
class User {

    private var username: String = ""
    private var password: String = ""


    fun usernameReturn(user:User): String {
        return user.username
    }

    fun passwordReturn(user: User): String {
        return user.password
    }

    fun addingUsers(): User {
        val element = User()
        element.username = "migo"
        element.password = "password"

        return element
    }


}