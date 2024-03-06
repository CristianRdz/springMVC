package mx.edu.utez.sda.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user1 = User.withUsername("user1").password(passwordEncoder().encode("uno234")).roles("USER").build();

        UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin1234")).roles("ADMIN").build();

        UserDetails recepcion = User.withUsername("recepcion").password(passwordEncoder().encode("recepcion1234")).roles("RECE").build();
        UserDetails ninio = User.withUsername("ninio").password(passwordEncoder().encode("ninio1234")).roles("NINIO").build();

        UserDetails adulto = User.withUsername("adulto").password(passwordEncoder().encode("adulto1234")).roles("ADULTO").build();
        return new InMemoryUserDetailsManager(user1, admin, recepcion, ninio, adulto);
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests -> authorizeRequests.requestMatchers("/", "/index").permitAll().anyRequest().authenticated()).formLogin(formLogin -> formLogin.loginPage("/login").permitAll()).logout(logout -> logout.permitAll());
        return http.build();

    }
}