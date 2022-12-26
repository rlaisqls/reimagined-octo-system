package com.example.demongodb.domain.document.service

import com.example.demongodb.domain.document.facade.DocumentFacade
import com.example.demongodb.domain.document.presentation.dto.response.QueryDocumentListResponse
import com.example.demongodb.domain.document.presentation.dto.response.QueryDocumentListResponse.Companion.DocumentResponse
import com.example.demongodb.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class QueryMyDocumentListService(
    private val userFacade: UserFacade,
    private val documentFacade: DocumentFacade
) {
    @Transactional
    fun execute(): QueryDocumentListResponse {

        val user = userFacade.getCurrentUser()

        val documentList = documentFacade.queryByStudent(user)

        return QueryDocumentListResponse(
            list = documentList.map { DocumentResponse(it) }
        )
    }

}