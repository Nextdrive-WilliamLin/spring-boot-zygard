import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.2"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.jpa") version "1.7.22"
	kotlin("kapt") version "1.7.22"
}

group = "will.demo"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven("http://oanexus.nextdrive.io/repository/maven-nxd") {
		credentials {
			username = "nxdpub"
			password = "qA-sYssJBsmp*x2"
		}
		isAllowInsecureProtocol = true
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.hibernate.orm:hibernate-envers")
	implementation("org.hibernate.orm:hibernate-spatial")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("zygarde:zygarde-jpa:3.0.2")
	kapt("zygarde:zygarde-jpa-codegen:3.0.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

kapt {
	arguments {
		arg("zygarde.codegen.base.package", "will.demo")
		arg("zygarde.codegen.dao.package", "data.dao")
		arg("zygarde.codegen.dao.inherit", "zygarde.data.jpa.dao.ZygardeEnhancedDao")
	}
}