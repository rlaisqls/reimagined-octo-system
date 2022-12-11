package com.example.demongodb.domain.user.error

import com.example.demongodb.global.error.exception.BusinessException

object UserNotFoundException: BusinessException(UserErrorCode.USER_NOT_FOUND)