import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.7.20"
    id("org.jetbrains.compose") version "1.3.0-alpha01-dev849"
    kotlin("plugin.serialization") version "1.7.20"
}

group = "me.asanzma"
version = "1.6.2"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

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
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    implementation("com.oracle.database.jdbc:ojdbc11:21.1.0.0")
    implementation("org.slf4j:slf4j-log4j12:1.7.36")
    implementation("org.jetbrains.compose.material3:material3-desktop:1.2.1")

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
            packageVersion = "1.6.2"
        }
    }
}