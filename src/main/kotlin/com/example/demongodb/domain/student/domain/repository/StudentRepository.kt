package com.example.demongodb.domain.student.domain.repository

import com.example.demongodb.domain.student.domain.Student
import com.example.demongodb.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface StudentRepository: CrudRepository<Student, UUID> {
    fun findByUser(user: User): Student?
}