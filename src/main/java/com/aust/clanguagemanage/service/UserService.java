package com.aust.clanguagemanage.service;

import com.alibaba.fastjson.JSONObject;
import com.aust.clanguage.base.constant.ConstantsForDomain;
import com.aust.clanguage.base.domain.User;
import com.aust.clanguage.base.mapper.UserMapper;
import com.aust.clanguage.base.vo.user.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserVo> findUsersByRoleAndList(Integer page, Integer pageSize){
        List<User> list = userMapper.findUsersByRoleAndPage(ConstantsForDomain.ROLE_TEACHER,page, pageSize);
        List<UserVo> vos = new ArrayList<>();
        for (User user: list){
            vos.add(UserVo.of(user));
        }
        log.info("人员返回：{}", JSONObject.toJSONString(vos));
        return vos;
    }

    public User userLogin(String name, String password) {
        userMapper.findUser

    }
}
