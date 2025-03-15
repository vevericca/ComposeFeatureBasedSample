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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CleanArchitectureBasedSample"
include(":app")

include(":core:api")
include(":core:uikit")
include(":feature-products")
include(":feature-products:data")
include(":feature-products:domain")
include(":feature-products:ui")
include(":app-navigation")
