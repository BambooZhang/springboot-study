package com.xm.shiro.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import com.xm.shiro.admin.entity.UUserRole;
import com.xm.shiro.constant.BaseDao;


 @Mapper
public interface UUserRoleDao extends BaseDao<UUserRole, Long> {
	
	/**
	 * 增加对象
	 * @param obj
	 */
	//public void add(SysMessageTep	 obj);
}
