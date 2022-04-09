package com.secondworld.retrofitforstudents.core

sealed class ApiState{

    object Empty : ApiState()
    object Loading : ApiState()
    class Success<T>(val data : T?) : ApiState()
    class Error(val message : String) : ApiState()
    class NoInternet(val message : String) : ApiState()
}
