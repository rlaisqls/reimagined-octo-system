package com.example.demongodb.domain.document.service

import com.example.demongodb.domain.document.domain.enums.Visibility
import com.example.demongodb.domain.document.error.DocumentAccessRightException
import com.example.demongodb.domain.document.facade.DocumentFacade
import com.example.demongodb.domain.document.presentation.dto.response.QueryDocumentInfoResponse
import com.example.demongodb.domain.user.domain.enums.Authority
import com.example.demongodb.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class QueryDocumentInfoService(
    private val userFacade: UserFacade,
    private val documentFacade: DocumentFacade
) {
    @Transactional
    fun execute(documentId: UUID): QueryDocumentInfoResponse {

        val user = userFacade.getCurrentUser()
        val document = documentFacade.queryById(documentId)

        if((document.visibility == Visibility.PRIVATE) ||
            (user.authority == Authority.STUDENT && !document.isWriter(user))) {

            throw DocumentAccessRightException
        }

        return document.run {
            QueryDocumentInfoResponse(
                writer = writer,
                updatedAt = updatedAt,
                introduce = introduce,
                projectList = projectList,
                experienceList = experienceList
            )
        }
    }

}