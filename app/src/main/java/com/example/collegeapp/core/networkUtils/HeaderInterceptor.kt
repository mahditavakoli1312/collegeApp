package com.example.collegeapp.core.networkUtils


import android.content.SharedPreferences
import com.example.collegeapp.core.data.ConstanceValue
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val sharePrefToken = sharedPreferences.getString(ConstanceValue.TOKEN, "")
        var token = ""
        if (sharePrefToken != null)
            token = sharePrefToken
        return chain.run {
            proceed(
                request()
                    .newBuilder()
                    .addHeader(
                        "Authorization",
                        token
                    )
                    .build()
            )
        }
    }

}

