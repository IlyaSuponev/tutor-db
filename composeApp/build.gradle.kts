import io.gitlab.arturbosch.detekt.Detekt
import org.gradle.internal.impldep.bsh.commands.dir
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.dokka.DokkaDefaults.pluginsConfiguration

plugins {
    alias(libs.plugins.jetbrains.compose.multiplatform)
    alias(libs.plugins.jetbrains.compose.hotReload)
    alias(libs.plugins.jetbrains.kotlin.compose.compiler)
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.dokka)
    alias(libs.plugins.linter.detekt)
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }
    }
}

dependencies {
    detektPlugins(libs.linter.detekt.formatting)
}

// build.gradle.kts

dokka {
    moduleName.set("TutorDB")
    dokkaPublications.html {
        suppressInheritedMembers.set(true)
        failOnWarning.set(true)
        outputDirectory.set(file("${rootDir}/docs/dokka"))
    }
    pluginsConfiguration.html {
        footerMessage.set("(c) Suponev Ilya")
    }
}

detekt {
    toolVersion = "1.23.8"
    config.setFrom(file("${rootDir}/detekt/config.yml"))
    source.setFrom(
        "src/jvmMain/kotlin",
        "src/jvmTest/kotlin"
    )
    parallel = true
    autoCorrect = false
    buildUponDefaultConfig = true
}

tasks.withType<Detekt>().configureEach {
    reports {
        xml.required.set(false)
        html.required.set(true)
        sarif.required.set(false)
        md.required.set(true)
    }
}

compose.desktop {
    application {
        mainClass = "suponev.ilya.tutor_db.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "suponev.ilya.tutor_db"
            packageVersion = "1.0.0"
        }
    }
}

tasks.register("staticAnalysis") {
    group = "verification"
    description = "Runs static code analysis (detekt)"
    dependsOn("detekt")
}

tasks.register("runUnitTests") {
    group = "verification"
    description = "Runs the unit tests"
    dependsOn("allTests")
}

tasks.register("fullVerification") {
    group = "verification"
    description = "Runs the complete verification suite (tests + static analysis)"
    dependsOn("runUnitTests", "staticAnalysis")
}
