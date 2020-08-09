package com.uxsino.delenceproject.config;

import com.uxsino.delenceproject.service.UserInfoService;
import com.uxsino.delenceproject.service.impl.UserInfoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description SpringSecurity配置类
 * @author Yinpengfei
 * @Date 2020/8/8
 **/
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页任何人都可以访问
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/test1/**").hasAnyRole("user1","admin")
                .antMatchers("/test2/**").hasAnyRole("user2","admin")
                .antMatchers("/test3/**").hasAnyRole("user3","admin");
        //没有权限，访问login页面
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");
        //开启注销
        http.logout().logoutSuccessUrl("/");
        //关闭跨域请求
        http.csrf().disable();
        //http.rememberMe().rememberMeParameter("");
    }
    @Bean
    UserInfoServiceImpl userInfoService(){
        return new UserInfoServiceImpl();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("admin");*/
       auth.userDetailsService(userInfoService()).passwordEncoder(new BCryptPasswordEncoder());
    }
}
