package com.example.demongodb.domain.document.error

import com.example.demongodb.global.error.exception.BusinessException

object InvalidProjectException: BusinessException(DocumentErrorCode.INVALID_PROJECT)