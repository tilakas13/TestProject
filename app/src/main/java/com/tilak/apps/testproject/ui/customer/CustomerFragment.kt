package com.tilak.apps.testproject.ui.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tilak.apps.testproject.databinding.FragmentCustomerBinding

class CustomerFragment : Fragment() {

    lateinit var binding: FragmentCustomerBinding
    private val customerAdapter = CustomerAdapter()
    private val model: CustomerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rlCustomerList.apply {
            adapter = customerAdapter
            layoutManager = LinearLayoutManager(context)
        }

        model.getCustomerDate()

        model.getCustomer().observeForever { it ->
            customerAdapter.updateCustomerList(it)
            customerAdapter.notifyDataSetChanged()
        }

    }


}