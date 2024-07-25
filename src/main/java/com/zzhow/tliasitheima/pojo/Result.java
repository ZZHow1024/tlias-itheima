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
    private Integer code;
    private String msg;
    private Object data;

    public static Result success() {
        return new Result(200, "success", null);
    }

    public static Result success(Object data) {
        return new Result(200, "success", data);
    }

    public static Result success(String msg) {
        return new Result(200, "success", msg);
    }

    public static Result error() {
        return new Result(500, "error", null);
    }

    public static Result error(String msg) {
        return new Result(500, "error", msg);
    }

    public static Result error(String msg, Object data) {
        return new Result(500, "error", msg);
    }
}
