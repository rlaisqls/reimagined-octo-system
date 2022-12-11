package com.example.demongodb.global.security.exception

import com.example.demongodb.global.error.exception.BusinessException

object InvalidTokenException: BusinessException(SecurityErrorCode.INVALID_TOKEN)