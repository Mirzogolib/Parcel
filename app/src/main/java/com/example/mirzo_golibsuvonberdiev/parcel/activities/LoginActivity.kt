package com.example.mirzo_golibsuvonberdiev.parcel.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import com.example.mirzo_golibsuvonberdiev.parcel.R
import com.example.mirzo_golibsuvonberdiev.parcel.interfaces.ServiceInterface
import com.example.mirzo_golibsuvonberdiev.parcel.models.User
import com.example.mirzo_golibsuvonberdiev.parcel.services.Service
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {


    val apiService = Service().retrofit.create(ServiceInterface::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sign_in.setOnClickListener({
            val usName = username_edit_text.text.toString()
            val usPass = password_edit_text.text.toString()
            val user = User(usName, usPass)

            checking(user)

        })
    }

    private fun checking(user: User) {

        apiService.getToken(user)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    Log.d("CHECK", " " + result.access)
                    val auth :String = result.access!!
                    val intent = Intent(this, BaseActivity::class.java)
                    intent.putExtra("auth", auth)
                    startActivity(intent)
                }, { error ->
                    error.printStackTrace()
                    Snackbar.make(mainLayout, "Please, check all information ", Snackbar.LENGTH_SHORT).show()
                })
    }


}
