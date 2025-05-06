package org.itsman.fastlibrary.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.itsman.fastlibrary.network.HttpClient
import org.itsman.fastlibrary.network.HttpResult

class MainActivityVM : ViewModel() {

    var data = MutableStateFlow<String>("")
    var stat = mutableStateOf("Hello")
    fun getData() {
        viewModelScope.launch {
            val request = HttpClient.apiserver.getHotkey().result()
            when(request){
                is HttpResult.Success->{
                    data.value=request.data.toString()
                }
                is HttpResult.Error->{

                }
            }
        }

    }
}