package com.secondworld.retrofitforstudents.ui.screens.mainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondworld.retrofitforstudents.data.models.ResponseCats
import com.secondworld.retrofitforstudents.domain.useCases.CatUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val catUseCase: CatUseCase) : ViewModel() {

    private var _catInfo = MutableLiveData<ResponseCats>()
    val catInfo: LiveData<ResponseCats> = _catInfo

    init {
        catInfo(true)
    }

    fun catInfo(jsonBool: Boolean) {
        viewModelScope.launch {


            if (catUseCase.catInfo(jsonBool).isSuccessful)
                _catInfo.postValue(catUseCase.catInfo(jsonBool).body())
            else
                throw Exception("some problems")


        }
    }
}