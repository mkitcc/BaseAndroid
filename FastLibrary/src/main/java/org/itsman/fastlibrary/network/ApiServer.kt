package org.itsman.fastlibrary.network

import org.itsman.fastlibrary.network.entity.Hotkey
import retrofit2.http.GET

interface ApiServer {

    @GET("/hotkey/json")
    suspend fun getHotkey(): Response<List<Hotkey>>

}