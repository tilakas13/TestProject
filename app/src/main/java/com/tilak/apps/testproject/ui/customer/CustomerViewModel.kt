package com.tilak.apps.testproject.ui.customer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tilak.apps.testproject.data.network.NetWorkRepository
import com.tilak.apps.testproject.model.CustomerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerViewModel : ViewModel() {

    private val networkRepository: NetWorkRepository = NetWorkRepository()

    private var listCustomer: MutableLiveData<List<CustomerModel>> =
        MutableLiveData()

    fun getCustomer(): LiveData<List<CustomerModel>> {
        return listCustomer as LiveData<List<CustomerModel>>
    }


    fun getCustomerDate() {

        viewModelScope.launch() {
            listCustomer.value = networkRepository.getCustomerList()
        }

    }
}