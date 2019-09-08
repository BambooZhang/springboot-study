package org.spring.springboot.mapping;

import org.spring.springboot.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * @program: springboot-demo
 * @description: dao操作
 * @author: Bamboo zjcjava@163.com
 * @create: 2019-09-07 13:33
 **/
public interface  DeviceRepository extends JpaRepository<Device, Long> {

    /**
     * 根据uuid
     * @param uuid
     * @return
     */
    Device findByUuid(String uuid);


    /**
     *复杂JPA操作  使用@Query()自定义sql语句  根据业务id UId去更新整个实体
     * 删除和更新操作，需要@Modifying和@Transactional注解的支持
     *
     * 更新操作中 如果某个字段为null则不更新，否则更新【注意符号和空格位置】
     *
     * @param model   传入实体，分别取实体字段进行set
     * @return  更新操作返回sql作用条数
     */
    @Modifying
    @Transactional
    @Query("update Device ex set " +
            "ex.app = CASE WHEN :#{#model.app} IS NULL THEN ex.app ELSE :#{#model.app} END ," +
            "ex.brand = CASE WHEN :#{#model.brand} IS NULL THEN ex.brand ELSE :#{#model.brand} END ," +
            "ex.model = CASE WHEN :#{#model.model} IS NULL THEN ex.model ELSE :#{#model.model} END ," +
            "ex.request =  CASE WHEN :#{#model.request} IS NULL THEN ex.request ELSE :#{#model.request} END ," +
            "ex.version =  CASE WHEN :#{#model.version} IS NULL THEN ex.version ELSE :#{#model.version} END " +
            "where ex.uuid = :#{#model.uuid}")
    int updateByuuid(@Param("model") Device model);

}