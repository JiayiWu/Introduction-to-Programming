package com.example.notebook2019.constant;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SimpleResponse {

    private int code;
    private Object data;
    private transient String exception;

    public SimpleResponse() {
        this.code = ResponseCode.OK;
        this.data = "Success";
    }

    public SimpleResponse(boolean success) {
        this.code = success ? 0 : -1;
        this.data= null;
    }

    public SimpleResponse(int code) {
        this.code = code;
    }

    public SimpleResponse(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public SimpleResponse(int code, Object data, String exception) {
        this.code = code;
        this.data = data;
        this.exception = exception;
    }

    public static SimpleResponse exception(Exception e){
        e.printStackTrace();
        return new SimpleResponse(ResponseCode.CATCH_EXCEPTION,e.getMessage());
    }

    public static SimpleResponse ok(Object data){
        return new SimpleResponse(ResponseCode.OK,data);
    }

    public static SimpleResponse error(Object data){
        return new SimpleResponse(ResponseCode.Error,data);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @JsonIgnore
    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
