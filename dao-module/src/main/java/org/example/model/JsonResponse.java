package org.example.model;

import lombok.Data;

/**
 * @program: my-multi-module-project
 * @author: hhong
 * @create: 2025-04-21 15:49
 **/

public class JsonResponse<T>{
    private String code;     //状态码
    private String msg;      //提示词
    private T date;          //实际数据

    //成功时的构造方法
    public JsonResponse( T date) {
        this.code = "0";
        this.msg = "成功";
        this.date = date;
    }
    //失败时的构造方法
    public JsonResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.date = null;   //失败时没有数据
    }
    //Getter 方法
    public String getCode() {return code;}
    public String getMsg() {return msg;}
    public T getDate() {return date;}
    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public static JsonResponse<String> success(){
        return new JsonResponse<>(null);}

    private static JsonResponse<String> success(String Data){
        return new JsonResponse<>(Data);
    }

    private static JsonResponse<String> fail(){
        return new JsonResponse<>("1", "失败");}
    private static JsonResponse<String>fail(String code,String msg){
        return new JsonResponse<>(code, msg);
    }


}
