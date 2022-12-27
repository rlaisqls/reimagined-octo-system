package com.example.demongodb.domain.document.presentation

import com.example.demongodb.domain.document.presentation.dto.request.*
import com.example.demongodb.domain.document.service.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/documents")
class DocumentController(
    private val createDocumentService: CreateDocumentService,

    private val queryMyDocumentListService: QueryMyDocumentListService,
    private val queryDocumentListService: QueryDocumentListService,
    private val queryDocumentInfoService: QueryDocumentInfoService,

    private val changeVisibilityService: ChangeVisibilityService,
    private val updateExperienceService: UpdateExperienceService,
    private val updateIntroduceService: UpdateIntroduceService,
    private val updateProjectService: UpdateProjectService
) {
 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping
    fun createDocument(@RequestBody request: CreateDocumentRequest) {
        createDocumentService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/my")
    fun queryMyDocumentList() {
        queryMyDocumentListService.execute()
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping
    fun queryDocumentList(@ModelAttribute request: QueryDocumentListRequest) {
        queryDocumentListService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/{document-id}")
    fun queryDocumentInfo(@PathVariable("document-id") documentId: UUID) {
        queryDocumentInfoService.execute(documentId)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/visibility")
    fun changeVisibility(@RequestBody request: ChangeVisibilityRequest) {
        changeVisibilityService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/experience")
    fun updateExperience(@RequestBody request: UpdateExperienceRequest) {
        updateExperienceService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/introduce")
    fun updateIntroduce(@RequestBody request: UpdateIntroduceRequest) {
        updateIntroduceService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/project")
    fun updateProject(@RequestBody request: UpdateProjectRequest) {
        updateProjectService.execute(request)
    }

}
