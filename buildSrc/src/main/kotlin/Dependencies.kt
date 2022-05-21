object Version {
    const val KotlinLogging = "2.1.20"
    const val SpringBootAdminServer = "2.5.1"
    const val SpringBootAdminClient = "2.5.1"
}

object Dependency {
    const val KotlinLogging = "io.github.microutils:kotlin-logging-jvm:${Version.KotlinLogging}"
    const val SpringBootAdminServer = "de.codecentric:spring-boot-admin-starter-server:${Version.SpringBootAdminServer}"
    const val SpringBootAdminClient = "de.codecentric:spring-boot-admin-starter-client:${Version.SpringBootAdminClient}"
}