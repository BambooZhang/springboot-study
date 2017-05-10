package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.xm.shiro.admin.dao")
public class Application {

	/**
	 * <p>
	 * 测试 RUN
	 * <br>
	 * 1、http://localhost:8080
	 * 2、http://localhost:8080/user/test1<br>
	 * </p>
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
