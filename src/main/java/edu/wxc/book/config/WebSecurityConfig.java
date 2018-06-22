package edu.wxc.book.config;


//import edu.wxc.book.interceptor.UserInterceptor;
import edu.wxc.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    UserService userService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                    .authorizeRequests()
                        .antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()
                        .antMatchers("/secretary/**").hasRole("secretary")
                        .antMatchers("/auditor/**").hasRole("auditor")
                        .and()
                    .formLogin()
                        .loginPage("/login").failureUrl("/login")
                        .and()
                    .exceptionHandling().accessDeniedPage("/403")
                        .and()
                    .logout().logoutSuccessUrl("/login");

    }

}
