package org.itsman.baseandroid

import org.itsman.fastlibrary.network.ResponseResult
import org.itsman.fastlibrary.network.entity.Hotkey
import retrofit2.http.GET

interface ApiServer {


    @GET("/hotkey/json")
    suspend fun getHotkey(): ResponseResult<List<Hotkey>>
}