package com.pdgj.manager.controller;

import com.pdgj.manager.domain.ResultCode;
import com.pdgj.manager.domain.ResultJson;
import com.pdgj.manager.domain.auth.ResponseUserToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yushun
 * @version 1.0
 * @date 2020/11/20 10:31
 */
@RestController
@Api(description = "测试接口类")
@RequestMapping("/api/test")
public class TestController {


    @PostMapping(value = "/unCheckToken")
    @ApiOperation(value = "不校验", notes = "不校验用户token")
    public ResultJson<ResponseUserToken> login(HttpServletRequest request){
        return ResultJson.ok();
    }

    @PostMapping(value = "/checkUserNameAndPassword")
    @ApiOperation(value = "校验用户和密码", notes = "校验接口用户的权限")
    public ResultJson checkUserNameAndPassword(HttpServletRequest request){
        return ResultJson.ok();
    }

    @PostMapping(value = "/method2")
    @ApiOperation(value = "校验用户和密码2", notes = "校验接口用户的权限2")
    public ResultJson method2(HttpServletRequest request) throws Exception{
        return ResultJson.failure(ResultCode.ERROR_CODE_ONE);
//        return ResultJson.ok();
    }

    @PostMapping(value = "/method3")
    @ApiOperation(value = "校验用户和密码2", notes = "校验接口用户的权限2")
    public ResultJson method3(HttpServletRequest request) throws Exception{
        return ResultJson.ok();
    }


}
