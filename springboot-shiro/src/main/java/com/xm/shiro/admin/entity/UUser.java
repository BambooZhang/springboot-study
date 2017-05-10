package com.xm.shiro.admin.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * @Title: UUser.java 
 * @Package com.xm.shiro.admin.entity
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author bamboo  <a href=
 *         "mailto:zjcjava@163.com?subject=hello,bamboo&body=Dear Bamboo:%0d%0a描述你的问题："
 *         Bamboo</a>   
 * @date 2017-5-10 0:13:08
 * @version V1.0   
 */
public class UUser  implements Serializable {
	 /** serialVersionUID. */
 	private static final long serialVersionUID =1493049839167L;
 	
	private Long id;//
	private String nickname;//用户昵称
	private String email;//邮箱|登录帐号
	private String pswd;//密码
	private Date createTime;//创建时间
	private Date lastLoginTime;//最后登录时间
	private Long status;//1:有效，0:禁止登录
	
	private List<String> roleStrlist;
	private List<String> perminsStrlist;
	
	/**
    * getting setting auto  generate
    */
	public void setId (Long id){
		this.id=id;
	}
	
	public Long getId(){
		return id;
	}
	
	
	
	public void setNickname (String nickname){
		this.nickname=nickname;
	}
	
	public String getNickname(){
		return nickname;
	}
	
	
	
	public void setEmail (String email){
		this.email=email;
	}
	
	public String getEmail(){
		return email;
	}
	
	
	
	public void setPswd (String pswd){
		this.pswd=pswd;
	}
	
	public String getPswd(){
		return pswd;
	}
	
	
	
	public void setCreateTime (Date createTime){
		this.createTime=createTime;
	}
	
	public Date getCreateTime(){
		return createTime;
	}
	
	
	
	public void setLastLoginTime (Date lastLoginTime){
		this.lastLoginTime=lastLoginTime;
	}
	
	public Date getLastLoginTime(){
		return lastLoginTime;
	}
	
	
	
	public void setStatus (Long status){
		this.status=status;
	}
	
	public Long getStatus(){
		return status;
	}
	
	
	
	//generate toString method
	@Override
	public String toString (){
		return "UUser[id="+id
		+",nickname="+nickname
		+",email="+email
		+",pswd="+pswd
		+",createTime="+createTime
		+",lastLoginTime="+lastLoginTime
		+",status="+status+"]";
	}

	

	public List<String> getRoleStrlist() {
		return roleStrlist;
	}

	public void setRoleStrlist(List<String> roleStrlist) {
		this.roleStrlist = roleStrlist;
	}

	public List<String> getPerminsStrlist() {
		return perminsStrlist;
	}

	public void setPerminsStrlist(List<String> perminsStrlist) {
		this.perminsStrlist = perminsStrlist;
	}

	

	
	
	
}
