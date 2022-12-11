package com.example.demongodb.domain.document.domain.element

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
            throw IllegalArgumentException("") // TODO: 에러
        }
    }
}

