package com.bamboo.mybatis.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bamboo
 * @since 2019-01-18
 */
@TableName("t_red_packet_activity")
public class RedPacketActivity extends Model<RedPacketActivity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动名称
     */
    private String actName;

    /**
     * 活动状态 0未上线，1上线,2过期
     */
    private Integer status;

    /**
     * 详情url
     */
    private String detail;

    /**
     * 计划释放总的云鑫通
     */
    private BigDecimal planReleaseYxt;

    /**
     * 释放总的云鑫通
     */
    private BigDecimal releaseYxt;

    /**
     * 计划助力释放云鑫通
     */
    private BigDecimal planBoosterYxt;

    /**
     * 助力释放总云鑫通
     */
    private BigDecimal boosterYxt;

    /**
     * 入口展示时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;

    private Date utime;

    private Date ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    public BigDecimal getPlanReleaseYxt() {
        return planReleaseYxt;
    }

    public void setPlanReleaseYxt(BigDecimal planReleaseYxt) {
        this.planReleaseYxt = planReleaseYxt;
    }
    public BigDecimal getReleaseYxt() {
        return releaseYxt;
    }

    public void setReleaseYxt(BigDecimal releaseYxt) {
        this.releaseYxt = releaseYxt;
    }
    public BigDecimal getPlanBoosterYxt() {
        return planBoosterYxt;
    }

    public void setPlanBoosterYxt(BigDecimal planBoosterYxt) {
        this.planBoosterYxt = planBoosterYxt;
    }
    public BigDecimal getBoosterYxt() {
        return boosterYxt;
    }

    public void setBoosterYxt(BigDecimal boosterYxt) {
        this.boosterYxt = boosterYxt;
    }
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }
    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "RedPacketActivity{" +
        "id=" + id +
        ", actName=" + actName +
        ", status=" + status +
        ", detail=" + detail +
        ", planReleaseYxt=" + planReleaseYxt +
        ", releaseYxt=" + releaseYxt +
        ", planBoosterYxt=" + planBoosterYxt +
        ", boosterYxt=" + boosterYxt +
        ", beginTime=" + beginTime +
        ", endTime=" + endTime +
        ", utime=" + utime +
        ", ctime=" + ctime +
        "}";
    }
}
