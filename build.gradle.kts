import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.7.20"
    id("org.jetbrains.compose") version "1.3.0-alpha01-dev849"
}

group = "me.asanzma"
version = "1.5.5"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(compose.desktop.currentOs) //windows_x64)
    implementation("org.jetbrains.skiko:skiko-awt-runtime-windows-x64:0.7.39")
    implementation("org.jetbrains.compose.ui:ui-util-desktop:1.3.0-alpha01-dev849")
    implementation ("org.jdbi:jdbi3-kotlin:3.32.0")
    implementation ("org.jdbi:jdbi3-kotlin-sqlobject:3.32.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "kpropsfinder"
            packageVersion = "1.5.5"
        }
    }
}