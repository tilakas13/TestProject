package com.tilak.apps.testproject.ui.customer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tilak.apps.testproject.R
import com.tilak.apps.testproject.model.CustomerModel

class CustomerAdapter : RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    private var listCustomer = mutableListOf<CustomerModel>()

    class CustomerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title = view.findViewById<TextView>(R.id.tv_customer_title)
        var description: TextView = view.findViewById<TextView>(R.id.tv_customer_description)
        var imageCustomer = view.findViewById<ImageView>(R.id.iv_customer_profile)

        fun setData(customerModel: CustomerModel) {
            title.text = customerModel.customerName
            description.text = customerModel.cityName

            Glide
                .with(imageCustomer.context)
                .load(customerModel.imageUrl)
                .centerCrop()
                .into(imageCustomer);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_customer, parent, false)
        return CustomerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        holder.setData(listCustomer[position])
    }

    override fun getItemCount(): Int {
        return listCustomer.size
    }

    fun updateCustomerList(list: List<CustomerModel>) {
        this.listCustomer.addAll(list)
    }
}