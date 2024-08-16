plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // Parcelize
    kotlin("plugin.parcelize")
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
    //noinspection GradleDependency
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Coroutines
    //noinspection GradleDependency
    implementation(libs.kotlinx.coroutines.core)
    //noinspection GradleDependency
    implementation(libs.kotlinx.coroutines.android)

    // Lifecycle extensions
    //noinspection GradleDependency
    implementation(libs.androidx.lifecycle.runtime.ktx)
    //noinspection GradleDependency
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Fresco image library
    implementation(libs.fresco)
    implementation(libs.animated.webp)
    implementation(libs.webpsupport)
    implementation(libs.imagepipeline.okhttp3)
    compileOnly(libs.infer.annotation)

    // Deserializers:
    // Gson
    //noinspection GradleDependency
    implementation(libs.gson)
    implementation(libs.converter.gson)

    // API calls
    // Retrofit
    implementation(libs.retrofit)

}
