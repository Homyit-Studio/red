package com.example.redslogan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private Integer code;
    private String message;
    private Object data;
    private Boolean status;

    public static Result success(){
        Result result = new Result();
        result.setCode(200);
        result.setStatus(true);
        return result;
    }

    public static Result success(String message,Boolean status){
        Result result = new Result();
        result.setCode(200);
        result.setMessage(message);
        result.setStatus(status);
        return result;
    }


    //返回状态码200和相关信息
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(200);
        result.setData(data);
        result.setStatus(true);
        return result;
    }

    //返回自定定义的错误状态码，和相关信息
    public static Result fail(Integer code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setStatus(false);
        return result;
    }

    public static Result fail( String message){
        Result result = new Result();
        result.setCode(664);
        result.setMessage(message);
        result.setStatus(false);
        return result;
    }

    public static Result fail( Object data){
        Result result = new Result();
        result.setCode(664);
        result.setData(data);
        result.setStatus(false);
        return result;
    }

    public Result(Object data) {
        this(200,null,data,null);
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = message;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public static Result ok(Object data) {
        return new Result(200, "成功", data,null);
    }

    public static Result ok() {
        return new Result(200, "成功", null,null);
    }
    public static Result error(String msg){
        return new Result(500, msg, null,null);
    }

    public static Result error(String msg,Object data){
        return new Result(500, msg, data,null);
    }

    public static Result error(Integer code,String msg){
        return new Result(code, msg, null,null);
    }


}

