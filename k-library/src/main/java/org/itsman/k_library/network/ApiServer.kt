package org.itsman.k_library.network

import org.itsman.k_library.network.entity.Hotkey
import retrofit2.http.GET

interface ApiServer {

    @GET("/hotkey/json")
    suspend fun getHotkey(): ResponseResult<List<Hotkey>>

}