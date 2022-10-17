package com.xiaoxu.learn;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiaoxu.learn.bean.UserInfo;
import com.xiaoxu.learn.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WapperTest {
    @Autowired
    UserMapper mapper;

    @Test
    void test() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
//         小于
//        queryWrapper.lt("id", 3);

//        小于等于
//        queryWrapper.le("id", 3);

//        大于
//        queryWrapper.gt("id", 2);

//        大于等于
//        queryWrapper.ge("id", 3);

//        等于
//        queryWrapper.eq("id", 3);

//        不等于
//        queryWrapper.ne("id", 2);

//        联合起来写，代表大于2且小于5，且不等于3
//        queryWrapper.ge("id", 2)
//                        .le("id", 5)
//                                .ne("id", 3);

//        between条件
//        queryWrapper.between("id", 2, 4);

//        like条件
//        queryWrapper.like("name", "J%");

//        not like
//        queryWrapper.notLike("name", "%a%");

//        查询某几个字段
//        queryWrapper.select("id", "name");

        /*
        也可以使用group by，select中也可以写别名
        */
//        queryWrapper.groupBy("age");
//        queryWrapper.select("age 年龄", "count(*) 数量");
//        queryWrapper.select("age as 年龄", "count(*) as 数量");

//        in的用法
//        queryWrapper.in("id", 2, 3, 4);
//        queryWrapper.in("id", List.of(2, 3, 4));

//        not in
//        queryWrapper.notIn("id", 2, 3, 5);
//        queryWrapper.notIn("id", List.of(2, 3, 5));

//        排序
//        正序
//        queryWrapper.orderBy(true, true, "id");
//        queryWrapper.orderByAsc("id");
//        倒序
//        queryWrapper.orderBy(true, true, "id");
//        queryWrapper.orderByDesc("id");

//        SELECT id, name, email, age, del FROM user WHERE del = 0 AND(id >= ? OR age >= ? AND age <= ?)
//        queryWrapper.ge("id", 5)
//                .or()
//                .ge("age", 25)
//                .le("age", 100);


//        SELECT id,name,email,age,del FROM user WHERE del=0 AND (id >= ? OR (age >= ? AND age <= ?))
//        queryWrapper.ge("id", 5)
//                .or(wrapper -> wrapper.ge("age", 25).le("age", 100));

//        queryWrapper.isNull("列名").isNotNull("列名")
        System.out.println("mapper.selectList(queryWrapper) = " + mapper.selectList(queryWrapper));
    }

    @Test
    void lambda() {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        System.out.println("mapper.selectList(queryWrapper) = " + mapper.selectList(queryWrapper));
    }

    @Test
    void delete() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 100);
        mapper.delete(queryWrapper);
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
    }

    @Test
    void subQuery() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
//        SELECT id,name,email,age,del FROM user WHERE del=0 AND (id IN (select id where id > 100))
        queryWrapper.inSql("id", "select id where id > 100");
        mapper.selectList(queryWrapper);
    }
}
