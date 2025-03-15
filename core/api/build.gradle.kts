plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlinx.serialization)
    kotlin("kapt")
}

android {
    namespace = "com.vevericca.network"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        android.buildFeatures.buildConfig = true

        buildConfigField("String", "BASE_URL", "\"https://fakestoreapi.com/\"");
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.coroutines.core)
    implementation(libs.serialization.json)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.network.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit.adapters.result)
    implementation(libs.androidx.annotation)

    testImplementation(libs.junit)

}