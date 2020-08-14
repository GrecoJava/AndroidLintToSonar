plugins {
    id("com.android.application")
    kotlin("android")
    // kotlin("android.extensions")
    // id("com.google.gms.google-services")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)

    defaultConfig {
        applicationId = "biz.davidpearson.android.androidlinttosonar.sample_project"
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
        versionCode = Versions.APP_VERSION_CODE
        versionName = Versions.APP_VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        encoding = "UTF-8"
        targetCompatibility = Versions.JAVA_VERSION
        sourceCompatibility = Versions.JAVA_VERSION
    }

    (kotlinOptions as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions).apply {
        jvmTarget = Versions.JAVA_VERSION.toString()
    }
}

dependencies {

    androidTestImplementation(Depends.AndroidX.Test.ESPRESSO_CORE)
    androidTestImplementation(Depends.AndroidX.Test.JUNIT)
    implementation(Depends.AndroidX.APPCOMPAT)
    implementation(Depends.AndroidX.CORE_KTX)
    implementation(Depends.Google.MATERIAL)
    implementation(Depends.Kotlin.STDLIB)
    testImplementation(Depends.JUNIT)

}