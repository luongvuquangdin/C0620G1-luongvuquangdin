package com.security.config;

import com.security.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    DataSource dataSource;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/login","/").permitAll();
        http.authorizeRequests().antMatchers().denyAll();
        http.authorizeRequests().antMatchers("/list","/blog/create").access("hasAnyAuthority('ADMIN','ROLE_USER')");
        http.authorizeRequests().antMatchers("/create","/management_category","/create","/edit","/delete").access("hasAuthority('ADMIN)')");
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");


        http.authorizeRequests().and()
                .formLogin().loginProcessingUrl("/checkLogin").loginPage("/login").defaultSuccessUrl("/list").failureUrl("/login?errors=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");


        http.authorizeRequests().and().rememberMe()
                .rememberMeParameter("cookieLogin")
                .rememberMeCookieName("rememberCookie")
                .tokenValiditySeconds(60)
                .tokenRepository(this.persistentTokenRepository());
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository=new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

}
