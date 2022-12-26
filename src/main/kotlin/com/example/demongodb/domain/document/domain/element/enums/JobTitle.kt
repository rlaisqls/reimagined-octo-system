package com.example.demongodb.domain.document.domain.element.enums

import java.util.UUID

enum class JobTitle(
    val id: UUID,
    val majorName: String
) {
    BACKEND(UUID(0, 0), "Backend"),
    FRONTEND(UUID(0, 0), "Frontend"),
    AOS(UUID(0, 0), "Aos"),
    IOS(UUID(0, 0), "Iod"),
    CROSS_PLATFORM(UUID(0, 0), "Cross Platform"),
    EMBEDDED(UUID(0, 0), "Embeded"),
    SECURE(UUID(0, 0), "Secure")
}