package com.casestudy.config;

import com.casestudy.service.UserDetailServiceImpl;
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailServiceImpl userDetailService;
    @Autowired
    DataSource dataSource;
//    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password(encoder.encode("12345")).roles("USER")
//                .and()
//                .withUser("admin").password(encoder.encode("12345")).roles("ADMIN");
//    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/customers","/employees","/services","/contracts",
                "/login","logout","/contractDetails")
                .permitAll();
        http.authorizeRequests()
                .antMatchers("/customers/create","/customers/edit","/customers/delete",
                        "/employees/create","/employees/edit","/employees/delete",
                        "/services/create","/contracts/create","/contractDetails/create")
                .authenticated();
                http.authorizeRequests().antMatchers("/customers/create","/customers/edit","/customers/delete",
                        "/services/create","/contracts/create","/contractDetails/create").
                        access("hasAnyAuthority('Manager','Employee','Director')");
        http.authorizeRequests().antMatchers("/employees/create","/employees/edit","/employees/delete").
                access("hasAnyAuthority('Manager','Director')");
////                .authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
//                .and()
        http.exceptionHandling().accessDeniedPage("/403");
                http.formLogin()
                        .loginProcessingUrl("/checkLogin")
                        .loginPage("/login")
                        .failureUrl("/login?error=true")
                        .usernameParameter("username")
                        .passwordParameter("password");
                http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
                http.rememberMe().rememberMeParameter("rememberMe").rememberMeCookieName("rememberMeCookie")
                        .tokenValiditySeconds(4*60).tokenRepository(persistentTokenRepository());
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository=new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}
