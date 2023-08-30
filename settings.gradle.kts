pluginManagement {
    repositories {
        google()
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

rootProject.name = "ComposeNoteApp"
include(":app")

include(":core")
include(":core:common")
include(":core:data")
include(":core:design")
include(":core:design:ui")
include(":core:domain")

include(":feature")
include(":feature:main")

