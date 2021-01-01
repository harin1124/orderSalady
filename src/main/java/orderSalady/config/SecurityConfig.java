package orderSalady.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		/*
			TODO:페이지 권한설정
			- /user/login.do, /user/join.do 는 누구나 가능하고 나머지 /user/**는 모두 불가능 
			- /admin/user/login.do 는 누구나 가능하고 나머지 /admin/user/**는 모두 불가능
		*/
		http.csrf().disable();
		//.authorizeRequests() //특정 경로 허용
		//.antMatchers("/", "/main", "/user/joinForm", "/user/join").permitAll()
		//.anyRequest().authenticated();
		
		//.and().formLogin().loginPage("/user/loginForm").permitAll().loginProcessingUrl("/login");
		//.successHandler().failureHandler() 핸들러 처리
		//.and().logout().logoutUrl("").logoutSuccessHandler().invalidateHttpSession(true).deleteCookies("JSESSIONID");
	}
	
	@Override
	public void configure(WebSecurity webSecurity)throws Exception{
		//webSecurity.ignoring().antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/plugins/**");
		webSecurity.ignoring().antMatchers("/templates/**", "/css/**", "/fonts/**", "/images/**", "/js/**", "/plugins/**");
    }
}