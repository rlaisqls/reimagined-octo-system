package com.example.demongodb.global.security.exception

import com.example.demongodb.domain.user.error.UserErrorCode
import com.example.demongodb.global.error.exception.BusinessException


object ExpiredTokenException: BusinessException(SecurityErrorCode.EXPIRED_TOKEN)