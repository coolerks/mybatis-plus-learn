package com.xiaoxu.learn;

import com.xiaoxu.learn.bean.UserInfo;
import com.xiaoxu.learn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    UserService service;

    @Test
    void simpleSelect() {
        System.out.println("service.count() = " + service.count());
        System.out.println("service.list() = " + service.list());
        System.out.println("service.listMaps() = " + service.listMaps());
        System.out.println("service.listObjs() = " + service.listObjs());
        System.out.println("service.listByIds(List.of(1, 3, 5)) = " + service.listByIds(List.of(1, 3, 5)));
        System.out.println("service.getById(1580903310957416450L) = " + service.getById(1580903310957416450L));
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("姓名");
        userInfo.setEmail("name@kjk.aa");
        userInfo.setAge(56);
        service.save(userInfo);
    }

    @Test
    void insertBatch() {
        System.out.println("service.list() = " + service.list());
        service.saveBatch(List.of(new UserInfo(null, "ming", "a@a", 11),
                new UserInfo(null, "afasd", "g@a", 152), new UserInfo(null, "cfe", "a@a", 211)));
        System.out.println("service.list() = " + service.list());
    }

    // 第二个参数为数量，从0开始
    @Test
    void insertBatchCount() {
        System.out.println("service.list() = " + service.list());
        service.saveBatch(List.of(new UserInfo(null, "1111", "a@a", 11),
                new UserInfo(null, "2222", "g@a", 152), new UserInfo(null, "3333", "a@a", 211)), 1);
        System.out.println("service.list() = " + service.list());
    }

    // 根据主键进行插入或者更新某条记录，如果数据库中不存在这个主键，那么将会进行插入；如果存在这个主键，就进行更新这条记录
    @Test
    void insertUpdate() {
        System.out.println("service.list() = " + service.list());
        UserInfo userInfo = new UserInfo(9999L, "9999", "g@a", 152);
        service.saveOrUpdate(userInfo);
        System.out.println("service.list() = " + service.list());
    }

    @Test
    void insertUpdateBatch() {
        System.out.println("service.list() = " + service.list());
        service.saveOrUpdateBatch(List.of(new UserInfo(1580903310957416450L, "姓名-更新", "name@kjk.aa", 56),
                new UserInfo(1580903370369757185L, "姓名-sxx", "name@kjk.aa", 56)));
        System.out.println("service.list() = " + service.list());
    }

    @Test
    void update() {
        System.out.println("service.getById(1580903310957416450L) = " + service.getById(1580903310957416450L));
        service.updateById(new UserInfo(1580903310957416450L, "姓名-更新-更新", "name@kjk.aa", 56));
        System.out.println("service.getById(1580903310957416450L) = " + service.getById(1580903310957416450L));
    }

    @Test
    void updateOther() {
        System.out.println("service.list() = " + service.list());
        service.updateBatchById(List.of(new UserInfo(1580903310957416450L, "姓名0-更新", "name@kjk.aa", 56),
                new UserInfo(1580903370369757185L, "姓名1-sxx", "name@kjk.aa", 56)));
        System.out.println("service.list() = " + service.list());
    }

    @Test
    void delete() {
        System.out.println("service.list() = " + service.list());
        service.removeById(1580906572498501634L);
        System.out.println("service.list() = " + service.list());
        service.removeById(new UserInfo(1580905782966972420L, null, null, 0));
        System.out.println("service.list() = " + service.list());
        service.removeByIds(List.of(1580905782966972419L, 1580905782966972418L));
        System.out.println("service.list() = " + service.list());
        service.removeBatchByIds(List.of(1580905523557658625L, 1580905523549270018L));
        System.out.println("service.list() = " + service.list());
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1580905523519909890L);
        service.removeByMap(map);
        System.out.println("service.list() = " + service.list());
    }


}
