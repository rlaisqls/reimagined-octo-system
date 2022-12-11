package com.example.demongodb.domain.document.domain

import com.example.demongodb.domain.document.domain.element.*
import com.example.demongodb.domain.document.domain.enums.Visibility
import com.example.demongodb.global.entity.BaseObjectEntity
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection="document")
class Document(

    val version: Int,

    val grade: Int,

    val visibility: Visibility,

    val updatedAt: LocalDateTime,

    val user: UserInfoElement,

    val introduce: IntroduceElement = IntroduceElement(),

    val projectList: MutableList<ProjectElement> = mutableListOf(),

    val experienceList: MutableList<ExperienceElement> = mutableListOf(),

): BaseObjectEntity()