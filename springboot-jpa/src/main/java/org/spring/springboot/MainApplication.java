package org.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 */
@SpringBootApplication
public class MainApplication {

	// 程序启动入口
	public static void main( String[] args ) {
		SpringApplication.run( MainApplication.class, args );

	}

}