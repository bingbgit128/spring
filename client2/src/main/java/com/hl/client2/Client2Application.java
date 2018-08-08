package com.hl.client2;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.apache.http.HttpHeaders;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Client2Application {

	public static void main(String[] args) {
		SpringApplication.run(Client2Application.class, args);
	}

	/**
	 *  配置文件
	 * @return
	 */
	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.setMaxAge(18000L);
		return corsConfiguration;
	}
	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
		configurationSource.registerCorsConfiguration("/**",buildConfig());
		return new CorsFilter(configurationSource);
	}
}
