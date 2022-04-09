package com.secondworld.retrofitforstudents.ui.screens.mainScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.secondworld.retrofitforstudents.domain.useCases.CatUseCase

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val catUseCase: CatUseCase,
    private val context: Context,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.catUseCase, this.context) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}