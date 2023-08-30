@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.season.winter.composenoteapp"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.season.winter.composenoteapp"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:design:ui"))
    implementation(project(":core:domain"))
    implementation(project(":feature:main"))

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

kapt {
    correctErrorTypes = true
}