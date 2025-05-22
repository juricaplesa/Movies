apply {
    from("$rootDir/android-library-build.gradle")
}

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt)
    alias(libs.plugins.google.devtools.ksp)
}

android {
    namespace = "com.juricaplesa.movies_data"
}

dependencies {
    implementation(project(":movies:movies-domain"))
    implementation(project(":core-data"))

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.coroutines.core)

    implementation(libs.retrofit)
    implementation(libs.serialization.json)
    implementation(libs.retrofit.serialization.converter)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    implementation(libs.paging.runtime)
}