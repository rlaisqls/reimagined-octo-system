package com.example.demongodb.domain.document.presentation

import com.example.demongodb.domain.document.presentation.dto.request.ChangeVisibilityRequest
import com.example.demongodb.domain.document.presentation.dto.request.CreateDocumentRequest
import com.example.demongodb.domain.document.service.CreateDocumentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/documents")
class DocumentController(
    val createDocumentService: CreateDocumentService
) {
 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("")
    fun createDocument(@ModelAttribute request: CreateDocumentRequest) {
        createDocumentService.execute(request)
    }

    fun changeVisibility(@ModelAttribute request: ChangeVisibilityRequest) {
        changeVisibilityService.execute(request)
    }

}
