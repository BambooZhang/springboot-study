package com.xm.shiro.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import com.xm.shiro.admin.entity.URolePermission;
import com.xm.shiro.constant.BaseDao;


 @Mapper
public interface URolePermissionDao extends BaseDao<URolePermission, Long> {
	
	/**
	 * 增加对象
	 * @param obj
	 */
	//public void add(SysMessageTep	 obj);
}
