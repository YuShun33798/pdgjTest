package com.pdgj.manager.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author : hy
 */
@Data
@Builder
public class ApiInfo {
    /**
     * `api_id` int(11) NOT NULL COMMENT 'id主键(接口编号)'
     */
    private String apiId;
    /**
     * `name_en` varchar(255) DEFAULT NULL COMMENT '英文名'
     */
    private String nameEn;
    /**
     `name_cn` varchar(255) DEFAULT NULL COMMENT '中文名',
     */
    private String nameCn;
    /**
     * `desc` varchar(255) DEFAULT NULL COMMENT '接口描述',
     */
    private String desc;
    /**
     * `status` varchar(255) DEFAULT NULL COMMENT '使用状态(0=停用;1=使用中)',
     */
    private String status;
    /**
     * `dta_strt_tm` varchar(28) DEFAULT NULL COMMENT '线路开始时间'
     */
    private String host;
    /**
     * `dta_strt_tm` varchar(28) DEFAULT NULL COMMENT '线路开始时间'
     */
    private String reqType;
    /**
     * `dta_strt_tm` varchar(28) DEFAULT NULL COMMENT '线路开始时间'
     */
    private String reqUrl;
    /**
     * `dta_strt_tm` varchar(28) DEFAULT NULL COMMENT '线路开始时间'
     */
    private String project;
    /**
     * `dta_strt_tm` varchar(28) DEFAULT NULL COMMENT '线路开始时间'
     */
    private String projectUrl;
    /**
     * `dta_strt_tm` varchar(28) DEFAULT NULL COMMENT '线路开始时间'
     */
    private String createTime;
    /**
     * `dta_strt_tm` varchar(28) DEFAULT NULL COMMENT '线路开始时间'
     */
    private String updateTime;
}
