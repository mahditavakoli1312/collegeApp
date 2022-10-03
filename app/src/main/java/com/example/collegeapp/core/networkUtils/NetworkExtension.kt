package com.example.collegeapp.core.networkUtils

import org.json.JSONObject
import retrofit2.Response

fun <T> Response<T>.bodyOrThrow(): T? {
    if (isSuccessful)
        return body()
    else {
        /*TODO : check errorBody */
        var errorMessage: String
        try {
            errorMessage = JSONObject(errorBody()?.string())
                .getJSONArray("message")
                .get(0).toString()
        } catch (e: Exception) {
            errorMessage = JSONObject(errorBody()?.string())
                .getString("message")

        }
        throw NetworkException(
            serverMessage = errorMessage, code = code()
        )
    }
}