plugins {
    alias(libs.plugins.jetbrains.compose.multiplatform) apply false
    alias(libs.plugins.jetbrains.compose.hotReload) apply false
    alias(libs.plugins.jetbrains.kotlin.compose.compiler) apply false
    alias(libs.plugins.jetbrains.kotlin.multiplatform) apply false
    alias(libs.plugins.jetbrains.dokka) apply false
    alias(libs.plugins.linter.detekt) apply false
}

