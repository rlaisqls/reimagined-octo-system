package com.example.demongodb.domain.document.presentation.dto.response

import com.example.demongodb.domain.document.domain.element.ExperienceElement
import com.example.demongodb.domain.document.domain.element.IntroduceElement
import com.example.demongodb.domain.document.domain.element.ProjectElement
import com.example.demongodb.domain.document.domain.element.WriterInfoElement
import java.time.LocalDateTime

data class QueryDocumentInfoResponse (

    val writer: WriterInfoElement,

    val updatedAt: LocalDateTime,

    val introduce: IntroduceElement,

    val projectList: List<ProjectElement>,

    val experienceList: List<ExperienceElement>

)