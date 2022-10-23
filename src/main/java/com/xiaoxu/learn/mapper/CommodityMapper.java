package com.xiaoxu.learn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoxu.learn.bean.Commodity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {
}
