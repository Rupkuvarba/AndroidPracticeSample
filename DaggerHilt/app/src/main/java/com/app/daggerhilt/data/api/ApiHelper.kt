package com.app.daggerhilt.data.api

import com.app.daggerhilt.data.model.User
import retrofit2.Response
interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>

}