import com.android.build.gradle.ProguardFiles.getDefaultProguardFile

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
    //noinspection UseTomlInstead

    implementation("androidx.core:core-ktx:1.13.1")
    //noinspection GradleDependency
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.activity:activity-ktx:1.9.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Coroutines
    //noinspection GradleDependency
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    //noinspection GradleDependency
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Lifecycle extensions
    //noinspection GradleDependency
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    //noinspection GradleDependency
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    // Fresco image library
    implementation("com.facebook.fresco:fresco:3.1.3")
    implementation("com.facebook.fresco:animated-webp:3.1.3")
    implementation("com.facebook.fresco:webpsupport:3.1.3")
    implementation("com.facebook.fresco:imagepipeline-okhttp3:3.1.3")
    compileOnly("com.facebook.infer.annotation:infer-annotation:0.18.0")

    // Deserializers:
    // Gson
    //noinspection GradleDependency
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // API calls
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")

}
