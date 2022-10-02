package com.example.collegeapp.core.networkUtils

sealed interface ResultWrapper<out T> {
    data class Success<T>(val data: T) : ResultWrapper<T>
    data class Failure<T>(val message: String, val code: Int, val localData: T) : ResultWrapper<T>
    data class ApplicationError<T>(val message: String, val localData: T) : ResultWrapper<T>
}