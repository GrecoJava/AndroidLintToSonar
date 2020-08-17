// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    `java-gradle-plugin`
    id("org.jetbrains.dokka") version "0.10.1"

    id("org.jetbrains.kotlin.jvm") version Versions.KOTLIN
    kotlin("kapt") version Versions.KOTLIN
}

repositories {
    jcenter()
}

dependencies {
    testImplementation(Depends.JUNIT)
}
// Add a source set for the functional test suite
val functionalTestSourceSet = sourceSets.create("functionalTest") {
    compileClasspath += sourceSets.main.get().output
    runtimeClasspath += sourceSets.main.get().output
}

gradlePlugin.testSourceSets(functionalTestSourceSet)
configurations.getByName("functionalTestImplementation").extendsFrom(configurations.getByName("testImplementation"))

// add a task to run the functional tests
val functionalTest by tasks.creating(Test::class) {
    testClassesDirs = functionalTestSourceSet.output.classesDirs
    classpath = functionalTestSourceSet.runtimeClasspath
}

val check by tasks.getting(Task::class) {
    // run the functional tests as part of `check`
    dependsOn(functionalTest)
}

group = "biz.davidpearson.android"
version = "0.1"

gradlePlugin {
    plugins {
        create("androidLintToSonar") {
            id = "biz.davidpearson.android.androidlinttosonar"
            implementationClass = "biz.davidpearson.android.androidlinttosonar.AndroidLintToSonarPlugin"
        }
    }
}

//tasks {
//    val clean by registering(Delete::class) {
//        delete(buildDir)
//    }
//}

tasks {
    val dokka by getting(org.jetbrains.dokka.gradle.DokkaTask::class) {
        outputFormat = "html"
        outputDirectory = "${buildDir}/dokka"
    }
}