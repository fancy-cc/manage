package com.fw.manage.web.vo;

import java.io.Serializable;

public class WorkOrderVO implements Serializable {

    private static final long serialVersionUID = 1L;

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
}
