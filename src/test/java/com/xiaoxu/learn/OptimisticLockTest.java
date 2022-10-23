package com.xiaoxu.learn;

import com.xiaoxu.learn.bean.Commodity;
import com.xiaoxu.learn.mapper.CommodityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OptimisticLockTest {
    @Autowired
    CommodityMapper mapper;

    @Test
    void lock() {
        Commodity commodity = mapper.selectById(1);
        System.out.println("commodity = " + commodity);
        Commodity commodity2 = mapper.selectById(1);

        // 使用commodity更新商品
        commodity.setPrice(commodity.getPrice() - 10);
        mapper.updateById(commodity);

        System.out.println("mapper.selectById(1) = " + mapper.selectById(1));

        // 再使用commodity2更新商品
        commodity2.setPrice(commodity2.getPrice() + 20);
        mapper.updateById(commodity2);

        System.out.println("mapper.selectById(1) = " + mapper.selectById(1));

    }
}
