plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Parcelize
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "dev.dmayr.shoppingapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.dmayr.shoppingapp"
        minSdk = 23
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
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

    // Gson
    implementation(libs.gson)

    // API calls
    // Retrofit
    implementation(libs.retrofit)

    // Deserializers:
    implementation(libs.converter.gson)

}
