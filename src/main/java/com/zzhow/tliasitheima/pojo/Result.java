package com.zzhow.tliasitheima.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @JSONField(ordinal = 1)
    private Integer status;
    @JSONField(ordinal = 2)
    private String msg;
    @JSONField(ordinal = 3)
    private Object data;

    public static Result success() {
        return new Result(200, "success", null);
    }

    public static Result success(Object data) {
        return new Result(200, "success", data);
    }

    public static Result success(String msg, Object data) {
        return new Result(200, msg, data);
    }

    public static Result error() {
        return new Result(409, "error", null);
    }

    public static Result error(Object data) {
        return new Result(409, "error", data);
    }

    public static Result error(String msg, Object data) {
        return new Result(409, msg, data);
    }

    public static Result loginSuccessful(Object data) {
        return new Result(200, "Login successful", data);
    }

    public static Result loginFailed() {
        return new Result(401, "Login failed", null);
    }

    public static Result unauthorized() {
        return new Result(401, "Unauthorized", null);
    }

    public static Result resourceNotFound() {
        return new Result(404, "Resource Not Found", null);
    }
}
