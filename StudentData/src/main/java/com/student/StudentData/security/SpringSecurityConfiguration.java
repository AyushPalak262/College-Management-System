package com.student.StudentData.security;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserManagerDetail() {
        UserDetails userDetails1 = createNewUser("Ayush262", "Ayush@123");
        UserDetails userDetails2 = createNewUser("Ayush", "siwan");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        
        return User.builder()
                   .passwordEncoder(passwordEncoder)
                   .username(username)
                   .password(password)
                   .roles("USER", "ADMIN")
                   .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/form").hasRole("ADMIN")  // Only allow users with ADMIN role to access /form
                .anyRequest().permitAll()  // Allow all other requests without authentication
            )
            .formLogin(withDefaults())  // Default login form
            .logout(logout -> logout
                    .logoutSuccessUrl("/")  // Redirect to home page after logout
                    .permitAll()  // Allow everyone to access the logout functionality
                )
            .csrf(csrf -> csrf.disable())  // Disable CSRF protection (if necessary)
            .headers(headers -> headers
                .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)  // Disable frame options if needed
            );

        return http.build();
    }

}
