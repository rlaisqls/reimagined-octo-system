package com.example.demongodb.domain.document.error

import com.example.demongodb.global.error.exception.BusinessException

object DocumentNotFoundException: BusinessException(DocumentErrorCode.DOCUMENT_NOT_FOUND)