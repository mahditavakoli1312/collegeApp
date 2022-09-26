package com.example.collegeapp.core.networkUtils

interface ResultWrapper<out T> {
    data class Success<T>(val data: T) : ResultWrapper<T>
    data class Failure(val message: String, val code: Int) : ResultWrapper<Nothing>
    data class ApplicationError(val message: String) : ResultWrapper<Nothing>
}