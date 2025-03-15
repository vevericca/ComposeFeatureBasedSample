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

rootProject.name = "ComposeFeatureBasedSample"
include(":app")
include(":app-navigation")

include(":core:api")
include(":core:uikit")
include(":core-data")
include(":core-domain")

include(":core-data:products")
include(":core-data:cart")
include(":core-domain:cart")
include(":core-domain:products")
include(":feature:products")
