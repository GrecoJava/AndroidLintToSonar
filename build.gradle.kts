// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "4.0.0" apply false
    // id("com.android.application") version Versions.ANDROID_GRADLE_PLUGIN apply false
    kotlin("android") version "1.3.72" apply false
    // kotlin("android") version Versions.KOTLIN apply false
    kotlin("android.extensions") version "1.3.72" apply false
    // kotlin("android.extensions") version Versions.KOTLIN apply false
    id("org.jetbrains.dokka") version "0.10.1"
}

allprojects {
    repositories {
        google()
        jcenter()
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

        subProjects = listOf("app")
        // subProjects = listOf("buildSrc", "app")
        //subProjects = listOf("buildSrc")
    }
}