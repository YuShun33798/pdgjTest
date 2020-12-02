package com.pdgj.manager.service.userManage;

import com.github.pagehelper.PageInfo;
import com.pdgj.manager.domain.userEntity.UserEntity;
import com.pdgj.manager.domain.userEntity.UserIntfcEntity;

/**
 * @Author fgs
 * @Date 2020/12/2 9:20
 * @Version 1.0
 * @Description
 **/
public interface UserService {
    /*获取用户信息*/
    PageInfo<UserEntity> queryUserPageList(UserEntity userEntity);

    /*新增用户信息*/
    void saveUser(UserEntity userEntity);

    /*删除用户信息*/
    void deleteUser(UserEntity userEntity);

    /*修改用户信息*/
    void updateUser(UserEntity userEntity);

    /*用户绑定接口*/
    void userBindIntfc(UserIntfcEntity userIntfcEntity);
}
