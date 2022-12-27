package com.example.demongodb.domain.student.error

import com.example.demongodb.global.error.exception.ErrorProperty

enum class StudentErrorCode (
    private val status: Int,
    private val message: String
) : ErrorProperty {

    STUDENT_NOT_FOUND(404, "Student Not Found");

    override fun status(): Int = status
    override fun message(): String = message

}