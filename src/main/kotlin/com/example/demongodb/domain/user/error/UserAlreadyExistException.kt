package com.example.demongodb.domain.user.error

import com.example.demongodb.global.error.exception.BusinessException

object UserAlreadyExistException: BusinessException(UserErrorCode.USER_ALREADY_EXIST)