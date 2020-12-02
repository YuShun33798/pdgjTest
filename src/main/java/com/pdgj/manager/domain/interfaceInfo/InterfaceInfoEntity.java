package com.pdgj.manager.domain.interfaceInfo;

import com.pdgj.manager.controller.basic.BasicEntity;
import lombok.Data;

/**
 * @Author fgs
 * @Date 2020/12/1 15:40
 * @Version 1.0
 * @Description
 **/
@Data
public class InterfaceInfoEntity extends BasicEntity {
    /*主键*/
    private String id;
    /*接口名称*/
    private String name;
    /*接口标识*/
    private String flag;
    /*接口描述*/
    private String description;
    /*状态*/
    private String status;
    /*项目头*/
    private String pjtHead;
    /*Url地址*/
    private String intfcUrl;
    /*请求类型*/
    private String type;
    /*创建人*/
    private String createBy;
    /*创建时间*/
    private String createTime;
    /*修改人*/
    private String updateBy;
    /*修改时间*/
    private String updateTime;
    /*备注*/
    private String remark;
}
