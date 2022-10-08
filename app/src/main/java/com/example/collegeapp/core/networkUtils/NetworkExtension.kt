package com.example.collegeapp.core.networkUtils

import com.example.collegeapp.core.data.ConstanceValue
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Response

fun <T> Response<T>.bodyOrThrow(): T? {
    if (isSuccessful)
        return body()
    else {
        val gson = Gson()
        val errorBody = errorBody()?.string()
        val errorMessage: String = try {
            val errors = gson.fromJson(errorBody, ErrorsResponse::class.java).message
            if(errors != null)
                errors[0]?:""
            else ConstanceValue.FAILURE
        } catch (e: Exception) {
            gson.fromJson(errorBody, ErrorResponse::class.java).message
        }
        throw NetworkException(
            serverMessage = errorMessage, code = code()
        )
    }
}