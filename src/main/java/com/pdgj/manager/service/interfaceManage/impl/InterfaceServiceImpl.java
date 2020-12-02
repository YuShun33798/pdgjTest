package com.pdgj.manager.service.interfaceManage.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdgj.manager.domain.interfaceInfo.InterfaceInfoEntity;
import com.pdgj.manager.mapper.interfaceManage.InterfaceMapper;
import com.pdgj.manager.service.interfaceManage.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author: JoeTao
 * createAt: 2018/9/17
 */
@Service
public class InterfaceServiceImpl implements InterfaceService {

    @Autowired
    private InterfaceMapper interfaceMapper;

    /**
     * @Author fgs
     * @Description 获取接口分页列表
     * @Date 17:00 2020/12/1
     **/
    @Override
    public PageInfo<InterfaceInfoEntity> queryIntfcPageList(InterfaceInfoEntity interfaceInfoEntity) {
        PageHelper.startPage(interfaceInfoEntity.getPageNum(), interfaceInfoEntity.getPageSize(), true);
        List<InterfaceInfoEntity> entityList = interfaceMapper.queryIntfcPageList(interfaceInfoEntity);
        PageInfo<InterfaceInfoEntity> result = new PageInfo<>(entityList);
        result.setPageNum(result.getPageNum());
        result.setPageSize(result.getPageSize());
        result.setTotal(result.getTotal());
        result.setSize(result.getSize());
        return result;
    }

    /**
     * @Author fgs
     * @Description 新增接口信息
     * @Date 17:36 2020/12/1
     **/
    @Override
    public void saveIntfc(InterfaceInfoEntity interfaceInfoEntity) {
        interfaceInfoEntity.setId(UUID.randomUUID().toString().replaceAll("-",""));
        interfaceMapper.saveIntfc(interfaceInfoEntity);
    }

    /**
     * @Author fgs
     * @Description 删除接口信息
     * @Date 17:42 2020/12/1
     **/
    @Override
    public void deleteIntfc(InterfaceInfoEntity interfaceInfoEntity) {
        interfaceMapper.deleteIntfc(interfaceInfoEntity);
    }

    /**
     * @Author fgs
     * @Description 修改接口信息
     * @Date 17:47 2020/12/1
     **/
    @Override
    public void updateIntfc(InterfaceInfoEntity interfaceInfoEntity) {
        interfaceMapper.updateIntfc(interfaceInfoEntity);
    }
}
