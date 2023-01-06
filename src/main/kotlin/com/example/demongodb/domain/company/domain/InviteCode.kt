package com.example.demongodb.domain.company.domain

import jakarta.persistence.Id
import org.hibernate.validator.constraints.UUID
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class InviteCode (

    @Id
    @Indexed
    val companyId: UUID,

    val code: String,

    @TimeToLive
    private val expiration: Long
)