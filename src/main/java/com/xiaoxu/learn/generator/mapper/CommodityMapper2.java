package com.xiaoxu.learn.generator.mapper;
import java.math.BigDecimal;
import com.xiaoxu.learn.generator.domain.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author singx
* @description 针对表【commodity】的数据库操作Mapper
* @createDate 2022-10-23 17:26:20
* @Entity generator.domain.Commodity
*/
@Mapper
public interface CommodityMapper2 extends BaseMapper<Commodity> {
    int insertBatch(@Param("commodityCollection") Collection<Commodity> commodityCollection);

    int deleteByNameAndPrice(@Param("name") String name, @Param("price") BigDecimal price);
}




