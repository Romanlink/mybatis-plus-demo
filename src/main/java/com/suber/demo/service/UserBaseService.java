package com.suber.demo.service;

import com.suber.demo.mapper.UserBaseMapper;
import com.suber.demo.model.UserBase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liangwang
 * @create 2022/3/22 6:01 下午
 */
@Service
public class UserBaseService {

    @Resource
    UserBaseMapper userBaseMapper;

    //查询全部
    public List<UserBase> queryAll() {
        return userBaseMapper.selectList(null);
    }
}
