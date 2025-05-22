apply {
    from("$rootDir/android-library-build.gradle")
}

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.juricaplesa.movies_ui"
}

dependencies {


}