import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.3.61"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

repositories {
    mavenCentral()
    maven {
        setUrl("https://repo.spring.io/milestone")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencyManagement {
    imports {
        mavenBom("io.projectreactor:reactor-bom:Dysprosium-SR2")
    }
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib")
    compile("io.projectreactor:reactor-core")
    compile("io.projectreactor.kotlin:reactor-kotlin-extensions")
    compile("io.reactivex.rxjava2:rxjava:2.0.5")
    testCompile("junit:junit:4.12")
    testCompile("io.projectreactor:reactor-test")
}
