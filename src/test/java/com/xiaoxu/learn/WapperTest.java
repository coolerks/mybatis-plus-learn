package com.xiaoxu.learn;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiaoxu.learn.bean.UserInfo;
import com.xiaoxu.learn.generator.domain.Commodity;
import com.xiaoxu.learn.mapper.UserMapper;
import com.xiaoxu.learn.generator.mapper.CommodityMapper2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class WapperTest {
    @Autowired
    UserMapper mapper;

    @Autowired
    CommodityMapper2 mapper2;

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

    @Test
    void update() {
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.set("age", 888);
//        updateWrapper.eq("age", 999);
        mapper.update(null, updateWrapper);
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
    }

    @Test
    void condition() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        String name = null;
        Integer minAge = 10, maxAge = 150;
//        if(name != null) {
//            queryWrapper.eq("name", name);
//        }
//        if(minAge != null) {
//            queryWrapper.ge("age", minAge);
//        }
//        if(maxAge != null) {
//            queryWrapper.le("age", maxAge);
//        }
        queryWrapper.eq(name != null, "name", name);
        queryWrapper.ge(minAge != null, "age", minAge);
        queryWrapper.le(maxAge != null, "age", maxAge);
        mapper.selectList(queryWrapper);
    }
    @Test
    void lambdaQueryWrapper() {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        String name = "名称";
        Integer minAge = 10, maxAge = 1500;
        queryWrapper.select(UserInfo::getId, UserInfo::getName, UserInfo::getAge);
        queryWrapper.eq(name != null, UserInfo::getName, name);
        queryWrapper.ge(minAge != null, UserInfo::getAge, minAge);
        queryWrapper.le(maxAge != null, UserInfo::getAge, maxAge);
        mapper.selectList(queryWrapper);
    }

    @Test
    void lambdaUpdateWrapper() {
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
        LambdaUpdateWrapper<UserInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(UserInfo::getAge, 888);
        updateWrapper.set(UserInfo::getAge, 999);
        mapper.update(null, updateWrapper);
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
    }

    @Test
    void allAll() {
        System.out.println("mapper2.selectList(null) = " + mapper2.selectList(null));
        Commodity commodity = new Commodity();
        commodity.setName("名");
        commodity.setPrice(new BigDecimal("66.6"));
        commodity.setVersion(1);
        mapper2.insertBatch(List.of(commodity, commodity, commodity, commodity));
        System.out.println("mapper2.selectList(null) = " + mapper2.selectList(null));
    }
}
