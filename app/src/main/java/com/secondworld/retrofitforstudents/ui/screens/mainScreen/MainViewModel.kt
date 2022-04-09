package com.secondworld.retrofitforstudents.ui.screens.mainScreen

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondworld.retrofitforstudents.core.ApiState
import com.secondworld.retrofitforstudents.core.NetworkHelper
import com.secondworld.retrofitforstudents.domain.useCases.CatUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val catUseCase: CatUseCase,
    context: Context
) : ViewModel() {

    private var _catInfo = MutableLiveData<ApiState>(ApiState.Empty)
    val catInfo: LiveData<ApiState> = _catInfo

    init {
        catInfo(true, context.applicationContext)
    }

    fun catInfo(jsonBool: Boolean, context : Context) {
        _catInfo.value = ApiState.Loading

        if(NetworkHelper.isNetworkConnected(context)){
            viewModelScope.launch {
                delay(2000)
                if (catUseCase.catInfo(jsonBool).isSuccessful)
                    _catInfo.postValue(ApiState.Success(catUseCase.catInfo(jsonBool).body()))
                else
                    _catInfo.value = ApiState.Error("some problems with response")
            }
        } else _catInfo.value = ApiState.NoInternet("internet is missing")

    }
}