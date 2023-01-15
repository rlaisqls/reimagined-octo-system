package com.example.demongodb.global.util

import java.util.*

object UUIDUtil {

    fun getNoneHyphenUUID(): String {

        val uuid = UUID.randomUUID()
        return (java.lang.Long.toHexString(uuid.mostSignificantBits)
                + java.lang.Long.toHexString(uuid.leastSignificantBits))
    }

}