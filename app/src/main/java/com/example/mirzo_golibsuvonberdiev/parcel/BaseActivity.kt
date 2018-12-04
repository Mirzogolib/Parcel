package com.example.mirzo_golibsuvonberdiev.parcel

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_base.*

class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
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
}
