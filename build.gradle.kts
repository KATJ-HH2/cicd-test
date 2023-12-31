import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.3"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
	jacoco
}


group = "katj"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

extra["springBootAdminVersion"] = "3.1.5"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("de.codecentric:spring-boot-admin-starter-server")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
	imports {
		mavenBom("de.codecentric:spring-boot-admin-dependencies:${property("springBootAdminVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

// build, bootJar 등의 작업은 test 작업을 포함한다
// test 가 수행될 때마다 jacocoTestReport 작업도 수행하도록 설정하는 내용이다
jacoco {
	toolVersion = "0.8.8" // 버전 명시
}

tasks.test{
	extensions.configure(JacocoTaskExtension::class) {
		destinationFile = file("$buildDir/jacoco/jacoco.exec")
	}
	finalizedBy("jacocoTestReport")

}

