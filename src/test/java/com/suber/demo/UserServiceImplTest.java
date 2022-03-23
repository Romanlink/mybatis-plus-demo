package com.suber.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suber.demo.mapper.UserBaseMapper;
import com.suber.demo.model.UserBase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author liangwang
 * @create 2022/3/22 6:02 下午
 */
@SpringBootTest
public class UserServiceImplTest {

    @Resource
    UserBaseMapper mapper;

    @Test
    public void queryAll() {
        mapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void queryByName() {
        QueryWrapper<UserBase> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("key_name", "zhangsan");
        System.out.println(mapper.selectList(userQueryWrapper));
    }

    @Test
    public void queryByIds() {
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        System.out.println(mapper.selectBatchIds(idList));

    }

    @Test
    public void count() {
        QueryWrapper<UserBase> userQueryWrapper = new QueryWrapper<>();
        System.out.println(mapper.selectCount(userQueryWrapper));
    }
    @Test
    public void changeBy() {
        QueryWrapper<UserBase> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("key_name", "zhangsan");
        int num = mapper.update(UserBase.builder()
                .nameKey("lisi")
                .build(), userQueryWrapper);
        System.out.println("影响行数：" + num);
    }

    // 通过ID修改信息
    @Test
    public void changeUserById() {
        int num = mapper.updateById(UserBase.builder()
                .nameKey("lisi")
                .build());
        System.out.println("影响行数：" + num);
    }

    //添加一条数据
    @Test
    public void add() {
        mapper.insert(UserBase.builder().nameKey("zhangsan").build());
        // 数据库查询
        // select AES_DECRYPT(UNHEX(key_name),'ad1725339b2dd0a68903c57b635942ca') from user_base  where id =2

    }

    //添加多条数据
    @Test
    public void addList() {
        for (int i = 0; i < 10; i++) {
            mapper.insert(UserBase.builder().nameKey("zhangsan").build());
        }
    }
}
