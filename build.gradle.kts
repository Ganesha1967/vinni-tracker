// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.diffplug.spotless") version "7.0.4"
}

spotless {
    kotlin {
        target("**/*.kt")
        ktlint("1.6.0")
            .setEditorConfigPath("$projectDir/config/.editorconfig")
            .editorConfigOverride(
                mapOf(
                    "indent_size" to 2,
                    "ktlint_code_style" to "intellij_idea",
                )
            )
            .customRuleSets(
                listOf(
                    "io.nlopez.compose.rules:ktlint:0.4.22"
                )
            )
    }
    format("gradle") {
        target("*.gradle.kts")
        trimTrailingWhitespace()
        endWithNewline()
    }
}
