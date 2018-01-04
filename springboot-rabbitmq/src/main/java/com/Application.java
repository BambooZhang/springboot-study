package com;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * <p>启动类
 *
 * @version V1.0   
 * @Class: Application
 * @Package com
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-03 16:08
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class,args);
    }
}
