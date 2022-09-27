package com.example.collegeapp.core.networkUtils

const val APPLICATION_ERROR_MESSAGE = "APPLICATION ERROR"

suspend fun <T> safeApiCall(api: suspend () -> T): ResultWrapper<T> {
    return try {
        ResultWrapper.Success(data = api.invoke())
    } catch (exception: Exception) {
        when (exception) {
            is NetworkException -> {
                ResultWrapper.Failure(
                    message = exception.serverMessage,
                    code = exception.code
                )
            }
            else -> {
                ResultWrapper.ApplicationError(
                    message = APPLICATION_ERROR_MESSAGE
                )
            }
        }
    }
}