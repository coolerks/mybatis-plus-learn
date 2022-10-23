package com.xiaoxu.learn;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaoxu.learn.bean.UserInfo;
import com.xiaoxu.learn.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PageTest {
    @Autowired
    UserMapper mapper;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void pages() throws JsonProcessingException {
        mapper.selectList(null);
        Page<UserInfo> page = new Page<>(1, 2);
        mapper.selectPage(page, null);
        System.out.println("page = " + page);
        // 页数
        System.out.println("page.getPages() = " + page.getPages());
        // 当前页
        System.out.println("page.getCurrent() = " + page.getCurrent());
        // 每页大小
        System.out.println("page.getSize() = " + page.getSize());
        // 总的元素数
        System.out.println("page.getTotal() = " + page.getTotal());
        // 获取查出来的数据的List
        System.out.println("page.getRecords() = " + page.getRecords());
        // 是否有下一页
        System.out.println("page.hasNext() = " + page.hasNext());
        // 是否有上一页
        System.out.println("page.hasPrevious() = " + page.hasPrevious());
        System.out.println("objectMapper.writeValueAsString(page) = " + objectMapper.writeValueAsString(page));
    }

    @Test
    void consumerPage() throws JsonProcessingException {
        Page<UserInfo> page = new Page<>(2, 3);
        mapper.selectByAge(page, 10);
        System.out.println("objectMapper.writeValueAsString(page) = " + objectMapper.writeValueAsString(page));
    }
}
