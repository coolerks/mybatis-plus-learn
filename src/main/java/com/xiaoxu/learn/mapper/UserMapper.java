package com.xiaoxu.learn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoxu.learn.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {
    List<UserInfo> selectByAge(Integer age);
}