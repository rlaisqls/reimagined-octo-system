package com.example.demongodb.global.error

import com.fasterxml.jackson.databind.ObjectMapper
import com.example.demongodb.global.error.dto.ErrorResponse
import com.example.demongodb.global.error.exception.BusinessException
import com.example.demongodb.global.error.exception.ErrorProperty
import org.springframework.web.filter.OncePerRequestFilter
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest

import jakarta.servlet.http.HttpServletResponse

class GlobalExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BusinessException) {

            println("GlobalExceptionFilter.doFilterInternal")
            e.stackTrace.iterator().forEach { println(it) }

            val errorCode: ErrorProperty = e.errorProperty
            response.status = errorCode.status()
            response.contentType = "application/json"
            response.characterEncoding = "UTF-8"

            val errorResponse: ErrorResponse = ErrorResponse.of(errorCode)
            objectMapper.writeValue(response.writer, errorResponse)
        }
    }
}