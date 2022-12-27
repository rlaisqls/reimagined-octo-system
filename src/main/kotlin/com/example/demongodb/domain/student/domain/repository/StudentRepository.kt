package com.example.demongodb.domain.student.domain.repository

import com.example.demongodb.domain.student.domain.Student
import com.example.demongodb.domain.user.domain.User
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface StudentRepository: MongoRepository<Student, UUID> {
    fun findByUser(user: User): Student?
}