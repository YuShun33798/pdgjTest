package com.pdgj.manager.domain.interfaceInfo;

import com.pdgj.manager.controller.basic.BasicEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author fgs
 * @Date 2020/12/1 15:40
 * @Version 1.0
 * @Description
 **/
@Data
@ApiModel(value = "接口实体Bean")
public class InterfaceInfoEntity extends BasicEntity {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "接口名称")
    private String name;
    @ApiModelProperty(value = "接口标识")
    private String flag;
    @ApiModelProperty(value = "接口描述")
    private String description;
    @ApiModelProperty(value = "状态")
    private String status;
    @ApiModelProperty(value = "项目头")
    private String pjtHead;
    @ApiModelProperty(value = "Url地址")
    private String intfcUrl;
    @ApiModelProperty(value = "请求类型")
    private String type;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "修改人")
    private String updateBy;
    @ApiModelProperty(value = "修改时间")
    private String updateTime;
    @ApiModelProperty(value = "备注")
    private String remark;
}
