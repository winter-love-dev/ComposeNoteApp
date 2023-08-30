@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.season.winter.feature.main"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtensionVersion.get()
    }

}

dependencies {

    implementation(project(":core:design:ui"))
    implementation(project(":core:domain"))

    implementation(libs.bundles.default)
    implementation(libs.bundles.default.components)
    implementation(libs.bundles.compose)
    implementation(platform(libs.compose.bom))

    testImplementation(libs.bundles.test)

    androidTestImplementation(libs.bundles.android.test)
    androidTestImplementation(platform(libs.compose.bom))

    debugImplementation(libs.bundles.debug)

    // hilt
    implementation(libs.bundles.hilt)
    kapt(libs.bundles.hilt.compiler.kapt)

    // room
    ksp(libs.bundles.room.compiler.ksp)
    annotationProcessor(libs.bundles.room.compiler.annotationProcessor)
    testImplementation(libs.bundles.room.testing.testImplementation)
    implementation(libs.bundles.room)
}