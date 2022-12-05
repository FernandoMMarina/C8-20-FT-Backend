package com.c820ftjavareact.ecommerce.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;


    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";

    @CrossOrigin(origins = "http://localhost:3000")
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {

        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        return http
                .csrf().disable().cors(cors -> cors.disable())
                .authorizeRequests()
                //Products
                .antMatchers("/product/**").permitAll()
                .antMatchers(HttpMethod.GET,"/product/products").permitAll()
                .antMatchers(HttpMethod.GET,"/product/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/product/").permitAll()
                .antMatchers(HttpMethod.DELETE,"/product/{id}").permitAll()
                .antMatchers(HttpMethod.PUT,"/product/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/productC/upload").permitAll()
                //Clients
                .antMatchers(HttpMethod.GET,"/client/clients").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET,"/client/{id}").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST,"/client/").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.PUT,"/client/{id}").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.DELETE,"/client/{id}").hasRole(ROLE_ADMIN)


                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    };

    /*
    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles()
                .build());
        return manager;
    }*/

    @Bean
    AuthenticationManager authManager(HttpSecurity http ) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
