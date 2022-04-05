package com.secondworld.retrofitforstudents.ui.screens.mainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondworld.retrofitforstudents.core.ApiState
import com.secondworld.retrofitforstudents.data.models.ResponseCats
import com.secondworld.retrofitforstudents.domain.useCases.CatUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val catUseCase: CatUseCase) : ViewModel() {

    private var _catInfo = MutableLiveData<ApiState>(ApiState.Empty)
    val catInfo: LiveData<ApiState> = _catInfo

    init {
        catInfo(true)
    }

    fun catInfo(jsonBool: Boolean) {
        _catInfo.value = ApiState.Loading

        viewModelScope.launch {

            delay(2000)

            if (catUseCase.catInfo(jsonBool).isSuccessful)
                _catInfo.postValue(ApiState.Success(catUseCase.catInfo(jsonBool).body()))
            else
                _catInfo.value = ApiState.Error("some problems with response")
        }
    }
}