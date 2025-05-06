package org.itsman.fastlibrary.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UserProfileViewModel : ViewModel() {

    val user: MutableLiveData<User> by lazy {
        MutableLiveData<User>().also {
            loadUser()
        }
    }

    private fun loadUser() {
        user.value = User("Kevin")
    }

}

class User(var name: String);