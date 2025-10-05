plugins {
    java
    checkstyle
    pmd
    id("com.diffplug.spotless") version "6.25.0"
}

group = "me.learn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}

dependencies {
    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")

    // Test dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("com.github.npathai:hamcrest-optional:2.0.0")
}

tasks.test {
    useJUnitPlatform()
}

checkstyle {
    toolVersion = "11.1.0"
    configFile = file("config/checkstyle/google_checks.xml")
    isIgnoreFailures = false
    maxWarnings = 0
    configProperties = mapOf(
        "org.checkstyle.google.suppressionfilter.config" to file("config/checkstyle/suppressions.xml").absolutePath
    )
}

tasks.withType<Checkstyle> {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
    // Only include LinkedList and ListNode files
    include("**/LinkedList.java", "**/LinkedListTest.java", "**/ListNode.java")
}

pmd {
    // Use PMD 7.x latest as requested
    toolVersion = "7.12.0"
    isConsoleOutput = true
    isIgnoreFailures = false
    ruleSetFiles = files("config/pmd/ruleset.xml")
    ruleSets = listOf()
}

tasks.withType<Pmd> {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
    // Only include LinkedList and ListNode files
    include("**/LinkedList.java", "**/LinkedListTest.java", "**/ListNode.java")
}

spotless {
    java {
        target("src/**/*.java")
        googleJavaFormat()
        importOrder()
        removeUnusedImports()
        trimTrailingWhitespace()
        endWithNewline()
    }
}
