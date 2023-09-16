package com.niit.Pizza.Order.Details;

import com.niit.Pizza.Order.Details.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableFeignClients
// When used in conjunction with a load balancer (e.g., Ribbon),
// Feign can automatically distribute requests to multiple instances of a service, providing load balancing
//Feign in your Spring Boot application, you would define Feign client interfaces and annotate their methods
// to specify the HTTP requests you want to make. Spring Boot will automatically handle the rest,
// including generating HTTP requests based on your interface definitions and handling the response.
@CrossOrigin(origins = "*", allowedHeaders = "*")
//this way can be useful when you want to quickly enable cross-origin requests during development or
// when building a public API. However, in a production environment, it's recommended to specify the allowed
public class PizzaOrderDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaOrderDetailsApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean fbr=new FilterRegistrationBean<>();
		fbr.setFilter(new JwtFilter());
		fbr.addUrlPatterns("/user/pizza/data/*");
		return fbr;
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",config);

		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
