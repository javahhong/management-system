package org.example.model;

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
}
