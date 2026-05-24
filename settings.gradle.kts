pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PulseTrack"
include(":app")

// Core Modules
include(":core:model")
include(":core:common")
include(":core:database")
include(":core:datastore")
include(":core:network")
include(":core:health")
include(":core:data")
include(":core:domain")
include(":core:ui")

// Feature Modules
include(":feature:dashboard")
include(":feature:workout")
include(":feature:sleep")
include(":feature:analytics")
include(":feature:settings")

// Sync Module
include(":sync")