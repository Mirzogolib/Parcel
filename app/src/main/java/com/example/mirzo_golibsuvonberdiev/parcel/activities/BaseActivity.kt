package com.example.mirzo_golibsuvonberdiev.parcel.activities


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mirzo_golibsuvonberdiev.parcel.R
import com.example.mirzo_golibsuvonberdiev.parcel.interfaces.ServiceInterface
import com.example.mirzo_golibsuvonberdiev.parcel.services.Service
import com.google.zxing.integration.android.IntentIntegrator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_base.*


class BaseActivity : AppCompatActivity() {
    //initializing Service
    val apiService = Service().retrofit.create(ServiceInterface::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        getCustomer()

        qrcode_button.setOnClickListener({
            val inegator = IntentIntegrator(this)
            inegator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
            inegator.setPrompt("Scan")
            inegator.setCameraId(0)
            inegator.setBeepEnabled(false)
            inegator.setBarcodeImageEnabled(false)
            inegator.initiateScan()


        })

        web_button!!.setOnClickListener({
            val intent = Intent(this@BaseActivity, WebActivity::class.java)
            startActivity(intent)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                qr_result.setText("YOu canceled Scanning")
            } else {
                qr_result.setText(result.contents)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }


//getting Customer using retrofit
    fun getCustomer(){
        apiService.getParcelList()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Toast.makeText(applicationContext, " " + it.results[1].id, Toast.LENGTH_SHORT)
                    Log.d("CHECK", " " + it.results.size)
                    for (i in 0..it.results.size) {
                        Log.d("CHECK", " " + it.results[i].first_name)
                        Log.d("CHECK", " " + it.results[i].last_name)
                    }

                }, {
                    Log.d("CHECK", " failed to access ")
                })
    }

}
