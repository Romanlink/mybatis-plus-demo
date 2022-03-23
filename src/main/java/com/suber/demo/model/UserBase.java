package com.suber.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.suber.demo.support.AesTypeHandler;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @Author liangwang
 * @create 2022/3/22 4:01 下午
 */
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Accessors
//@ToString
@Builder
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user_base", autoResultMap = true)
public class UserBase extends Model {

    public UserBase() {
    }

    public UserBase(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @TableId(value = "id", type = IdType.AUTO)//指定自增策略
    private Integer id;

    @TableField(typeHandler = AesTypeHandler.class)
    private String name;

//    @TableField(typeHandler = AesTypeHandler.class)
//    private String desc;

}
