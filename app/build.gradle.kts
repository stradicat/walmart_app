plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // Parcelize
    id("kotlin-parcelize")

    // KotlinX Serialization dependency
    kotlin("plugin.serialization") version "1.9.24"
}

android {
    namespace = "dev.dmayr.shoppingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.dmayr.shoppingapp"
        minSdk = 23
        //noinspection OldTargetApi
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables.useSupportLibrary = true
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Lifecycle extensions
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Fresco image library
    implementation(libs.fresco)
    implementation(libs.animated.webp)
    implementation(libs.webpsupport)
    implementation(libs.imagepipeline.okhttp3)
    compileOnly(libs.infer.annotation)

    // Deserializers:
    // KotlinX Serialization
    implementation(libs.kotlin.serialization)
    // Gson
    implementation(libs.gson)
    implementation(libs.converter.gson)

    // API calls
    // Retrofit
    implementation(libs.retrofit)

}
