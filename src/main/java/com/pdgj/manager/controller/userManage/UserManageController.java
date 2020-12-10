package com.pdgj.manager.controller.userManage;

import com.github.pagehelper.PageInfo;
import com.pdgj.manager.domain.ResultJson;
import com.pdgj.manager.domain.interfaceInfo.InterfaceInfoEntity;
import com.pdgj.manager.domain.userEntity.UserEntity;
import com.pdgj.manager.domain.userEntity.UserIntfcEntity;
import com.pdgj.manager.service.interfaceManage.InterfaceService;
import com.pdgj.manager.service.userManage.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fgs
 * @Date 2020/12/2 8:46
 * @Version 1.0
 * @Description
 **/
@RestController
@Api(description = "用户信息管理")
@RequestMapping("/api/userManage")
public class UserManageController {

    @Autowired
    private UserService userService;

    /**
     * @Author fgs
     * @Description 获取用户信息
     * @Date 16:00 2020/12/1
     **/
    @RequestMapping(value = "/queryUserPageList", produces = "application/json")
    @CrossOrigin
    public ResultJson queryUserPageList(@RequestBody UserEntity userEntity) {
        PageInfo<UserEntity> pageInfo = userService.queryUserPageList(userEntity);
        return ResultJson.ok(pageInfo);
    }

    /**
     * @Author fgs
     * @Description 新增用户信息
     * @Date 16:00 2020/12/1
     **/
    @RequestMapping(value = "/saveUser", produces = "application/json")
    public void saveUser(@RequestBody UserEntity userEntity) {
        userService.saveUser(userEntity);
    }

    /**
     * @Author fgs
     * @Description 删除用户信息
     * @Date 16:00 2020/12/1
     **/
    @RequestMapping(value = "/deleteUser", produces = "application/json")
    public void deleteUser(@RequestBody UserEntity userEntity) {
        userService.deleteUser(userEntity);
    }

    /**
     * @Author fgs
     * @Description 修改用户信息
     * @Date 17:45 2020/12/1
     **/
    @RequestMapping(value = "/updateUser", produces = "application/json")
    public void updateUser(@RequestBody UserEntity userEntity) {
        userService.updateUser(userEntity);
    }

    /**
     * @Author fgs
     * @Description 用户绑定接口
     * @Date 17:45 2020/12/1
     **/
    @RequestMapping(value = "/userBindIntfc", produces = "application/json")
    public void userBindIntfc(@RequestBody UserIntfcEntity userIntfcEntity) {
        userService.userBindIntfc(userIntfcEntity);
    }

}
