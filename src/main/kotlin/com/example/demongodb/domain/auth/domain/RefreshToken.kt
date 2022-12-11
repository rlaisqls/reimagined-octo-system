package com.example.demongodb.domain.auth.domain

import com.example.demongodb.domain.user.domain.enums.Authority
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshToken(
    email: String,
    authority: Authority,
    token: String,
    expiration: Long
) {

    @Id
    var email: String = email
        protected set

    var authority: Authority = authority
        protected set

    @Indexed
    var token: String = token
        protected set

    @TimeToLive
    var expiration: Long = expiration
        protected set

    fun updateToken(token: String, expiration: Long) {
        this.token = token
        this.expiration = expiration
    }
}