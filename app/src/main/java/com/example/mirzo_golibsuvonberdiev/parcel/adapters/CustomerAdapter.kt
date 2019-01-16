package com.example.mirzo_golibsuvonberdiev.parcel.adapters

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.mirzo_golibsuvonberdiev.parcel.R
import com.example.mirzo_golibsuvonberdiev.parcel.activities.CustomerInfoActivity
import com.example.mirzo_golibsuvonberdiev.parcel.models.Customer
import kotlinx.android.synthetic.main.customer_item.view.*
import java.io.Serializable

/**
 * Created by mirzo-golibsuvonberdiev on 1/15/19.
 */
class CustomerAdapter(private val context: Context,
                      private val dataSource: List<Customer>) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
       return dataSource.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.customer_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val customer = dataSource.get(position)
        holder?.userName?.text = customer.first_name + " "+customer.last_name
        holder?.compName?.text = customer.company
        holder?.view.setOnClickListener({
          Toast.makeText(context, "You have clicked to "+customer.first_name, Toast.LENGTH_SHORT).show()
            val intent = Intent(context, CustomerInfoActivity::class.java)
            intent.putExtra("customer", customer)
            context.startActivity(intent)
        })


    }

}
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val view = itemView
    val userName = itemView.user_name
    val compName = itemView.user_company
}


