package com.xm.shiro.constant;

import java.util.Date;

/**
 * 开发框架基础架构的公共常量设置类（行知网络使用此基础框架的项目均可使用此常量类）
 * @author xieyong
 *
 */
public class Constant {
	
	/**失败标识-文字*/
	public static final String FAIL_TEXT = "FAIL";
	/**成功标识-文字*/
	public static final String SUCCESS_TEXT = "SUCCESS";
	/**整个应用0表示失败*/
	public static final String FAIL="0";
	/**整个应用1表示成功*/
	public static final String SECCUESS="1";
	/**未登录*/
	public static final String NO_LOGIN = "-1";
	/**未授权*/
	public static final String NO_AUTHORITY = "-2";
	
	/**整个应用0表示否*/
	public static final int NO = 0;
	/**整个应用1表示是*/
	public static final int YES = 1;
	
	/**状态（0、未提交，1、已提交待抢单，2、已抢单）*/
	public static final int VIP_STATUS_NO = 0;
	/**状态（0、未提交，1、已提交待抢单，2、已抢单）*/
	public static final int VIP_STATUS_SUBMIT = 1;
	/**状态（0、未提交，1、已提交待抢单，2、已抢单）*/
	public static final int VIP_STATUS_OVER = 2;
	
	/**待审核*/
	public static final int CENSORED_STATE_NO = 0;
	/**审核通过*/
	public static final int CENSORED_STATE_PASS = 1;
	/**审核不通过*/
	public static final int CENSORED_STATE_NOPASS = 2;
	
	/**禁用*/
	public static final int DISABLED = 0;
	/**启用*/
	public static final int ENABLED = 1;
	
	/**是否定制（否）*/
	public static final int IS_CUSTOMIZED_NO = 0;
	/**是否定制（是）*/
	public static final int IS_CUSTOMIZED_YES = 1;
	
	/**高级定制状态（0、未提交，1、已提交待抢单，2、已抢单）*/
	public static final int VIP_CUSTOMIZED_SUBMIT = 0;
	/**高级定制状态（0、未提交，1、已提交待抢单，2、已抢单）*/
	public static final int VIP_CUSTOMIZED_UNCENSOR = 1;
	/**高级定制状态（0、未提交，1、已提交待抢单，2、已抢单）*/
	public static final int VIP_CUSTOMIZED_CENSOR = 0;
	
	/**不删除*/
	public static final int DEL_STATE_NO = 0;
	/**已删除*/
	public static final int DEL_STATE_YES = 1;
	
	/**显示1*/
	public static final int SHOW_STATE_YES = 1;
	/**不显示0*/
	public static final int SHOW_STATE_NO = 0;
	
	/**默认的分页每页记录数*/
	public static final int DEFAULT_PAGE_SIZE = 10;
	
	/**错误信息，参数无效或不合要求*/
	public static final String ERR_MSG_INVALID_ARG = "Invalid argument.";
	
	/**错误信息，捕获到异常*/
	public static final String ERR_MSG_EXCEPTION_CATCHED = "Exception catched.";
	
	/**错误信息，数据不存在*/
	public static final String ERR_MSG_DATA_NOT_EXISTS = "Data not exists.";
	
	/**项目的路径：http://ip:端口*/
	public static String BASE_PATH = null;
	
	/**图片服务器地址*/
	public static String IMAGES_SERVICE_URL = null;
	
	
	
	/**消息类型：url消息*/
	public static final String MESSAGE_HTML ="0";
	/**消息类型：订单消息*/
	public static final String MESSAGE_ORDER ="1";
	/**消息类型：会员信息变更消息*/
	public static final String MESSAGE_USER ="2";
	/**第三方认证类型：*/
	public static final String THIRD_OAUTH_QQ ="qq";
	public static final String THIRD_OAUTH_WEIXIN ="weixin";
	public static final String THIRD_OAUTH_WEIBO ="weibo";
	
	
	/**短信验证码过期的定时任务时间*/
	public static final long TASK_INTERVAL_TIME = 1000*60*5;
	/**短信验证码过期的定时任务时间*/
	public static final int OUT_TIME = 5;// 超时时间为5分钟
	public static final int INTERVAL_TIME = 5;//短信验证码发送时间间隔5分钟
	
	/**登录二维码过期的定时任务时间*/
	public static final long TASKQR_INTERVAL_TIME = 1000*60*5;
	
	
	/**系统默认大区和异业联盟*/
	public static long  DEFAULT_DISTRIBUTORID =60000L;
	public static long  DEFAULT_YIYE_DISTRIBUTORID =60001L;
	
	/**新增用户送优惠券任务开启状体:默认关闭*/
	public static  boolean TASK_MEMBER_COUPON_STATUS =false;
	
	
}
