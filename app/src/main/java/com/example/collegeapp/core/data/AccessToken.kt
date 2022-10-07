package com.example.collegeapp.core.data

class AccessToken {
    companion object {
        private val accessToken =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjM3LCJpYXQiOjE2NjUwNzYzMTgsImV4cCI6MTY2NTE2MjcxOH0.rZE2v_spo_woulDHNPxGCx2qyWdtzSTjzjzZX0N43xw"

        fun getAccessToken(): String =
            accessToken
    }
}