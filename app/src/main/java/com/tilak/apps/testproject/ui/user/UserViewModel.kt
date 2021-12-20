package com.tilak.apps.testproject.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tilak.apps.testproject.data.network.NetWorkRepository
import com.tilak.apps.testproject.model.UserModel
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val networkRepository: NetWorkRepository = NetWorkRepository()

    private var listUsers: MutableLiveData<List<UserModel>> =
        MutableLiveData()

    fun getUserList(): LiveData<List<UserModel>> {
        return listUsers
    }

    fun fetchUserList() {
        viewModelScope.launch() {
            listUsers.value = networkRepository.getUserList()
        }
    }


}