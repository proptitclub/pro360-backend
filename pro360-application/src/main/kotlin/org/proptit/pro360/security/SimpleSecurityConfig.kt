package org.proptit.pro360.security

import org.proptit.auth.domain.service.UserService
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@EnableWebSecurity
@Configuration
@Profile("!prod")
class SimpleSecurityConfig(userService: UserService) : BaseSecurityConfig(userService) {

    companion object {
        val WHITE_LIST_API = arrayOf(
            "/",
            "/v1/auth/sign-in",
            "/v1/auth/sign-up",
            "/actuator/**"
        )
    }

    override fun whitelistApi() = WHITE_LIST_API
}