package com.pdgj.manager.service.interfaceManage;


import com.github.pagehelper.PageInfo;
import com.pdgj.manager.domain.interfaceInfo.InterfaceInfoEntity;

/**
 * @Author fgs
 * @Description
 * @Date 15:49 2020/12/1
 **/
public interface InterfaceService {

    /*获取所有接口信息*/
    PageInfo<InterfaceInfoEntity> queryIntfcPageList(InterfaceInfoEntity interfaceInfoEntity);

    /*新增接口信息*/
    void saveIntfc(InterfaceInfoEntity interfaceInfoEntity);

    /*删除接口信息*/
    void deleteIntfc(InterfaceInfoEntity interfaceInfoEntity);

    /*修改接口信息*/
    void updateIntfc(InterfaceInfoEntity interfaceInfoEntity);
}
