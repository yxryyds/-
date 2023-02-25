package com.example.springBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@MapperScan("com.example.springBoot.dao")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(Application.class)
				.lazyInitialization(true)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

	}

}
