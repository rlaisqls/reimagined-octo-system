package com.example.demongodb.domain.student.domain

import com.example.demongodb.domain.user.domain.User
import com.example.demongodb.global.entity.BaseUUIDEntity
import jakarta.persistence.*
import org.hibernate.validator.constraints.Range

@Entity
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

    @Range(min=1, max=3)
    @Column(columnDefinition = "TINYINT", nullable = false)
    var grade: Int = grade
        protected set

    @field:Range(min=1, max=4)
    @Column(columnDefinition = "TINYINT", nullable = false)
    var classNum: Int = classNum
        protected set

    @field:Range(min=1, max=20)
    @Column(columnDefinition = "TINYINT", nullable = false)
    var number: Int = number
        protected set

    @get:Transient
    val studentID: Int
        get() = grade * 1000 + classNum * 100 + number

    constructor(user: User, studentID: Int) : this(
        user = user,
        grade = (studentID / 1000) % 10, //1000의 자릿수
        classNum = (studentID / 100) % 10, //100의 자릿수
        number = studentID % 100 //10의 자릿수 이하
    )

}