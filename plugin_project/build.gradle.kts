// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    `java-gradle-plugin`
    id("org.jetbrains.dokka") version "0.10.1"
}

repositories {
    jcenter()
}

dependencies {
    testImplementation(Depends.JUNIT)
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