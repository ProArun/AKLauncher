package com.arun.aklauncher

data class AppObject(
    val packageName: String,
    val appName: String,
    val icon: String,
    val version: String = "1.0",
    val isSystemApp: Boolean = false,
    val isDisabled: Boolean = false
) {
    override fun toString(): String {
        return "AppObject(packageName='$packageName', appName='$appName', icon='$icon', version='$version', isSystemApp=$isSystemApp, isDisabled=$isDisabled)"
    }

    fun isEqual(other: AppObject): Boolean {
        return packageName == other.packageName &&
                appName == other.appName &&
                icon == other.icon &&
                version == other.version &&
                isSystemApp == other.isSystemApp &&
                isDisabled == other.isDisabled
    }
}