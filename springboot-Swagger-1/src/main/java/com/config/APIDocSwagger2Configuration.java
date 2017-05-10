package com.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *   
 * 
 * @Title: APIDocSwagger2Configuration.java 
 * @Package com.common.config 
 * @Description: API doc 生产文档的Swagger配置类
 * @author bamboo
 *          <a href="mailto:zjcjava@163.com?subject=hello,bamboo&body=Dear
 *         Bamboo:%0d%0a描述你的问题：">Bamboo</a>   
 * @date 2017年4月19日 上午10:27:18 
 * @version V1.0   
 */
@Configuration
@EnableSwagger2
public class APIDocSwagger2Configuration {

	@Bean
	public Docket buildDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf()).select()
				.apis(RequestHandlerSelectors.basePackage("com"))// 要扫描的API(Controller)基础包
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo buildApiInf() {
		return new ApiInfoBuilder().title("Spring Boot中使用Swagger2 UI构建API文档").contact("bamboo").version("1.0").build();
	}
}
