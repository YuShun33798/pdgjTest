package com.pdgj.manager.exception;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 版权所有：2017-美库网
 * 类名称：com.base.exception.ErrorConstant
 * 创建人：曙光
 * 创建时间：2017年4月6日 下午4:38:29
 *
 * @version V1.0
 */
public class ErrorConstant {
    public final static Map<Integer, String> messageMap = Maps.newHashMap();

    /**初始化状态码与文字说明
     * 后期  可以初始化 数据库字典中 ,管理平台可以管理return msg
     * */
    static {
        messageMap.put(200, "操作成功");
        messageMap.put(100, "操作失败");

        messageMap.put(400, "Bad Request");
        messageMap.put(401, "NotAuthorization");
        messageMap.put(404, "Not Found");
        messageMap.put(405, "Method Not Allowed");
        messageMap.put(406, "Not Acceptable");
        messageMap.put(500, "Internal Server Error");

        messageMap.put(1000, "[服务器]运行时异常");
        messageMap.put(1001, "[服务器]空值异常");
        messageMap.put(1002, "[服务器]数据类型转换异常");
    }

    /**
     * 错误参数
     */
    public static void throwIllegalArgsError(int code) {
        throw new ApiErrorException(code);
    }

    public static void throwIllegalArgsError(int code, Map<String, String> keys) {
        throw new ApiErrorException(code, keys);
    }


}
