package com.example.demongodb.domain.document.service

import com.example.demongodb.domain.document.domain.element.ProjectElement
import com.example.demongodb.domain.document.domain.repository.DocumentRepository
import com.example.demongodb.domain.document.error.DocumentNotFoundException
import com.example.demongodb.domain.document.facade.DocumentFacade
import com.example.demongodb.domain.document.presentation.dto.request.UpdateProjectRequest
import com.example.demongodb.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UpdateProjectService(
    private val documentRepository: DocumentRepository,
    private val documentFacade: DocumentFacade,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(request: UpdateProjectRequest) {

        val user = userFacade.getCurrentUser()
        val document = documentFacade.findById(request.documentId)
        if(!document.isWriter(user)) throw DocumentNotFoundException

        document.updateProject(request.list.map {
            ProjectElement(
                name = it.name,
                startDate = it.startDate,
                isDoing = it.isDoing,
                endDate = it.endDate,
                description = it.description
            )
        })

        documentRepository.save(document)
    }

}