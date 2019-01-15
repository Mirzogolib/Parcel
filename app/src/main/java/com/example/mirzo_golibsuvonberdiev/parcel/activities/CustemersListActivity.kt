package com.example.mirzo_golibsuvonberdiev.parcel.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.mirzo_golibsuvonberdiev.parcel.R
import com.example.mirzo_golibsuvonberdiev.parcel.R.id.customers_list
import com.example.mirzo_golibsuvonberdiev.parcel.adapters.CustomerAdapter
import com.example.mirzo_golibsuvonberdiev.parcel.interfaces.ServiceInterface
import com.example.mirzo_golibsuvonberdiev.parcel.models.Customer
import com.example.mirzo_golibsuvonberdiev.parcel.services.Service
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CustemersListActivity : AppCompatActivity() {

    private lateinit var recView: RecyclerView
    val apiService = Service().retrofit.create(ServiceInterface::class.java)
//    private lateinit var customerList : List<Customer>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custemers_list)
        recView = findViewById(R.id.customers_list)

        apiService.getCustomerList()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("CHECK", " " + it.results.size)
//                    customerList= it.results
                    recView.layoutManager = LinearLayoutManager(this)
                    val adapter = CustomerAdapter(this, it.results)
                    recView.adapter = adapter



                }, {
                    Log.d("CHECK", " failed to access ")

                })


    }


}
