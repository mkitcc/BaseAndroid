package org.itsman.fastlibrary.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.yield
import okhttp3.Dispatcher
import org.itsman.fastlibrary.network.HttpClient
import org.itsman.fastlibrary.network.HttpResult
import org.itsman.fastlibrary.tools.log

class MainActivityVM : ViewModel() {

    var data = MutableStateFlow<String>("")
    var stat = mutableStateOf("Hello")
    fun getData() {
        viewModelScope.launch {
            val request = HttpClient.apiserver.getHotkey().result()
            when (request) {
                is HttpResult.Success -> {
                    data.value = request.data.toString()
                }

                is HttpResult.Error -> {

                }
            }
        }
    }
}