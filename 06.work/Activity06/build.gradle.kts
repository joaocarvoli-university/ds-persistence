plugins {
    kotlin("jvm") version "1.9.0"
}

group = "br.ufc.activity"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // Sqlite with JDBC
    implementation("org.xerial:sqlite-jdbc:3.43.2.0")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
//    implementation("org.slf4j:slf4j-api:2.0.9")
//    // https://mvnrepository.com/artifact/org.slf4j/log4j-over-slf4j
//    implementation("org.slf4j:log4j-over-slf4j:2.0.9")
    implementation("org.slf4j:slf4j-nop:2.0.7")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}