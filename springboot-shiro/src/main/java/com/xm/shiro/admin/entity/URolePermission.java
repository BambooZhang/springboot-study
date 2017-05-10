package com.xm.shiro.admin.entity;
import java.io.Serializable;



/**
 * @Title: URolePermission.java 
 * @Package com.xm.shiro.admin.entity
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author bamboo  <a href=
 *         "mailto:zjcjava@163.com?subject=hello,bamboo&body=Dear Bamboo:%0d%0a描述你的问题："
 *         Bamboo</a>   
 * @date 2017-5-10 0:12:46
 * @version V1.0   
 */
public class URolePermission  implements Serializable {
	 /** serialVersionUID. */
 	private static final long serialVersionUID =1493049839167L;
 	
	private Long rid;//角色ID
	private Long pid;//权限ID
	
	
	/**
    * getting setting auto  generate
    */
	public void setRid (Long rid){
		this.rid=rid;
	}
	
	public Long getRid(){
		return rid;
	}
	
	
	
	public void setPid (Long pid){
		this.pid=pid;
	}
	
	public Long getPid(){
		return pid;
	}
	
	
	
	//generate toString method
	@Override
	public String toString (){
		return "URolePermission[rid="+rid
		+",pid="+pid+"]";
	}
	
	
}
