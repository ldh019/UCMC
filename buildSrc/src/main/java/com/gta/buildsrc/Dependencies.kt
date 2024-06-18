import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    object Versions {
        const val ANDROID = "7.3.0"

        // AndroidX
        const val APP_COMPAT = "1.5.1"
        const val MATERIAL = "1.7.0"
        const val CONSTRAINT_LAYOUT = "2.1.4"
        const val STARTUP = "1.2.0-alpha01"
        const val SPLASH = "1.0.0"
        const val DATASTORE = "1.0.0"
        const val SWIPE_REFRESH_LAYOUT = "1.1.0"

        // KTX
        const val KOTLIN = "1.9.0"
        const val CORE = "1.9.0"
        const val COROUTINE = "1.6.4"

        // Google Play Service
        const val PLAY_SERVICES = "4.3.8"
        const val PLAY_SERVICES_AUTH = "20.3.0"
        const val PLAY_SERVICES_LOCATION = "21.3.0"

        // Jetpack
        const val LIFECYCLE = "2.5.1"
        const val NAVIGATION = "2.5.3"
        const val HILT = "2.48"
        const val VIEW_PAGER = "1.0.0"
        const val ROOM = "2.4.3"
        const val PAGING = "3.1.1"

        const val INJECT = "1"

        // Custom
        const val TIMBER = "5.0.1"
        const val GLIDE = "4.14.2"
        const val NAVER_MAPS = "3.18.0"
        const val STREAM_CHAT = "5.11.0"
        const val GOOGLE_SIGNIN_BUTTON = "1.1.0"

        // Firebase
        const val FIREBASE = "31.1.0"
        const val CRASHLYTICS = "2.9.2"

        // REST API
        const val RETROFIT = "2.9.0"
        const val LOGGING_INTERCEPTER = "5.0.0-alpha.6"

        // Test
        const val JUNIT5_PLUGIN = "1.8.2.1"
        const val JUNIT5 = "5.8.2"
        const val ESPRESSO_CORE = "3.5.0"
        const val MOCKITO = "4.9.0"
        const val MOCKITO_KOTLIN = "4.1.0"
        const val JACOCO = "0.8.8"

        // Github open Library
        const val INDICATOR = "4.3"
        const val LOTTIE = "5.0.1"
    }

    object Classpaths {
        const val GOOGLE_SERVICES = "com.google.gms:google-services:${Versions.PLAY_SERVICES}"
        const val NAVIGATION =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}"
        const val HILT = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
        const val CRASHLYTICS =
            "com.google.firebase:firebase-crashlytics-gradle:${Versions.CRASHLYTICS}"
        const val JUNIT5 =
            "de.mannodermaus.gradle.plugins:android-junit5:${Versions.JUNIT5_PLUGIN}"
        const val JACOCO =
            "org.jacoco:org.jacoco.core:${Versions.JACOCO}"
    }

    object Libraries {
        object AndroidX {
            const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
            const val CORE = "androidx.core:core-ktx:${Versions.CORE}"
            const val STARTUP = "androidx.startup:startup-runtime:${Versions.STARTUP}"
            const val SPLASH = "androidx.core:core-splashscreen:${Versions.SPLASH}"
            const val DATASTORE = "androidx.datastore:datastore-preferences:${Versions.DATASTORE}"
            const val SWIPE_REFRESH_LAYOUT = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT}"

            fun getAll(): ArrayList<String> {
                return arrayListOf(APP_COMPAT, CORE)
            }
        }

        object AndroidUI {
            const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
            const val CONSTRAINT_LAYOUT =
                "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"

            fun getAll(): ArrayList<String> {
                return arrayListOf(MATERIAL, CONSTRAINT_LAYOUT)
            }
        }

        object PlayService {
            const val AUTH =
                "com.google.android.gms:play-services-auth:${Versions.PLAY_SERVICES_AUTH}"
            const val LOCATION =
                "com.google.android.gms:play-services-location:${Versions.PLAY_SERVICES_LOCATION}"

            fun getAll(): ArrayList<String> {
                return arrayListOf(AUTH, LOCATION)
            }
        }

        object Firebase {
            const val PLATFORM = "com.google.firebase:firebase-bom:${Versions.FIREBASE}"
            const val AUTH = "com.google.firebase:firebase-auth-ktx"
            const val ANALYTICS = "com.google.firebase:firebase-analytics-ktx"
            const val CRASHLYTICS = "com.google.firebase:firebase-crashlytics-ktx"
            const val DATABASE = "com.google.firebase:firebase-database"
            const val STORAGE = "com.google.firebase:firebase-storage-ktx"
            const val MESSAGING = "com.google.firebase:firebase-messaging-ktx"
            const val FIRESTORE = "com.google.firebase:firebase-firestore-ktx"
            const val GOOGLE_SIGNIN_BUTTON =
                "com.shobhitpuri.custombuttons:google-signin:${Versions.GOOGLE_SIGNIN_BUTTON}"

            fun getDataAll(): ArrayList<String> {
                return arrayListOf(ANALYTICS, CRASHLYTICS, DATABASE, STORAGE, FIRESTORE)
            }

            fun getPresentationAll(): ArrayList<String> {
                return arrayListOf(AUTH, GOOGLE_SIGNIN_BUTTON, MESSAGING)
            }
        }

        object Lifecycle {
            const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
            const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
            const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"

            fun getAll(): ArrayList<String> {
                return arrayListOf(VIEWMODEL, LIFECYCLE, LIVEDATA)
            }
        }

        object Navigation {
            const val FRAGMENT =
                "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
            const val UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"

            fun getAll(): ArrayList<String> {
                return arrayListOf(FRAGMENT, UI)
            }
        }

        object Coroutine {
            const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE}"
            const val ANDROID =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE}"

            fun getAll(): ArrayList<String> {
                return arrayListOf(CORE, ANDROID)
            }
        }

        object Glide {
            const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
            const val COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
        }

        object Hilt {
            const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
            const val COMPILER = "com.google.dagger:hilt-compiler:${Versions.HILT}"
        }

        object Room {
            const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
            const val KTX = "androidx.room:room-ktx:${Versions.ROOM}"
            const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"

            fun getAll(): ArrayList<String> {
                return arrayListOf(RUNTIME, KTX)
            }
        }

        object Retrofit {
            const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
            const val CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
            const val GSON = "com.google.code.gson:gson:${Versions.RETROFIT}"

            fun getAll(): ArrayList<String> {
                return arrayListOf(RETROFIT, CONVERTER, GSON)
            }
        }

        object Paging {
            const val PAGING = "androidx.paging:paging-runtime:${Versions.PAGING}"
            const val KTX = "androidx.paging:paging-common:${Versions.PAGING}"
        }

        const val INDICATOR = "com.tbuonomo:dotsindicator:${Versions.INDICATOR}"
        const val LOTTIE = "com.airbnb.android:lottie:${Versions.LOTTIE}"

        const val LOGGING_INTERCEPTER =
            "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING_INTERCEPTER}"

        const val VIEW_PAGER_2 = "androidx.viewpager2:viewpager2:${Versions.VIEW_PAGER}"

        const val NAVER_MAP = "com.naver.maps:map-sdk:${Versions.NAVER_MAPS}"

        const val STREAM_CHAT =
            "io.getstream:stream-chat-android-ui-components:${Versions.STREAM_CHAT}"

        const val STREAM_PUSH_PROVIDER =
            "io.getstream:stream-chat-android-pushprovider-firebase:${Versions.STREAM_CHAT}"

        const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"

        const val INJECT = "javax.inject:javax.inject:${Versions.INJECT}"

        object Test {
            const val JUNIT5_API = "org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT5}"
            const val JUNIT5_ENGINE = "org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT5}"
            const val MOCKITO = "org.mockito:mockito-inline:${Versions.MOCKITO}"
            const val MOCKITO_KOTLIN = "org.mockito.kotlin:mockito-kotlin:${Versions.MOCKITO_KOTLIN}"
            const val MOCKITO_JUPITER = "org.mockito:mockito-junit-jupiter:${Versions.MOCKITO}"
        }

        object AndroidTest {
            const val ESPRESSO_CORE =
                "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
        }

        val appLibraries = arrayListOf<String>().apply {
            addAll(AndroidX.getAll())
            add(AndroidX.STARTUP)
            add(TIMBER)
            add(Hilt.HILT)
        }

        val appKaptLibraries = arrayListOf<String>().apply {
            add(Hilt.COMPILER)
        }

        val dataLibraries = arrayListOf<String>().apply {
            addAll(AndroidX.getAll())
            addAll(Firebase.getDataAll())
            add(Hilt.HILT)
            addAll(Coroutine.getAll())
            addAll(Room.getAll())
            add(TIMBER)
            addAll(Retrofit.getAll())
            add(AndroidX.DATASTORE)
            add(LOGGING_INTERCEPTER)
            add(Paging.PAGING)
        }

        val dataTestLibraries = arrayListOf<String>().apply {
            add(Test.MOCKITO)
            add(Test.MOCKITO_KOTLIN)
            add(Test.MOCKITO_JUPITER)
            add(Test.JUNIT5_API)
            add(Test.JUNIT5_ENGINE)
        }

        val dataKaptLibraries = arrayListOf<String>().apply {
            add(Hilt.COMPILER)
            add(Room.COMPILER)
        }

        val domainLibraries = arrayListOf<String>().apply {
            add(Coroutine.CORE)
            add(INJECT)
            add(Paging.KTX)
        }

        val presentationLibraries = arrayListOf<String>().apply {
            addAll(AndroidX.getAll())
            addAll(AndroidUI.getAll())
            addAll(Firebase.getPresentationAll())
            addAll(PlayService.getAll())
            addAll(Lifecycle.getAll())
            addAll(Navigation.getAll())
            addAll(Coroutine.getAll())
            add(Glide.GLIDE)
            add(VIEW_PAGER_2)
            add(Hilt.HILT)
            add(NAVER_MAP)
            add(STREAM_CHAT)
            add(STREAM_PUSH_PROVIDER)
            add(TIMBER)
            add(AndroidX.SPLASH)
            add(INDICATOR)
            add(LOTTIE)
            add(Paging.PAGING)
            add(AndroidX.SWIPE_REFRESH_LAYOUT)
        }

        val presentationKaptLibraries = arrayListOf<String>().apply {
            add(Hilt.COMPILER)
            add(Glide.COMPILER)
        }
    }
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.testRuntimeOnly(list: List<String>) {
    list.forEach { dependency ->
        add("testRuntimeOnly", dependency)
    }
}

fun DependencyHandler.classpath(list: List<String>) {
    list.forEach { dependency ->
        add("classpath", dependency)
    }
}
