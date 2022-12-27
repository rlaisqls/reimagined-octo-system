package com.example.demongodb.domain.document.domain.element

import com.querydsl.core.annotations.QueryEmbeddable
import java.time.YearMonth

class ExperienceElement (

    val title: String,
    val startDate: YearMonth,
    val endDate: YearMonth,
    val description: String

)