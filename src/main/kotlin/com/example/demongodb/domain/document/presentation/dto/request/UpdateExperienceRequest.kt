package com.example.demongodb.domain.document.presentation.dto.request

import org.jetbrains.annotations.NotNull
import java.time.YearMonth
import java.util.*

data class UpdateExperienceRequest (

    @field:NotNull
    val documentId: UUID,

    @field:NotNull
    val list: List<ExperienceRequest>

) {
    companion object {
        data class ExperienceRequest (

            @field:NotNull
            val title: String,

            @field:NotNull
            val startDate: YearMonth,

            @field:NotNull
            val endDate: YearMonth,

            @field:NotNull
            val description: String
        )
    }
}

