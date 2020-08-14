// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version Versions.ANDROID_GRADLE_PLUGIN apply false
    kotlin("android") version Versions.KOTLIN apply false
    kotlin("android.extensions") version Versions.KOTLIN apply false
    id("com.google.gms.google-services") version Versions.GOOGLE_SERVICES_PLUGIN apply false
    id("com.github.ben-manes.versions") version "0.27.0"
    id("org.jetbrains.dokka") version "0.10.1"

    /**
     * https://dev.to/autonomousapps/the-proper-care-and-feeding-of-your-gradle-build-d8g
     */
    id("com.autonomousapps.dependency-analysis") version "0.52.0"
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}

tasks {
    val dokka by getting(org.jetbrains.dokka.gradle.DokkaTask::class) {

        outputFormat = "html"
        outputDirectory = "${buildDir}/dokka"

        subProjects = listOf("buildSrc", "app")
    }
}