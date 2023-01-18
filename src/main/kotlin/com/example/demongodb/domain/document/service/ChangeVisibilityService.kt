package com.example.demongodb.domain.document.service

import com.example.demongodb.domain.document.domain.repository.DocumentRepository
import com.example.demongodb.domain.document.error.DocumentNotFoundException
import com.example.demongodb.domain.document.facade.DocumentFacade
import com.example.demongodb.domain.document.presentation.dto.request.ChangeVisibilityRequest
import com.example.demongodb.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ChangeVisibilityService (
    private val userFacade: UserFacade,
    private val documentFacade: DocumentFacade,
    private val documentRepository: DocumentRepository
) {
    @Transactional
    fun execute(request: ChangeVisibilityRequest) {

        val user = userFacade.getCurrentUser()
        val document = documentFacade.findById(request.documentId)

        if(!document.isWriter(user)) throw DocumentNotFoundException

        document.changeVisibility(request.visibility)
        documentRepository.save(document)
    }
}