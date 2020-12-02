package com.pdgj.manager.interceptor;

import com.pdgj.manager.domain.ResultCode;
import com.pdgj.manager.domain.ResultJson;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 类描述：认证拦截器
 * 类名称：com.mrrck.server.subscribe.api.interceptor.AuthenticationInterceptor
 * 创建人：yus
 * 创建时间：2020-11-22 14:51:25
 *
 * @version V1.0
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    static final String CHECK_USER_NAME = "userName";//用户名
    static final String CHECK_PASSWORD = "password";//密码


    /**
     * 在执行目标方法之前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //获取请求方式和访问路径
        String method = request.getMethod();
        String requestUrl = request.getRequestURI();

        String userName = request.getHeader(CHECK_USER_NAME);
        String password = request.getHeader(CHECK_PASSWORD);
        //根据用户名密码获取用户接口权限
        System.out.println(method);
        System.out.println(requestUrl);
        System.out.println(userName);
        System.out.println(password);
        //service层交互获取数据
        returnJson(response);

        return true;
    }

    /**
     * 执行目标方法之后执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
    }

    /**
     * @param map
     * @return
     * @Description: 参数 解析
     * @Title: getParamString
     */
    @SuppressWarnings("unused")
    private String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for (Entry<String, String[]> e : map.entrySet()) {
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if (value != null && value.length == 1) {
                sb.append(value[0]).append("&");
            } else {
                sb.append(Arrays.toString(value)).append("&");
            }
        }
        String returnStr = "";
        if (sb.length() > 0) {
            returnStr = sb.toString();
            return returnStr.substring(0, returnStr.length() - 1);
        }
        return returnStr;
    }


    /**
     * 在请求已经返回之后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
    }

    private void returnJson(HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String body = ResultJson.failure(ResultCode.ERROR_CODE_TWO, "xxx").toString();

        /*调用ServletOutputStream输出流flush,又return 返回值*/
        ServletOutputStream output = response.getOutputStream();
        output.write(body.getBytes());
        output.flush();
    }
}
