package com.example.collegeapp.core.data

class AccessToken {
    companion object {
        private val accessToken =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjM3LCJpYXQiOjE2NjQ5MDgzMzAsImV4cCI6MTY2NDk5NDczMH0.U9NLKWJhRiR2dLZIwmewtSCyHs05RlgX-IUeaEQIzrA"

        fun getAccessToken(): String =
            accessToken
    }
}