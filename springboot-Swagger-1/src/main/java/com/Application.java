package com;




import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;


 
@Api(value = "springboot服务",description="springboot服务API 根目录")
@RestController
@SpringBootApplication
public class Application  {

	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
	 
	
    @RequestMapping(value={"/"}, method=RequestMethod.GET)
    String home() {
    	
        return "springboot server";
    }
    

    

    

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
    
    
}

