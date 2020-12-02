package com.pdgj.manager.mapper.userManage;

import com.pdgj.manager.domain.userEntity.UserEntity;
import com.pdgj.manager.domain.userEntity.UserIntfcEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author fgs
 * @Date 2020/12/2 9:32
 * @Version 1.0
 * @Description
 **/
@Repository
public interface UserMapper {
    /* 获取用户信息 */
    List<UserEntity> queryUserPageList(UserEntity userEntity);

    /* 新增用户信息 */
    void saveUser(UserEntity userEntity);

    /*删除用户信息*/
    void deleteUser(UserEntity userEntity);

    /*修改用户信息*/
    void updateUser(UserEntity userEntity);

    /*删除关系表数据*/
    void deleteUserIntfc(UserIntfcEntity userIntfcEntity);

    /*新增关系表数据*/
    void saveUserIntfc(List<UserIntfcEntity> list);
}
