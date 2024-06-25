plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.noteappmvvmroom"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.noteappmvvmroom"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
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
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Navigation Components
    implementation ("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.5")

    //Room Database
    implementation ("androidx.room:room-runtime:2.3.0")
    kapt ("androidx.room:room-compiler:2.3.0")
    implementation ("androidx.room:room-ktx:2.3.0")
    androidTestImplementation ("androidx.room:room-testing:2.3.0")


    // Lifecycle components
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.activity:activity-ktx:1.3.1")

    // Kotlin components
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.30")

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")

//    // Architectural Components
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
//
//    // Room
//    implementation("androidx.room:room-runtime:2.6.0")
//    ksp("androidx.room:room-compiler:2.6.0")
//
//    // Kotlin Extensions and Coroutines support for Room
//    implementation("androidx.room:room-ktx:2.6.0")
//
//    // Coroutines
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
//
//    // Coroutine Lifecycle Scopes
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
//
//    // Retrofit
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation("com.squareup.okhttp3:logging-interceptor:4.5.0")
//
//    // Navigation Components
//    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
//    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")
//
//    // Glide
//    implementation("com.github.bumptech.glide:glide:4.12.0")
//    ksp("com.github.bumptech.glide:compiler:4.12.0")
}