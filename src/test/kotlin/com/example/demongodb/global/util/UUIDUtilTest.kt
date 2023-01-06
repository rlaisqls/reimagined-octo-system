package com.example.demongodb.global.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

internal class UUIDUtilTest {

    private val uuid = UUID.randomUUID()

    @Test
    fun noHyphenUUID() {

        val uuidString = (java.lang.Long.toHexString(uuid.mostSignificantBits)
                + java.lang.Long.toHexString(uuid.leastSignificantBits))

        assertEquals(
            uuid.toString().replace("-", ""),
            uuidString
        )
    }
}