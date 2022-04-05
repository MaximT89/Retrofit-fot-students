package com.secondworld.retrofitforstudents.domain.repository

import com.secondworld.retrofitforstudents.data.models.ResponseCats
import retrofit2.Response

interface Repository {

    suspend fun catInfo(jsonBool : Boolean) : Response<ResponseCats>
}