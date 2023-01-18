package com.example.demongodb.global.error

import com.example.demongodb.global.error.exception.ErrorProperty
import org.springframework.http.HttpStatus

enum class GlobalErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "Method Not Allowed"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");

    override fun status(): Int = status.value()
    override fun message(): String = message
}