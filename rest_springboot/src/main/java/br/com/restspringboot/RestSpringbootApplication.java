package br.com.restspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import br.com.restspringboot.config.JwtFilter;

@SpringBootApplication
public class RestSpringbootApplication extends SpringBootServletInitializer {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/contato/*");

		return registrationBean;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RestSpringbootApplication.class, args);
	}

}