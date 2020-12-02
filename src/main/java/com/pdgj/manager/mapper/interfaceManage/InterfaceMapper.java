package com.pdgj.manager.mapper.interfaceManage;

import com.pdgj.manager.domain.interfaceInfo.InterfaceInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author fgs
 * @Description 
 * @Date 15:50 2020/12/1
 **/
@Repository
public interface InterfaceMapper {

    /*获取接口分页列表*/
    List<InterfaceInfoEntity> queryIntfcPageList(InterfaceInfoEntity interfaceInfoEntity);

    /*新增接口信息*/
    void saveIntfc(InterfaceInfoEntity interfaceInfoEntity);

    /*删除接口信息*/
    void deleteIntfc(InterfaceInfoEntity interfaceInfoEntity);

    /*修改接口信息*/
    void updateIntfc(InterfaceInfoEntity interfaceInfoEntity);
}
