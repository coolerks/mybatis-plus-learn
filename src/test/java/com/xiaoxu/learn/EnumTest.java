package com.xiaoxu.learn;

import com.xiaoxu.learn.attribute.Sex;
import com.xiaoxu.learn.bean.UserInfo;
import com.xiaoxu.learn.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnumTest {
    @Autowired
    UserMapper mapper;
    @Test
    void enumTest() {
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
        UserInfo user = new UserInfo(null, "人", "aaa@ewwe.co", 12);
        user.setSex(Sex.FEMALE);
        mapper.insert(user);
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
    }
}
