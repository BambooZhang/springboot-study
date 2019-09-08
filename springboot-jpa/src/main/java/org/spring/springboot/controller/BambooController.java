package org.spring.springboot.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springboot.dubbo.BambooDubboService;
import org.spring.springboot.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


/**
 * demo url
 * http://localhost:4444
 *
 * @author bamboo
 * @time 2019-6-27
 */
@RestController
@RequestMapping("/devmgr")
public class BambooController {
    private Log logger = LogFactory.getLog(BambooController.class);

    @Autowired
    BambooDubboService bambooDubboService;

    /**
     * 查询操作
     */
    @GetMapping("/uuid")
    public Object find(Model model, String uuid) {

        if(Objects.isNull(uuid)){
            return  "error:null param";
        }

        return bambooDubboService.sayBamboo(uuid);
    }
  /**
     * 新增和修改操作
     */
    @GetMapping("")
    public Object get(Model model, Device device) {

        if(Objects.isNull(device)){
            return  "error:null param";
        }
        bambooDubboService.saveDevice(device);
        return "success";
    }


}