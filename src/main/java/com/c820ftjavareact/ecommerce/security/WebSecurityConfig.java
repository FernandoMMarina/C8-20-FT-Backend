package com.c820ftjavareact.ecommerce.security;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";

    @CrossOrigin(origins = "https://c8-20-ft-javareact-5a91pzs32-villanos.vercel.app/")
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        return http
                .csrf().disable()
                .cors().configurationSource(corsConfigurationSource())
                .and()
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
                .antMatchers(HttpMethod.POST,"/client/").permitAll()
                .antMatchers(HttpMethod.PUT,"/client/{id}").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.DELETE,"/client/{id}").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST,"/login").permitAll()

                .anyRequest()
                .authenticated()
                .and()
                .formLogin(loginConfigurer -> {
                    loginConfigurer
                            .loginProcessingUrl("/login")
                            .loginPage("/").permitAll()
                            .successForwardUrl("/")
                            .defaultSuccessUrl("/")
                            .failureUrl("/?error");
                })
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    };
    @Bean
    @CrossOrigin(origins = "https://c8-20-ft-javareact-5a91pzs32-villanos.vercel.app/")

    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://c8-20-ft-javareact-5a91pzs32-villanos.vercel.app/","https://c8-20-ft-javareact-dgfyw77kn-villanos.vercel.app/",
                "https://c8-20-ft-javareact-k53zjt3xg-villanos.vercel.app/","https://c8-20-ft-javareact-k53zjt3xg-villanos.vercel.app/","https://c8-20-ft-javareact-k53zjt3xg-villanos.vercel.app/login","http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization","Access-Control-Allow-Origin","*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

/*
    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles(ROLE_ADMIN)
                .build());
        return manager;
    }
*/
    @Bean
    @CrossOrigin(origins = "https://c8-20-ft-javareact-5a91pzs32-villanos.vercel.app/")
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



}
