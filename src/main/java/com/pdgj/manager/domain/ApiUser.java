package com.pdgj.manager.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author : hy
 */
@Data
@Builder
public class ApiUser {
    private Integer id;
    private String appkey;
    private String appsecret;
    private String apiId;
    private String enable;
    private String createTime;
    private String updateTime;
}
