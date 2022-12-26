package com.example.demongodb.domain.document.domain

import com.example.demongodb.domain.document.domain.element.*
import com.example.demongodb.domain.document.domain.enums.Visibility
import com.example.demongodb.domain.user.domain.User
import com.example.demongodb.global.entity.BaseUUIDEntity
import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@EntityListeners(AuditingEntityListener::class)
@Document(collection="document")
class Document(

    @Column(updatable = false)
    val writer: WriterInfoElement,

    @Column(nullable = false)
    val version: Int,

    visibility: Visibility = Visibility.PRIVATE,

    introduce: IntroduceElement = IntroduceElement(),

    projectList: MutableList<ProjectElement> = mutableListOf(),

    experienceList: MutableList<ExperienceElement> = mutableListOf()

): BaseUUIDEntity() {

    @Column(nullable = false)
    var visibility: Visibility = visibility
        protected set

    @Column(nullable = false)
    var introduce: IntroduceElement = introduce
        protected set

    @Column(nullable = false)
    var projectList: List<ProjectElement> = projectList
        protected set

    @Column(nullable = false)
    var experienceList: List<ExperienceElement> = experienceList
        protected set

    @LastModifiedDate
    @Column(updatable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    @Column(nullable = false)
    fun changeVisibility(visibility: Visibility) {
        this.visibility = visibility
    }

    @Column(nullable = false)
    fun updateExperience(experienceList: List<ExperienceElement>) {
        this.experienceList = experienceList
    }

    fun updateIntroduce(introduce: IntroduceElement) {
        this.introduce = introduce
    }

    fun isWriter(user: User): Boolean {
        return this.writer.id != user.id
    }

    fun updateProject(projectList: List<ProjectElement>) {
        this.projectList = projectList
    }


}