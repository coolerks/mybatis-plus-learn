package com.xiaoxu.learn;

import com.xiaoxu.learn.bean.UserInfo;
import com.xiaoxu.learn.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusLearnApplicationTests {

    @Autowired
    UserMapper mapper;

    @Test
    void insert() {
        System.out.println("\n\n\n\n插入前");
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));


        UserInfo userInfo = new UserInfo();
        userInfo.setName("admin3");
        userInfo.setEmail("6666@qqq.qqq");
        userInfo.setAge(11);
        System.out.println("mapper.insert(user) = " + mapper.insert(userInfo));


        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
        System.out.println("插入后\n\n\n\n");
    }

    @Test
    void updateByPrimaryKey() {
        System.out.println("\n\n\n\n修改前");
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));


        UserInfo userInfo = new UserInfo();
        userInfo.setId(1580877194695786497L);
        userInfo.setName("admin");
        userInfo.setEmail("6666@qqq.qqq");
        userInfo.setAge(101);
        System.out.println("mapper.updateById(user) = " + mapper.updateById(userInfo));


        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
        System.out.println("修改后\n\n\n\n");
    }

    @Test
    void deleteByPrimaryKey() {
        System.out.println("\n\n\n\n删除前");
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));


        UserInfo userInfo = new UserInfo();
        userInfo.setId(1580878736567980034L);
        userInfo.setName("admin");
        userInfo.setEmail("6666@qqq.qqq");
        userInfo.setAge(101);

        Map<String, Object> map = new HashMap<>();
        map.put("id", 1580879257869725698L);
        map.put("name", "admin3");
        // 通过Map进行删除
        mapper.deleteByMap(map);

        // 通过对象中的主键进行删除
        mapper.deleteById(userInfo);
        // 直接指定id
        System.out.println("mapper.deleteById(1580877194695786497L) = " + mapper.deleteById(1580877194695786497L));


        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
        System.out.println("删除后\n\n\n\n");
    }

    @Test
    void deleteBatch() {
        System.out.println("\n\n\n\n批量删除前");
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));

        System.out.println("mapper.deleteBatchIds(List.of()) = "
                + mapper.deleteBatchIds(List.of(1580880626341011458L, 1580880653503369218L, 1580880677410893825L,
                1580880702023098369L, 1580880729009229825L, 1580880758923018242L)));

        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
        System.out.println("批量删除后\n\n\n\n");
    }


    @Test
    void simpleSelect() {
        System.out.println("mapper.selectById(1) = " + mapper.selectById(1));
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
        System.out.println("mapper.selectCount(null) = " + mapper.selectCount(null));
        System.out.println("mapper.selectMaps(null) = " + mapper.selectMaps(null));
        System.out.println("mapper.selectObjs(null) = " + mapper.selectObjs(null));
        System.out.println("mapper.selectBatchIds(List.of(2, 3, 5)) = " + mapper.selectBatchIds(List.of(2, 3, 5)));
        HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "Sandy");
        System.out.println("mapper.selectByMap(columnMap) = " + mapper.selectByMap(columnMap));
        System.out.println("mapper.exists(null) = " + mapper.exists(null));
    }

    @Test
    void consumer() {
//        System.out.println("mapper.selectByAge(10) = " + mapper.selectByAge(10));
    }

    @Test
    void id() {
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
        UserInfo userInfo = new UserInfo(null, "名称", "aaa@qqq", 999);
        mapper.insert(userInfo);
        System.out.println("userInfo = " + userInfo);
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
    }
    @Test
    void logicDelete() {
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
        mapper.deleteBatchIds(List.of(1580905044282900481L, 1580905044282900482L, 1580905044282900483L));
        System.out.println("mapper.selectList(null) = " + mapper.selectList(null));
    }
}
