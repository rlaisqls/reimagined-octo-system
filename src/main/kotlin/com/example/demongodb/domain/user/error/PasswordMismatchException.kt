package com.example.demongodb.domain.user.error

import com.example.demongodb.global.error.exception.BusinessException

object PasswordMismatchException: BusinessException(UserErrorCode.PASSWORD_MISMATCH)