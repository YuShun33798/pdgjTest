package com.pdgj.manager.service;


import com.pdgj.manager.domain.ApiInfo;
import com.pdgj.manager.domain.auth.ResponseUserToken;
import com.pdgj.manager.domain.auth.UserDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: JoeTao
 * createAt: 2018/9/17
 */
public interface ApiInfoService {
    List<ApiInfo> findByApiInfo(ApiInfo apiInfo);

    int insertApiInfo(ApiInfo apiInfo);

    int deleteApiInfoById(Integer apiId);

    int updateApiInfoById(ApiInfo apiInfo);
}
