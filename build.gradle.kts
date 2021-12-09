plugins {
    java
    `maven-publish`
    id("io.freefair.lombok") version "6.3.0"
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

extra["springVersion"] = "2.6.1"
extra["springVersion"] = "2.6.1"

dependencies {
    implementation("org.mapstruct:mapstruct:1.4.2.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")

    implementation("org.springframework.boot:spring-boot-starter-web:${project.extra["springVersion"]}")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:${project.extra["springVersion"]}")

    implementation("org.springframework.boot:spring-boot-devtools:${project.extra["springVersion"]}")
//    implementation("org.projectlombok:lombok:1.18.22")
    implementation("org.mapstruct:mapstruct:1.4.2.Final")
    implementation("org.liquibase:liquibase-core:4.6.2")
    implementation("org.postgresql:postgresql:42.3.1")

    testImplementation("org.springframework.boot:spring-boot-test-autoconfigure:${project.extra["springVersion"]}")
    testImplementation("org.springframework:spring-test:5.3.13")
    testImplementation("com.jayway.jsonpath:json-path:2.6.0")
    testImplementation("com.h2database:h2:2.0.202")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:4.1.0")
}

group = "com"
version = "1.0-SNAPSHOT"
description = "happy-pig"
java.sourceCompatibility = JavaVersion.VERSION_11

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}
