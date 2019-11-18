package com.fw.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author MP-ML
 * @since 2019-03-27
 */
public class WorkOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModify;

    /**
     * 删除标志;0-未删除,1-已删除
     */
    private Integer isDelete;

    /**
     * 服务类型;0-修空调,1-空调移机,2-空调加氟,3-修冰箱,4-修洗衣机,5-修热水器,6-修燃气灶,7-修壁挂炉,8-修油烟机,9-家电清洗,10-家政保洁,11-其他小家电
     */
    private Integer type;

    /**
     * 地址
     */
    private String address;

    /**
     * 上门服务时间
     */
    private String serviceTime;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 故障描述
     */
    private String message;

    /**
     * 订单状态
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(LocalDateTime gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WorkOrder{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                ", isDelete=" + isDelete +
                ", type=" + type +
                ", address='" + address + '\'' +
                ", serviceTime=" + serviceTime +
                ", mobile='" + mobile + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
