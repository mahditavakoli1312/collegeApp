package com.example.collegeapp.core.networkUtils

import com.example.collegeapp.core.data.AccessToken.Companion.getAccessToken
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.run {
            proceed(
                request()
                    .newBuilder()
                    .addHeader("Authorization", getAccessToken())
                    .build()
            )
        }
}

