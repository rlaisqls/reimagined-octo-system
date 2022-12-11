package com.example.demongodb.domain.auth.domain.error

import com.example.demongodb.global.error.exception.BusinessException

object RefreshTokenNotFoundException: BusinessException(AuthErrorCode.REFRESH_TOKEN_NOT_FOUND)