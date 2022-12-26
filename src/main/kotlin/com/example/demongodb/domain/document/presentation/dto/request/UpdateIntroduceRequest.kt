package com.example.demongodb.domain.document.presentation.dto.request

import com.example.demongodb.domain.document.domain.element.LinkElement
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import java.util.*
import kotlin.math.min

data class UpdateIntroduceRequest (

    @field:NotNull
    val documentId: UUID,

    @field:NotNull
    @field:Size(min=1, max = 100)
    val title: String,

    @field:NotNull
    val introduce: String,

    @field:NotNull
    val skillSet: List<String>,

    @field:NotNull
    val linkList: List<LinkElement>

)