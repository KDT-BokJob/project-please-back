package com.kdt.please.config.auth;

import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                /*.antMatchers("/oauth2/authorization/**","/login/oauth2/code/**").permitAll()
                .antMatchers("/**").hasAnyRole("USER", "RECRUITER")
                .anyRequest().authenticated()*/
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login(oauth2Login -> oauth2Login
                        .loginPage("/login")
                        .redirectionEndpoint(redirectionEndpointConfig -> redirectionEndpointConfig
                                .baseUri("/login/oauth2/code/*"))
                        .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig
                                .userService(customOAuth2UserService))
                        .defaultSuccessUrl("https://project-please-front-git-develop-taemin-jangs-projects.vercel.app/"));
    }
}
