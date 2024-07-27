package com.zzhow.tliasitheima.pojo;

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
    private Integer status;
    private String msg;
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
        return new Result(500, "error", null);
    }

    public static Result error(Object data) {
        return new Result(500, "error", data);
    }

    public static Result error(String msg, Object data) {
        return new Result(500, msg, data);
    }

    public static Result loginSuccessful() {
        return new Result(200, "Login successful", null);
    }

    public static Result loginFailed() {
        return new Result(401, "Login failed", null);
    }
}
