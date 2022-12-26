package com.example.demongodb.domain.document.service

import com.example.demongodb.domain.document.domain.element.ExperienceElement
import com.example.demongodb.domain.document.domain.repository.DocumentRepository
import com.example.demongodb.domain.document.error.DocumentNotFoundException
import com.example.demongodb.domain.document.facade.DocumentFacade
import com.example.demongodb.domain.document.presentation.dto.request.ChangeVisibilityRequest
import com.example.demongodb.domain.document.presentation.dto.request.UpdateExperienceRequest
import com.example.demongodb.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Flux
import java.time.YearMonth


@Service
class UpdateExperienceService(
    private val documentRepository: DocumentRepository,
    private val documentFacade: DocumentFacade,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(request: UpdateExperienceRequest) {

        val user = userFacade.getCurrentUser()
        val document = documentFacade.queryById(request.documentId)

        if(!document.isWriter(user)) throw DocumentNotFoundException

        document.updateExperience(request.list.map {
            ExperienceElement(
                title = it.title,
                startDate = it.startDate,
                endDate = it.endDate,
                description = it.description
            )
        })

        documentRepository.save(document)
    }

}