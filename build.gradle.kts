import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"

    kotlin("jvm") version "1.7.21"
    kotlin("plugin.spring") version "1.7.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.7.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.data:spring-data-mongodb:4.0.0")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    //runtimeOnly("mysql:mysql-connector-java")
    runtimeOnly("com.h2database:h2")
    //implementation("org.mongodb:mongo-java-driver:3.12.8")
    implementation("org.mongodb:mongodb-driver-sync:4.8.1")

    implementation("com.querydsl:querydsl-mongodb:5.0.0")
    api("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.0.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
    annotation("org.springframework.data.mongodb.core.mapping.Document")
}

noArg {
    annotation("jakarta.persistence.Entity")
    annotation("org.springframework.data.mongodb.core.mapping.Document")
}

kapt {
    annotationProcessor("org.springframework.data.mongodb.repository.support.MongoAnnotationProcessor")
    annotationProcessor("com.querydsl.apt.jpa.JPAAnnotationProcessor")
}

querydsl {
    springDataMongo = true
    jpa = true
    library = "com.querydsl:querydsl-apt:5.0.0:jakarta"
    querydslSourcesDir = "$projectDir/build/generated"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
    delete{
        "$projectDir/build/generated"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

