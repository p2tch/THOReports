plugins {
    kotlin("jvm") version "2.3.10"
    id("com.gradleup.shadow") version "9.3.2"
}

allprojects {
    group = "xyz.thehiddenproject.thoreports"
    version = "0.0.1"
}

repositories {
    mavenCentral()
}

subprojects {
    apply {
        plugin("kotlin")
    }

    repositories {
        mavenCentral()
        maven("https://repo.okaeri.cloud/releases")
        maven {
            name = "papermc"
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
    }

    dependencies {
        implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:6.1.0-beta.1")
    }

    kotlin {
        jvmToolchain(21)
    }
}