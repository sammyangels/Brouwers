package be.vdab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CreateSecurityFilter extends WebSecurityConfigurerAdapter {
    private static final String ADMINISTRATOR = "administrator";
    private static final String USER = "user";
    @Autowired
    private DataSource dataSource;
    @Override @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").and().logout()
                .logoutSuccessUrl("/").and().authorizeRequests()
                .antMatchers("/brouwers/toevoegen").hasAuthority(ADMINISTRATOR)
                .antMatchers("/brouwers", "/brouwers/beginnaam", "/brouwers/opalfabet")
                .hasAnyAuthority(ADMINISTRATOR, USER);
        http.httpBasic();
    }
}
