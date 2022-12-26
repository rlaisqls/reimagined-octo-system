package com.example.demongodb.domain.student.domain

import com.example.demongodb.domain.document.domain.element.enums.JobTitle
import com.example.demongodb.domain.user.domain.User
import com.example.demongodb.global.entity.BaseUUIDEntity
import org.springframework.data.mongodb.core.mapping.Document
import jakarta.persistence.*
import jakarta.validation.constraints.Size

@Document
class Student(

    user: User,
    grade: Int,
    classNum: Int,
    number: Int

): BaseUUIDEntity() {

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")
    val user: User = user

    @Size(min=1, max=3)
    @Column(columnDefinition = "TINYINT", nullable = false)
    val grade: Int = grade

    @Size(min=1, max=4)
    @Column(columnDefinition = "TINYINT", nullable = false)
    val classNum: Int = classNum

    @Size(min=1, max=20)
    @Column(columnDefinition = "TINYINT", nullable = false)
    val number: Int = number

}