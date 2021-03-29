
package tn.esprit.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import tn.esprit.spring.service.UserService;

import javax.sql.DataSource;



@EnableWebSecurity

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder  bCryptPasswordEncoder;
    
   
    @Autowired
	protected void configAuthentification(final AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder)
        .usersByUsernameQuery("select username, password, enabled from user where username = ?")
        .authoritiesByUsernameQuery("select username, authority from user where username=?");
        
        
    }

    protected void configure(final HttpSecurity http) throws Exception {
    	 // http builder configurations for authorize requests and form login (see below)
    	// ignored homepage, account area from authentication. and h2 database console
        http.httpBasic()
        .and()
        .authorizeRequests()
           
            .antMatchers("/login").permitAll()
            .antMatchers("/add-user").permitAll()
            .antMatchers("/register/**").permitAll()
            .antMatchers("/message","/messages").permitAll()
            // allow access to all area until security module finish
            .antMatchers("/admin/**", "/customer/**", "/consultant/**").permitAll()
            // checking permission on areas
            .antMatchers("/admin/**").hasAuthority("ADMIN")
            .antMatchers("/customer/**").hasAuthority("CUSTOMER")
            .antMatchers("/consultant/**").hasAuthority("CONSULTANT")
            //.anyRequest().authenticated()
            .and()
            .formLogin()
            //.loginPage("/login")
            //.failureUrl("/login?error=true")
            //.defaultSuccessUrl("/")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .rememberMe()
            .rememberMeParameter("remember-me")
            .rememberMeCookieName("remember-me")
            .tokenValiditySeconds(86400)
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/")
            .and()
            .exceptionHandling()
            .accessDeniedPage("/403")
            .and()
            .csrf()
            .disable();
        http.sessionManagement()
		.maximumSessions(1)
		.maxSessionsPreventsLogin(true)
		.expiredUrl("/login?error=You are already logged in from somewhere");
    }

	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
    @Bean
    public PasswordEncoder  passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
