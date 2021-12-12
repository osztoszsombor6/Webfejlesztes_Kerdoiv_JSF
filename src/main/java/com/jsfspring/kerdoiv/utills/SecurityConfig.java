package com.jsfspring.kerdoiv.utills;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http.authorizeRequests()
                    .antMatchers("/javax.faces.resource/**").permitAll()
                    .antMatchers("/index.jsf").permitAll()
                    .antMatchers("/error403.jsf").permitAll()
                    .antMatchers("/kerdoivkitolt.jsf").permitAll()
                    .antMatchers("/kerdoivszerkeszt.jsf").hasRole("ADMIN")
                    .antMatchers("/kitoltes_lista.jsf").hasAnyRole("ADMIN","USER");


            http.formLogin().loginPage("/login.jsf").permitAll().defaultSuccessUrl("/index.jsf")
                            .failureForwardUrl("/login.jsf?error=true");

            http.logout().logoutSuccessUrl("/login.jsf");

            http.csrf().disable();

            http.exceptionHandling().accessDeniedPage("/error403.jsf");
    }



    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery("select username, role from users where username=?")
        ;
    }

}
