package com.example.demongodb.domain.document.presentation

import com.example.demongodb.domain.document.presentation.dto.request.*
import com.example.demongodb.domain.document.presentation.dto.response.CreateDocumentResponse
import com.example.demongodb.domain.document.presentation.dto.response.QueryDocumentInfoResponse
import com.example.demongodb.domain.document.presentation.dto.response.QueryDocumentListResponse
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
 
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createDocument(@RequestBody request: CreateDocumentRequest): CreateDocumentResponse {
        return createDocumentService.execute(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/my")
    fun queryMyDocumentList(): QueryDocumentListResponse {
        return queryMyDocumentListService.execute()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun queryDocumentList(@ModelAttribute request: QueryDocumentListRequest): QueryDocumentListResponse {
        return queryDocumentListService.execute(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{document-id}")
    fun queryDocumentInfo(@PathVariable("document-id") documentId: UUID): QueryDocumentInfoResponse {
       return queryDocumentInfoService.execute(documentId)
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
