package com.example.demongodb.domain.document.presentation.dto.request

import org.jetbrains.annotations.NotNull
import java.time.YearMonth
import java.util.*

data class UpdateProjectRequest (

    @field:NotNull
    val documentId: UUID,

    @field:NotNull
    val list: List<ProjectRequest>

) {
    companion object {
        data class ProjectRequest(

            @field:NotNull
            val name: String,

            @field:NotNull
            val startDate: YearMonth,

            @field:NotNull
            val isDoing: Boolean,

            @field:NotNull
            val endDate: YearMonth?,

            @field:NotNull
            val description: String,

        )
    }
}

