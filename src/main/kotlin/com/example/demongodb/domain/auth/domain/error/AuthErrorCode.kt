package com.example.demongodb.domain.auth.domain.error

import com.example.demongodb.global.error.exception.ErrorProperty

enum class AuthErrorCode (
    private val status: Int,
    private val message: String
): ErrorProperty {

    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found");

    override fun message(): String = message
    override fun status(): Int = status
}