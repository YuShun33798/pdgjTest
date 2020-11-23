package com.pdgj.manager.controller;

import com.pdgj.manager.domain.ApiInfo;
import com.pdgj.manager.domain.ResultCode;
import com.pdgj.manager.domain.ResultJson;
import com.pdgj.manager.domain.auth.ResponseUserToken;
import com.pdgj.manager.domain.auth.Role;
import com.pdgj.manager.domain.auth.User;
import com.pdgj.manager.domain.auth.UserDetail;
import com.pdgj.manager.mapper.ApiInfoMapper;
import com.pdgj.manager.service.ApiInfoService;
import com.pdgj.manager.service.AuthService;
import com.pdgj.manager.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author JoeTao
 * createAt: 2018/9/17
 */

@RestController
@Api(description = "接口信息管理")
@RequestMapping("/api/manager")
public class ApiInfoController {
    @Autowired
    private ApiInfoService apiInfoService;

    @RequestMapping(value = "/findByApiInfo", produces = "application/json")
    public ResultJson findByApiInfo(@RequestBody ApiInfo apiInfo) {
        List<ApiInfo> list = apiInfoService.findByApiInfo(apiInfo);
        if (list != null) {
            return ResultJson.ok(list);
        }
        return ResultJson.failure(ResultCode.SERVER_ERROR);
    }

    @RequestMapping(value = "/insertApiInfo", produces = "application/json")
    public ResultJson insertApiInfo(@RequestBody ApiInfo apiInfo) {
        if (StringUtils.isAnyBlank(apiInfo.getNameCn(), apiInfo.getNameEn())) {
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        //默认值
        // 按照一定规则生成接口编号

        // apiInfo.setApiId();
        apiInfo.setStatus(String.valueOf(1));
        apiInfo.setCreateTime(DateUtils.getDateNow());
        int result = apiInfoService.insertApiInfo(apiInfo);
        if (result > 0) {
            return ResultJson.ok();
        }
        return ResultJson.failure(ResultCode.SERVER_ERROR);
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("api_");
        str.append((int)((Math.random()*9+1)*1000));
        str.append(DateUtils.getDateNumNow());
        str.append((int)((Math.random()*9+1)*1000));
        System.out.println(str);
    }

    @RequestMapping(value = "/deleteApiInfoById", produces = "application/json")
    public ResultJson deleteApiInfoById(Integer apiId) {
        if (apiId == null) {
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        int result = apiInfoService.deleteApiInfoById(apiId);
        if (result > 0) {
            return ResultJson.ok();
        }
        return ResultJson.failure(ResultCode.SERVER_ERROR);
    }

    @RequestMapping(value = "/updateApiInfoById", produces = "application/json")
    public ResultJson updateApiInfoById(ApiInfo apiInfo) {
        if (apiInfo.getApiId() == null) {
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        List<ApiInfo> list = apiInfoService.findByApiInfo(apiInfo);
        if (list != null) {
            int result = apiInfoService.updateApiInfoById(apiInfo);
            if (result > 0) {
                return ResultJson.ok();
            }
        }
        return ResultJson.failure(ResultCode.SERVER_ERROR);
    }

}
