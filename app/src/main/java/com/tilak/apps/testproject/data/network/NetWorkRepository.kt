package com.tilak.apps.testproject.data.network


import com.tilak.apps.testproject.model.CustomerModel
import com.tilak.apps.testproject.model.UserModel

class NetWorkRepository {


    suspend fun getCustomerList(): List<CustomerModel> {
        return ApiService.create().getCustomers()
    }


    suspend fun getUserList(): List<UserModel> {
        return ApiService.create().getUsers()
    }

}