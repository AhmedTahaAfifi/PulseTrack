plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.pulsetrack.core.health"
    compileSdk = 35

    defaultConfig {
        minSdk = 26
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-XXLanguage:+PropertyParamAnnotationDefaultTargetMode")
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.health.connect)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}
