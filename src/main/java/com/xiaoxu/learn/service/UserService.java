package com.xiaoxu.learn.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoxu.learn.bean.UserInfo;
import com.xiaoxu.learn.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, UserInfo> {

}
