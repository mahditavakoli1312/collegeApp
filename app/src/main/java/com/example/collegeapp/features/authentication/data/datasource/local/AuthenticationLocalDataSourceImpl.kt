package com.example.collegeapp.features.authentication.data.datasource.local

import android.content.SharedPreferences
import com.example.collegeapp.core.data.ConstanceValue
import javax.inject.Inject

class AuthenticationLocalDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : AuthenticationLocalDataSource{

    /*
      TODO The following methods should be changed based on the APIs
    */

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


}