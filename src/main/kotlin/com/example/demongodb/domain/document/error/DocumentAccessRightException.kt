package com.example.demongodb.domain.document.error

import com.example.demongodb.global.error.exception.BusinessException

object DocumentAccessRightException: BusinessException(DocumentErrorCode.DOCUMENT_ACCESS_RIGHT)