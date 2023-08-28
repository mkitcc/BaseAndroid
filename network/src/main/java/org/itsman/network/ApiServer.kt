package org.itsman.network

import org.itsman.network.entity.Hotkey
import retrofit2.http.GET

interface ApiServer {

    @GET("/hotkey/json")
    suspend fun getHotkey(): ResponseResult<List<Hotkey>>

}