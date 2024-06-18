pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Required in naver map
        jcenter()
        maven("https://repository.map.naver.com/archive/maven/")
        maven("https://jitpack.io/")
    }
}

rootProject.name = "UCMC"
include(":app", ":data", ":domain", ":presentation")
