apply {
    from("$rootDir/android-library-build.gradle")
}

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.juricaplesa.core_data"

    defaultConfig {
        buildConfigField(
            "String",
            "ACCESS_TOKEN",
            "${rootProject.extra["ACCESS_TOKEN"]}"
        )

        buildConfigField(
            "String",
            "API_KEY",
            "${rootProject.extra["API_KEY"]}"
        )
    }
}