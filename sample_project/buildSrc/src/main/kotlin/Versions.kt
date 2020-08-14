import org.gradle.api.JavaVersion

object Versions {
    const val COMPILE_SDK = 30
    const val MIN_SDK = 21
    const val TARGET_SDK = 30
    const val KOTLIN = "1.3.61"


    const val APP_VERSION_CODE = 1
    const val APP_VERSION_NAME = "1.0"

    const val ANDROID_GRADLE_PLUGIN = "4.2.0-alpha07"
    const val ANDROID_APT = "1.8"
    const val GOOGLE_SERVICES_PLUGIN = "4.3.3"

    /**
     * [Dagger](https://jcenter.bintray.com/com/google/dagger/dagger/)
     */
    const val DAGGER = "2.27"

    val JAVA_VERSION = JavaVersion.VERSION_1_8
}