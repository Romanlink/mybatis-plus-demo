package com.suber.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suber.demo.model.UserBase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBaseMapper extends BaseMapper<UserBase> {

}
