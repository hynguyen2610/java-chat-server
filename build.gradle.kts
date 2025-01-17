plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.java-websocket:Java-WebSocket:1.5.2") // WebSocket library
    implementation("org.slf4j:slf4j-api:2.0.0-alpha1") // SLF4J logging
    implementation("org.slf4j:slf4j-simple:2.0.0-alpha1") // Simple logging implementation
    testImplementation("junit:junit:4.13.2") // JUnit for testing
}

tasks.test {
    useJUnitPlatform()
}
