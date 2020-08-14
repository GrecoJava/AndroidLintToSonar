object Depends {
    object Kotlin {
        const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    }

    /**
     * [AndroidX](https://developer.android.com/jetpack/androidx/versions/)
     */
    object AndroidX {
        const val ANNOTATION = "androidx.annotation:annotation:1.1.0"
        const val APPCOMPAT = "androidx.appcompat:appcompat:1.1.0"
        const val BROWSER = "androidx.browser:browser:1.2.0"
        const val CONSTRAINT_LAYOUT = "com.android.support.constraint:constraint-layout:1.1.3"
        const val CORE = "androidx.core:core:1.3.0"
        const val CORE_KTX = "androidx.core:core-ktx:1.3.0"
        const val LEGACY_SUPPORT = "androidx.legacy:legacy-support-v4:1.0.0"
        const val MEDIA = "androidx.media:media:1.1.0"
        const val VECTOR_DRAWABLE_ANIMATED = "androidx.vectordrawable:vectordrawable-animated:1.1.0"
        const val WEBKIT = "androidx.webkit:webkit:1.2.0"


        /**
         * [AndroidX Test Releases](https://developer.android.com/jetpack/androidx/releases/test)
         */
        object Test {
            const val CORE = "androidx.test:core:1.2.0"
            const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.2.0"

            /**
             * [Truth - Fluent assertions for Java and Android](https://truth.dev/)
             * [JCenter](https://jcenter.bintray.com/com/google/truth/truth/)
             */
            const val TRUTH = "com.google.truth:truth:1.0.1"

            const val JUNIT ="androidx.test.ext:junit:1.1.1"
        }
    }

    /**
     * [Dagger](https://jcenter.bintray.com/com/google/dagger/dagger/)
     */
    object Dagger {
        const val ANDROID = "com.google.dagger:dagger-android:${Versions.DAGGER}"
        const val COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"
        const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER}"
        const val PROCESSOR = "com.google.dagger:dagger-android-processor:${Versions.DAGGER}"
        const val SUPPORT = "com.google.dagger:dagger-android-support:${Versions.DAGGER}"
    }

    /**
     * [Release Notes](https://developers.google.com/android/guides/releases)
     */
    object PlayServices {
        const val ADS = "com.google.android.gms:play-services-ads:19.1.0"
        const val ADSLITE = "com.google.android.gms:play-services-ads-lite:19.2.0"
        const val BASE = "com.google.android.gms:play-services-base:17.3.0"
        const val BASEMENT = "com.google.android.gms:play-services-basement:17.3.0"
        const val SAFETYNET = "com.google.android.gms:play-services-safetynet:17.0.0"
        const val TASKS = "com.google.android.gms:play-services-tasks:17.1.0"
    }

    /**
     * [Requesting Consent from European Users](https://developers.google.com/admob/android/eu-consent)
     * [Consent SDK](https://github.com/googleads/googleads-consent-sdk-android)
     */
    object Consent {
        const val CONSENT_LIBRARY = "com.google.android.ads.consent:consent-library:1.0.8"
    }

    /**
     * [Firebase](https://firebase.google.com/support/release-notes/android#latest_sdk_versions)
     */
    object Firebase {
        const val ANALYTICS = "com.google.firebase:firebase-analytics:17.2.2"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:1.1.0"
    }

    const val JAVA_INJECT = "javax.inject:javax.inject:1"

    /**
     * [Robolectric](https://jcenter.bintray.com/org/robolectric/robolectric/)
     */
    const val ROBOLECTRIC = "org.robolectric:robolectric:4.3.1"

    /**
     * [JUnit](https://jcenter.bintray.com/junit/junit/)
     */
    const val JUNIT = "junit:junit:4.13"
}