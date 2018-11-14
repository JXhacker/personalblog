package com.wanzhiwen.blog.commons;

/**
 * @author wanzhiwen
 * @time 2018/11/14
 */
public class Response {
    private int status;//状态码1表示正常返回 0表示异常请求
    private String msg;//附加说明
    private Object body;//返回主体

    public Response() {
    }

    public Response(int status, String msg, Object body) {
        this.status = status;
        this.msg = msg;
        this.body = body;
    }

    public Response(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
