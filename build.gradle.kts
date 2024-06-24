plugins {
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
}

group = "com.devtkms"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.postgresql:postgresql:42.7.3")
	implementation("org.jetbrains.kotlin:kotlin-stdlib")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Jar> {
	archiveFileName.set("my-menu-app-sb-0.0.1-SNAPSHOT.jar")
	destinationDirectory.set(layout.buildDirectory.dir("libs"))
	manifest {
		attributes["Main-Class"] = "com.devtkms.mymenuappsb.MyMenuAppSbApplicationKt"
	}
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

tasks.withType<Test> {
	useJUnitPlatform()
}
