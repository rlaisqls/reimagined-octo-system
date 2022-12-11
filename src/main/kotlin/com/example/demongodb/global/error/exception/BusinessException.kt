package com.example.demongodb.global.error.exception

open class BusinessException(
    val errorProperty: ErrorProperty
): RuntimeException()