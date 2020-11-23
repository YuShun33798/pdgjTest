package com.pdgj.manager.mapper;

import com.pdgj.manager.domain.ApiInfo;
import com.pdgj.manager.domain.auth.Role;
import com.pdgj.manager.domain.auth.UserDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hy
 * createAt: 2018/9/17
 */
@Repository
public interface ApiInfoMapper {
    List<ApiInfo> findByApiInfo(ApiInfo apiInfo);

    int insertApiInfo(ApiInfo apiInfo);

    int deleteApiInfoById(@Param("apiId") Integer apiId);

    int updateApiInfoById(ApiInfo apiInfo);
}
