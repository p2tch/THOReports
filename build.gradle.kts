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
    repositories {
        mavenCentral()
    }

    dependencies {

    }

    apply {
        plugin("kotlin")
    }

    kotlin {
        jvmToolchain(21)
    }
}