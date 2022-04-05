package com.secondworld.retrofitforstudents.domain.useCases

import com.secondworld.retrofitforstudents.domain.repository.Repository

class CatUseCase(private val repository: Repository) {

    suspend fun catInfo(jsonBool: Boolean) = repository.catInfo(jsonBool)
}