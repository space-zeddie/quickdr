package com.zakharuk.quickdr.config;

/**
 * Created by matvii on 11.04.17.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.zakharuk.quickdr.config")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private Md5PasswordEncoder passwordEncoder;

    private static final String ADMIN_ROLE = "admin";
    private static final String PATIENT_ROLE = "patient";
    private static final String DOCTOR_ROLE = "doctor";

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/css", "/js", "/css/fonts", "/register")
                .permitAll()
                .antMatchers("/", "/index", "/createuser", "/doctors-patients",
                        "/patients-doctors", "/available-doctors",
                        "/booked-doctors", "/patients-one-doctor").permitAll()

                .antMatchers("/register-patient", "/register-doctor",
                         "/delete-doctor", "/add-patient",
                        "/update-doctor", "/create-doctor", "/register-patient", "/delete",
                        "/edit-patient", "/edit-profile", "/edit-doctor", "/my-profile"
                        ).hasAnyAuthority(ADMIN_ROLE, DOCTOR_ROLE)
                .antMatchers("/unattended-patients", "/assign-patient", "/my-patients",
                        "/my-profile").hasAnyAuthority(DOCTOR_ROLE)
                .antMatchers("/my-med-record").hasAnyAuthority(PATIENT_ROLE)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(passwordEncoder).dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, enabled, role from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from users where username=?");
    }
}
