package com.example.demongodb.domain.student.error

import com.example.demongodb.global.error.exception.BusinessException

object StudentNotFoundException: BusinessException(StudentErrorCode.STUDENT_NOT_FOUND)