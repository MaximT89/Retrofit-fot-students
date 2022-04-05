package com.secondworld.retrofitforstudents.data.api

import com.secondworld.retrofitforstudents.data.models.ResponseCats
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/cat")
    suspend fun catInfo(@Query("json") jsonBool: Boolean): Response<ResponseCats>

    class ApiServiceImpl : ApiService{
        override suspend fun catInfo(jsonBool: Boolean): Response<ResponseCats> {
            return ApiClient.getApiService().catInfo(jsonBool)
        }
    }
}