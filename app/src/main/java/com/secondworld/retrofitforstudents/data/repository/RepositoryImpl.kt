package com.secondworld.retrofitforstudents.data.repository

import com.secondworld.retrofitforstudents.data.api.ApiClient
import com.secondworld.retrofitforstudents.data.api.ApiService
import com.secondworld.retrofitforstudents.data.models.ResponseCats
import com.secondworld.retrofitforstudents.domain.repository.Repository
import retrofit2.Response

class RepositoryImpl : Repository {

    override suspend fun catInfo(jsonBool: Boolean): Response<ResponseCats> {
        return ApiService.ApiServiceImpl().catInfo(jsonBool)
    }
}