package com.pdgj.manager.service.userManage.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdgj.manager.domain.userEntity.UserEntity;
import com.pdgj.manager.domain.userEntity.UserIntfcEntity;
import com.pdgj.manager.mapper.userManage.UserMapper;
import com.pdgj.manager.service.userManage.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author fgs
 * @Date 2020/12/2 9:21
 * @Version 1.0
 * @Description
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * @Author fgs
     * @Description 获取用户信息
     * @Date 10:11 2020/12/2
     **/
    @Override
    public PageInfo<UserEntity> queryUserPageList(UserEntity userEntity) {
        PageHelper.startPage(userEntity.getPageNum(), userEntity.getPageSize(), true);
        List<UserEntity> entityList = userMapper.queryUserPageList(userEntity);
        PageInfo<UserEntity> result = new PageInfo<>(entityList);
        result.setPageNum(result.getPageNum());
        result.setPageSize(result.getPageSize());
        result.setTotal(result.getTotal());
        result.setSize(result.getSize());
        return result;
    }

    /**
     * @Author fgs
     * @Description 新增用户信息
     * @Date 10:17 2020/12/2
     **/
    @Override
    public void saveUser(UserEntity userEntity) {
        userEntity.setId(UUID.randomUUID().toString().replaceAll("-",""));
        userMapper.saveUser(userEntity);
    }

    /**
     * @Author fgs
     * @Description 删除用户信息
     * @Date 10:21 2020/12/2
     **/
    @Override
    public void deleteUser(UserEntity userEntity) {
        userMapper.deleteUser(userEntity);
    }

    /**
     * @Author fgs
     * @Description 修改用户信息
     * @Date 10:21 2020/12/2
     **/
    @Override
    public void updateUser(UserEntity userEntity) {
        userMapper.updateUser(userEntity);
    }

    /**
     * @Author fgs
     * @Description 用户绑定接口
     * @Date 10:45 2020/12/2
     **/
    @Override
    public void userBindIntfc(UserIntfcEntity userIntfcEntity) {
        List<UserIntfcEntity> finalList = new ArrayList<>();
        userMapper.deleteUserIntfc(userIntfcEntity);
        List<String> intfcIds = userIntfcEntity.getIntfcIds();
        if(CollectionUtils.isNotEmpty(intfcIds)){
            intfcIds.forEach(o -> {
                UserIntfcEntity en = new UserIntfcEntity();
                en.setId(UUID.randomUUID().toString().replaceAll("-",""));
                en.setUserId(userIntfcEntity.getUserId());
                en.setIntfcId(o);
                finalList.add(en);
            });
            userMapper.saveUserIntfc(finalList);
        }
    }
}
