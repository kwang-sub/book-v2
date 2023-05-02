package com.example.ssiach2ex1.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
class ProjectConfig {
    @Bean
    fun userDetailsService(): UserDetailsService {
        var userDetailsService = InMemoryUserDetailsManager()
        var user = User.withUsername("kwang")
            .password(passwordEncoder().encode("12345"))
            .authorities("read")
            .build()
        userDetailsService.createUser(user)

        return userDetailsService
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http.httpBasic()
        http.authorizeHttpRequests()
            .anyRequest().permitAll()
        return http.build()
    }
}