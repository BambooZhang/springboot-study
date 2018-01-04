package com.callback;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * RabbitmqController
 * <p>RabbitmqController
 *
 * @version V1.0   
 * @Class: RabbitmqController
 * @Package com.bamboo
 * @Created bamboo  zjcjava@163.com
 * @Date 2018-01-03 18:17
 */
@RestController
public class RabbitmqController {

    @Autowired
    private Sender sender;

    @GetMapping("/callSend")
    public String send(HttpServletRequest request, String msg) {
        sender.send(msg);
        return "CallSend OK.";
    }
}
