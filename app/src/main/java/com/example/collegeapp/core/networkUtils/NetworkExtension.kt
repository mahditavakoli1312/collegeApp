package com.example.collegeapp.core.networkUtils

import retrofit2.Response

fun <T> Response<T>.bodyOrThrow(): T? {
    if (isSuccessful)
        return body()
    else {
        /*TODO : check errorBody */
        throw NetworkException(serverMessage = errorBody().toString(), code = code())
    }
}