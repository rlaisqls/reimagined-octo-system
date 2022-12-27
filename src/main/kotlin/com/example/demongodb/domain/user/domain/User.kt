package com.example.demongodb.domain.user.domain


import com.example.demongodb.domain.user.domain.enums.Authority
import com.example.demongodb.global.entity.BaseUUIDEntity
import jakarta.persistence.*


@Table(name = "users")
@Entity
class User(
    name: String,
    password: String,
    email: String,
    authority: Authority
): BaseUUIDEntity() {

    @Column(nullable = false, unique = true, length = 15)
    var name: String = name
        protected set

    @Column(nullable = false, unique = true, length = 60)
    var email: String = email
        protected set

    @Column(nullable = false, length = 60)
    var password: String = password
        protected set

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    var authority: Authority = authority
        protected set

    fun changePassword(encode: String) {
        this.password = password
    }

}