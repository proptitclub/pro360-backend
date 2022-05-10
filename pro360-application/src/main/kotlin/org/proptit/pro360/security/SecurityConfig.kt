package org.proptit.pro360.security

import org.proptit.auth.domain.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter


@EnableWebSecurity
@Configuration
class SecurityConfig(
    val userService: UserService,
) : WebSecurityConfigurerAdapter() {

    companion object {
        val WHITE_LIST_API = arrayOf(
            "/",
            "/v1/auth/sign-in",
            "/v1/auth/sign-up",
            "/actuator/**"
        )
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        super.configure(auth)
        auth!!.userDetailsService(userService)
    }

    override fun configure(http: HttpSecurity) {

        http.httpBasic()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers(*WHITE_LIST_API).permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .cors()
    }

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.allowedOriginPatterns = listOf("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }

}