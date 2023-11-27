package org.itsman.baseandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.itsman.fastlibrary.network.HttpClient
import org.itsman.fastlibrary.network.RequestResult

class MainActivityVM : ViewModel() {

    var data = MutableLiveData<String?>()
    fun getData() {
        viewModelScope.launch {
            HttpClient.request { HttpClient.getApi().getHotkey() }.collect {
                when (it) {
                    is RequestResult.Success -> {
                        data.value = it.data.data.toString()
                    }

                    is RequestResult.Error -> {
                        data.value = it.errorMsg
                    }
                }
            }
        }

    }
}