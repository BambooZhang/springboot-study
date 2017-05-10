package com.xm.shiro.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xm.shiro.admin.entity.UPermission;
import com.xm.shiro.constant.BaseDao;


 @Mapper
public interface UPermissionDao extends BaseDao<UPermission, Long> {

	
	
	/**
	 * 根据用户id获取用户权限
	 * @param obj
	 */
	 List<UPermission> findPermissionByUid(Long id);
}
