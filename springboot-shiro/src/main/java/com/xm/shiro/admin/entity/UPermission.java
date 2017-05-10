package com.xm.shiro.admin.entity;
import java.io.Serializable;



/**
 * @Title: UPermission.java 
 * @Package com.xm.shiro.admin.entity
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author bamboo  <a href=
 *         "mailto:zjcjava@163.com?subject=hello,bamboo&body=Dear Bamboo:%0d%0a描述你的问题："
 *         Bamboo</a>   
 * @date 2017-5-10 0:00:45
 * @version V1.0   
 */
public class UPermission  implements Serializable {
	 /** serialVersionUID. */
 	private static final long serialVersionUID =1493049839167L;
 	
	private Long id;//
	private String url;//url地址
	private String name;//url描述
	
	
	/**
    * getting setting auto  generate
    */
	public void setId (Long id){
		this.id=id;
	}
	
	public Long getId(){
		return id;
	}
	
	
	
	public void setUrl (String url){
		this.url=url;
	}
	
	public String getUrl(){
		return url;
	}
	
	
	
	public void setName (String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	
	
	//generate toString method
	@Override
	public String toString (){
		return "UPermission[id="+id
		+",url="+url
		+",name="+name+"]";
	}
	
	
}
