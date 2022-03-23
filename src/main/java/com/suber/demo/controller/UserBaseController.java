package com.suber.demo.controller;

import com.suber.demo.mapper.UserBaseMapper;
import com.suber.demo.model.UserBase;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author liangwang
 * @create 2022/3/22 4:04 下午
 */
@RestController
@RequestMapping(value = "/user")
public class UserBaseController {

    @Resource
    UserBaseMapper userBaseMapper;

    @PostMapping
    public Object insert(@RequestBody UserBase userBase){
        int rows = userBaseMapper.insert(UserBase.builder().nameKey(userBase.getNameKey()).build());
        return "insert success" + rows + "条";
    }

    @GetMapping
    public Object list(){
        return userBaseMapper.selectList(null);
    }
}
