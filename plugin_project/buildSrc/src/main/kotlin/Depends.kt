object Depends {
    object Kotlin {
        const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    }

    /**
     * [AndroidX](https://developer.android.com/jetpack/androidx/versions/)
     */
    object AndroidX {
        const val APPCOMPAT = "androidx.appcompat:appcompat:1.1.0"
        const val CORE_KTX = "androidx.core:core-ktx:1.3.0"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:1.1.3"

        object Lifecycle {
            const val LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
            const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
        }

        object Navigation {
            const val FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:2.3.0"
            const val FRAGMENT = "androidx.navigation:navigation-fragment:2.3.0"
            const val UI_KTX = "androidx.navigation:navigation-ui-ktx:2.3.0"
            const val UI = "androidx.navigation:navigation-ui:2.3.0"
        }

        /**
         * [AndroidX Test Releases](https://developer.android.com/jetpack/androidx/releases/test)
         */
        object Test {
            const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.2.0"
            const val EXT_JUNIT = "androidx.test.ext:junit:1.1.1"
        }
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:1.1.0"
    }

    /**
     * [JUnit](https://jcenter.bintray.com/junit/junit/)
     */
    const val JUNIT = "junit:junit:4.13"
}