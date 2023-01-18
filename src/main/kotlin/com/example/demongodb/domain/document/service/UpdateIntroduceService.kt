package com.example.demongodb.domain.document.service

import com.example.demongodb.domain.document.domain.element.ExperienceElement
import com.example.demongodb.domain.document.domain.element.IntroduceElement
import com.example.demongodb.domain.document.domain.repository.DocumentRepository
import com.example.demongodb.domain.document.error.DocumentNotFoundException
import com.example.demongodb.domain.document.facade.DocumentFacade
import com.example.demongodb.domain.document.presentation.dto.request.UpdateExperienceRequest
import com.example.demongodb.domain.document.presentation.dto.request.UpdateIntroduceRequest
import com.example.demongodb.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UpdateIntroduceService(
    private val documentRepository: DocumentRepository,
    private val documentFacade: DocumentFacade,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(request: UpdateIntroduceRequest) {

        val user = userFacade.getCurrentUser()

        val document = documentFacade.findById(request.documentId)
        if(!document.isWriter(user)) throw DocumentNotFoundException

        document.updateIntroduce(IntroduceElement(
            title = request.title,
            introduce = "",
            skillSet = listOf(),
            linkList = listOf()
        ))

        documentRepository.save(document)
    }

}