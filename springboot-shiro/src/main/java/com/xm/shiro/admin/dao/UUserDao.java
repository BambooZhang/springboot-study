package com.xm.shiro.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import com.xm.shiro.admin.entity.UUser;
import com.xm.shiro.constant.BaseDao;


 @Mapper
public interface UUserDao extends BaseDao<UUser, Long> {
	
	/**
	 * 增加对象
	 * @param obj
	 */
	public UUser findByName(String	 name);
}
