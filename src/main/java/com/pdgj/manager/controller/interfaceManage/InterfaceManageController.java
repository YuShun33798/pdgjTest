package com.pdgj.manager.controller.interfaceManage;

import com.github.pagehelper.PageInfo;
import com.pdgj.manager.domain.ResultJson;
import com.pdgj.manager.domain.interfaceInfo.InterfaceInfoEntity;
import com.pdgj.manager.service.interfaceManage.InterfaceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fgs
 * @Date 2020/12/1 15:44
 * @Version 1.0
 * @Description
 **/
@RestController
@Api(description = "接口信息管理")
@RequestMapping("/api/interfaceManage")
public class InterfaceManageController {

    @Autowired
    private InterfaceService interfaceService;

    /**
     * @Author fgs
     * @Description 获取所有接口信息
     * @Date 16:00 2020/12/1
     **/
    @RequestMapping(value = "/queryIntfcPageList", produces = "application/json")
    public ResultJson queryIntfcPageList(@RequestBody InterfaceInfoEntity interfaceInfoEntity) {
        PageInfo<InterfaceInfoEntity> pageInfo = interfaceService.queryIntfcPageList(interfaceInfoEntity);
        return ResultJson.ok(pageInfo);
    }

    /**
     * @Author fgs
     * @Description 新增接口信息
     * @Date 16:00 2020/12/1
     **/
    @RequestMapping(value = "/saveIntfc", produces = "application/json")
    public void saveIntfc(@RequestBody InterfaceInfoEntity interfaceInfoEntity) {
        interfaceService.saveIntfc(interfaceInfoEntity);
    }

    /**
     * @Author fgs
     * @Description 删除接口信息
     * @Date 16:00 2020/12/1
     **/
    @RequestMapping(value = "/deleteIntfc", produces = "application/json")
    public void deleteIntfc(@RequestBody InterfaceInfoEntity interfaceInfoEntity) {
        interfaceService.deleteIntfc(interfaceInfoEntity);
    }

    /**
     * @Author fgs
     * @Description 修改接口信息
     * @Date 17:45 2020/12/1
     **/
    @RequestMapping(value = "/updateIntfc", produces = "application/json")
    public void updateIntfc(@RequestBody InterfaceInfoEntity interfaceInfoEntity) {
        interfaceService.updateIntfc(interfaceInfoEntity);
    }

}
