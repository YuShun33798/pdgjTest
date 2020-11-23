package com.pdgj.manager.service;

import com.pdgj.manager.domain.ApiInfo;
import com.pdgj.manager.domain.ResultCode;
import com.pdgj.manager.domain.ResultJson;
import com.pdgj.manager.domain.auth.ResponseUserToken;
import com.pdgj.manager.domain.auth.Role;
import com.pdgj.manager.domain.auth.UserDetail;
import com.pdgj.manager.exception.CustomException;
import com.pdgj.manager.mapper.ApiInfoMapper;
import com.pdgj.manager.mapper.AuthMapper;
import com.pdgj.manager.utils.JwtUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: JoeTao
 * createAt: 2018/9/17
 */
@Service
public class ApiInfoServiceImpl implements ApiInfoService {

    @Autowired
    private ApiInfoMapper apiInfoMapper;

    @Override
    public List<ApiInfo> findByApiInfo(ApiInfo apiInfo) {
        List<ApiInfo> list = apiInfoMapper.findByApiInfo(apiInfo);
        return list;
    }

    @Override
    public int insertApiInfo(ApiInfo apiInfo) {
        int result = apiInfoMapper.insertApiInfo(apiInfo);
        return result;
    }

    @Override
    public int deleteApiInfoById(Integer apiId) {
        int result = apiInfoMapper.deleteApiInfoById(apiId);
        return result;
    }

    @Override
    public int updateApiInfoById(ApiInfo apiInfo) {
        int result = apiInfoMapper.updateApiInfoById(apiInfo);
        return result;
    }
}
