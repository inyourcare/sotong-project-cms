package com.sotong.projectcms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Zakladni konfiguracni trida Spring Sucurity.
 *
 * @author Samuel Butta
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .anonymous()
                .and()
                .authorizeRequests()
//                .antMatchers(HttpMethod.POST,"/api/**").authenticated() // /api 하위 모든 POST요청
//                .antMatchers(HttpMethod.PUT,"/api/**").authenticated() // /api 하위 모든 PUT요청
//                .antMatchers(HttpMethod.DELETE,"/api/**").authenticated() // /api 하위 모든 DELETE요청
//                .antMatchers("/manage/**").hasAuthority("ROLE_ADMIN") // /manage 하위 모든 요청은 관리자만
//                .antMatchers("/","/login","/profile","/api/**").permitAll()
//                .mvcMatchers("/admin/css/**").permitAll()
//                .mvcMatchers("/admin/js/**").permitAll()
                .mvcMatchers("/admin/**").authenticated();
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }
}
