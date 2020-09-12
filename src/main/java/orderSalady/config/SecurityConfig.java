package orderSalady.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity)throws Exception{
		/*
			TODO:페이지 권한설정
			- /user/login.do, /user/join.do 는 누구나 가능하고 나머지 /user/**는 모두 불가능 
			- /admin/user/login.do 는 누구나 가능하고 나머지 /admin/user/**는 모두 불가능
		*/
		httpSecurity.csrf().disable();
		//httpSecurity.authorizeRequests().antMatchers("/**").permitAll();
			//.antMatchers("/admin/user/**").permitAll()
			//.antMatchers("/admin/**").hasRole("ADMIN")
			//.antMatchers("/**").permitAll();
		httpSecurity.authorizeRequests().antMatchers("/admin/user/login.do", "/admin/user/logout.do", "/admin/user/join.do").permitAll()
		.and().authorizeRequests().antMatchers("/admin/user/main.do").hasRole("ADMIN");
		//.antMatchers("/admin/**").hasRole("ADMIN");
	}
	
	@Override
	public void configure(WebSecurity webSecurity)throws Exception{
		webSecurity.ignoring().antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/plugins/**");
    }
}