package com.zakharuk.quickdr.config;

/**
 * Created by matvii on 11.04.17.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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



    private static final String ADMIN_ROLE = "ADMIN";
    private static final String PATIENT_ROLE = "PATIENT";
    private static final String DOCTOR_ROLE = "DOCTOR";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
    /*@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/", "/order/receipt/*", "/pre_logout", "/stats").authenticated()
                .antMatchers("/car/*", "/dept/*", "/worker/*").hasRole(ADMIN_ROLE)
                .antMatchers("/client/*", "/order/create").hasRole(CLIENT_ROLE)
                .antMatchers("/staff/dispatcher/*").hasRole(DISPATCHER_ROLE)
                .antMatchers("/staff/driver/*").hasRole(DRIVER_ROLE)
                .antMatchers("/staff/profile").hasAnyRole(DISPATCHER_ROLE, DRIVER_ROLE)
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("lgn")
                .passwordParameter("pswd")
                .defaultSuccessUrl("/", false)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .rememberMe()
                .key("rem-me-key")
                .rememberMeParameter("ttx-remember-me")
                .rememberMeCookieName("ttx-remember-me")
                .tokenValiditySeconds(86400)
                .and()
                .sessionManagement()
                .maximumSessions(1).expiredUrl("/pre_logout")
                .and().and()
                .csrf().disable();
    }*/

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(passwordEncoder).dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
    }
}
