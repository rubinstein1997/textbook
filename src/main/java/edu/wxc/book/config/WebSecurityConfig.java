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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Autowired
    UserService userService;


    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                    .formLogin()
                        .loginPage("/login")
                    .and()
                    .authorizeRequests()
                    .antMatchers("/css/**","/js/**","/fonts/**","/login").permitAll()
                    .antMatchers("/secretary/**").hasRole("secretary")
                    .antMatchers("/auditor/**").hasRole("auditor")
                    .anyRequest()
                    .authenticated()
                    .and()
                    .csrf().disable();
    }



    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
