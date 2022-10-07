package com.example.collegeapp.features.authentication.data.datasource.local

import android.content.SharedPreferences
import com.example.collegeapp.core.data.ConstanceValue
import javax.inject.Inject

class AuthenticationLocalDataSource @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun isLogin(): Boolean {
        return sharedPreferences.contains(ConstanceValue.TOKEN)
    }

    fun setAccessToken(token: String) {
        val edit = sharedPreferences.edit()
        edit.putString(ConstanceValue.TOKEN, token)
        edit.apply()
    }

    fun setUserID(userId: Int) {
        val edit = sharedPreferences.edit()
        edit.putInt(ConstanceValue.USER_ID, userId)
        edit.apply()
    }

    fun getUserID(): Int =
        sharedPreferences.getInt(ConstanceValue.USER_ID, -1)

    fun setUserFullName(fullName: String) {
        val edit = sharedPreferences.edit()
        edit.putString(ConstanceValue.USER_FULL_NAME, fullName)
        edit.apply()
    }

    fun getUserFullName(): String =
        sharedPreferences.getString(ConstanceValue.USER_FULL_NAME, "") ?: ""

}