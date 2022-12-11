package com.example.demongodb.global.error.exception

interface ErrorProperty {
    fun status(): Int
    fun message(): String
}