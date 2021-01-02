package com.yalco.estore.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class EstoreSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().permitAll();
        http.cors(c -> {
            CorsConfigurationSource cs = r -> {
                CorsConfiguration cc = new CorsConfiguration();
                cc.setAllowedOrigins(Arrays.asList("*"));
                cc.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","PATCH"));
                return cc;
            };
            c.configurationSource(cs);
        });
    }
}
