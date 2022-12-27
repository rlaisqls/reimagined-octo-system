package com.example.demongodb.domain.student.facade

import com.example.demongodb.domain.student.domain.Student
import com.example.demongodb.domain.student.domain.repository.StudentRepository
import com.example.demongodb.domain.student.error.StudentNotFoundException
import com.example.demongodb.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class StudentFacade(
    private val studentRepository: StudentRepository
) {

    fun findByUser(user: User): Student {
        return studentRepository.findByUser(user) ?: throw StudentNotFoundException
    }
}
