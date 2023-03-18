package com.practice.joblist.config;

import com.practice.joblist.repo.auth.AuthModel;
import com.practice.joblist.repo.auth.AuthRepo;
import com.practice.joblist.repo.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//
//        userDetailsManager.createUser(User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build());
//
//        userDetailsManager.createUser(User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build());
//        return userDetailsManager;
//    }

    @Bean
    public CommandLineRunner iniRegisterUser(AuthRepo authRepo) {
        return args -> {
            authRepo.save(new AuthModel("user", "user2"));
            authRepo.save(new AuthModel("admin", "admin2"));
        };
    }

    @Bean
    public UserDetailsService userService(UserRepository userRepository) {
        return username -> userRepository.findByUsername(username).asUser();
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();
        return http.build();
    }

    @Bean
    public SecurityFilterChain configureSecurity(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests() //
                .requestMatchers("/login").permitAll() //
                .requestMatchers("/", "/search").authenticated() //
                .requestMatchers(HttpMethod.GET, "/api/**")
                .authenticated() //
                .requestMatchers(HttpMethod.POST, "/new-video",
                        "/api/**").hasRole("ADMIN") //
                .anyRequest().denyAll() //
                .and() //
                .formLogin() //
                .and() //
                .httpBasic();
        return http.build();
    }
}
