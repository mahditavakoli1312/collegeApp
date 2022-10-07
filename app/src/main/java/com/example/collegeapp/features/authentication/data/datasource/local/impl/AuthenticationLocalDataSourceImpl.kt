package com.example.collegeapp.features.authentication.data.datasource.local.impl

import android.content.SharedPreferences
import com.example.collegeapp.core.data.ConstanceValue
import com.example.collegeapp.features.authentication.data.datasource.local.AuthenticationLocalDataSource
import javax.inject.Inject

class AuthenticationLocalDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : AuthenticationLocalDataSource {
    override fun isLogin(): Boolean {
        return sharedPreferences.contains(ConstanceValue.TOKEN)
    }

    override fun setAccessToken(token: String) {
        val edit = sharedPreferences.edit()
        edit.putString(ConstanceValue.TOKEN, token)
        edit.apply()
    }

    override fun setUserID(userId: Int) {
        val edit = sharedPreferences.edit()
        edit.putInt(ConstanceValue.USER_ID, userId)
        edit.apply()
    }

    override fun getUserID(): Int =
        sharedPreferences.getInt(ConstanceValue.USER_ID, -1)

    override fun setUserFullName(fullName: String) {
        val edit = sharedPreferences.edit()
        edit.putString(ConstanceValue.USER_FULL_NAME, fullName)
        edit.apply()
    }

    override fun getUserFullName(): String =
        sharedPreferences.getString(ConstanceValue.USER_FULL_NAME, "") ?: ""

}