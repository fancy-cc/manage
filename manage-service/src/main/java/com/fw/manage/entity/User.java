package com.fw.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("test")
public class User {
    /**
     *  主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     *  创建时间
     */
    private Date gmt_create;

    /**
     *  修改时间
     */
    private Date gmt_modify;

    /**
     *  删除标志
     */
    private Integer is_delete;

    /**
     *  姓名
     */
    private String name;

    /**
     *  类型
     */
    private Integer type;
}
