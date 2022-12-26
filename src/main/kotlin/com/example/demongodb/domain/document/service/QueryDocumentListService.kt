package com.example.demongodb.domain.document.service

import com.example.demongodb.domain.document.domain.repository.DocumentRepository
import com.example.demongodb.domain.document.facade.DocumentFacade
import com.example.demongodb.domain.document.presentation.dto.request.QueryDocumentListRequest
import com.example.demongodb.domain.document.presentation.dto.response.QueryDocumentListResponse
import com.example.demongodb.domain.document.presentation.dto.response.QueryDocumentListResponse.Companion.DocumentResponse
import com.example.demongodb.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class QueryDocumentListService(
    private val userFacade: UserFacade,
    private val documentFacade: DocumentFacade,
    private val documentRepository: DocumentRepository
) {
    @Transactional
    fun execute(request: QueryDocumentListRequest): QueryDocumentListResponse {


        /*
        val documentList = documentRepository.queryByVersionAndWriterInfo(
            version = request.version,
            grade = request.grade,
            classNum = request.classNum,
            jobTitle = request.jobTitle
        )

        return QueryDocumentListResponse(
            list = documentList.map { DocumentResponse(it) }
        )*/
        return QueryDocumentListResponse(listOf())
    }
}