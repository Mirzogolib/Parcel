package com.example.mirzo_golibsuvonberdiev.parcel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sign_in.setOnClickListener({
            val usName = username_edit_text.text.toString()
            val usPass = password_edit_text.text.toString()
            val user = User().addingUsers()

            if (usName.equals(user.usernameReturn(user)) && usPass.equals(user.passwordReturn(user))) {
                val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
            } else Snackbar.make(mainLayout, "Please, check all information", Snackbar.LENGTH_SHORT).show()
        })
    }


}
