package com.example.demongodb.domain.document.domain.element

import com.example.demongodb.domain.document.error.InvalidProjectException
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.YearMonth

class ProjectElement (

    val name: String,
    val startDate: YearMonth,
    val isDoing: Boolean,
    val endDate: YearMonth?,
    val description: String,

) {
    init {
        if(!isDoing && endDate == null) {
            throw InvalidProjectException
        }
    }
}

