// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {

    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin) apply false
    alias(libs.plugins.dagger.hilt) apply false
    //alias(libs.plugins.google.services) apply false
    alias(libs.plugins.google.ksp) apply false
    alias(libs.plugins.jetbrains.kotlin.compose) apply false
}