package com.example.demongodb.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.example.demongodb")
@Configuration
class ConfigurationPropertiesConfig