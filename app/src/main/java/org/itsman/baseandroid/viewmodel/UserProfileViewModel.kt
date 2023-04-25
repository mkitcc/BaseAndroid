package org.itsman.baseandroid.viewmodel

import androidx.lifecycle.ViewModel
import java.io.Closeable


class UserProfileViewModel(vararg closeables: Closeable?) : ViewModel(*closeables) {

}