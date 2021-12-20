package org.tinkoff.notifications.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private Environment env;

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager =
                new InMemoryUserDetailsManager(
                        User.builder()
                                .username(env.getProperty("user.login"))
                                .password(
                                        passwordEncoder().encode(env.getProperty("user.password")))
                                .authorities(Role.USER.getGrantedAuthority())
                                .build(),
                        User.builder()
                                .username(env.getProperty("admin.login"))
                                .password(
                                        passwordEncoder().encode(env.getProperty("admin.password")))
                                .authorities(Role.ADMIN.getGrantedAuthority())
                                .build());
        
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**")
                .hasAuthority(Permission.READ.getPermission())
                .antMatchers(HttpMethod.POST, "/**")
                .hasAuthority(Permission.WRITE.getPermission())
                .antMatchers(HttpMethod.PATCH, "/**")
                .hasAuthority(Permission.WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/**")
                .hasAuthority(Permission.WRITE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
