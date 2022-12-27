package com.example.demongodb.domain.user.domain.repository

import com.example.demongodb.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository: CrudRepository<User, UUID> {
    fun findByEmail(email: String): User?
}