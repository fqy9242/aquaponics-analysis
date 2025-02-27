package com.aquaponics.server.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 * @author qht
 * @param <T>
 */
@Data
public class ResultVO<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private T data; //数据

    public static <T> ResultVO<T> succeed() {
        ResultVO<T> result = new ResultVO<T>();
        result.code = 200;
        result.msg = "success";
        return result;
    }

    public static <T> ResultVO<T> succeed(T object) {
        ResultVO<T> result = new ResultVO<T>();
        result.data = object;
        result.code = 200;
        return result;
    }

    public static <T> ResultVO error(String msg) {
        ResultVO result = new ResultVO();
        result.msg = msg;
        result.code = 400;
        return result;
    }


}
