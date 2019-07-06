package cn.edu.nju.notebook.constant;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.function.Supplier;

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
    this.data = null;
  }

  public SimpleResponse(int code, Object data) {
    this.code = code;
    this.data = data;
  }

  public SimpleResponse(int code, Object data, String exception){
    this.code = code;
    this.data = data;
    this.exception = exception;//其他的异常部分
  }

  public SimpleResponse(int code) {
    this.code = code;
  }

  public static SimpleResponse exception(Exception exception) {
    exception.printStackTrace();
    return new SimpleResponse(ResponseCode.CATCH_EXCEPTION, exception.getMessage());
  }

  public static SimpleResponse error(Object data) {
    return new SimpleResponse(ResponseCode.Error, data);
  }

  public static SimpleResponse ok(Object data) {
    return new SimpleResponse(ResponseCode.OK, data);
  }

  /**
   * @return if data==null return -3
   */
  public static SimpleResponse checkNull(Object data) {
    if (data == null) {
      return new SimpleResponse(ResponseCode.RESULT_IS_NULL, null);
    } else {
      return ok(data);
    }
  }

  public static SimpleResponse checkBoolean(boolean result) {
    return new SimpleResponse(result);
  }

  public static SimpleResponse ifTrue(boolean result, Supplier<?> data) {
    if (result) {
      return ok(data.get());
    }
    return new SimpleResponse(false);
  }

  public static SimpleResponse checkForbidden(boolean result) {
    if (result == true) {
      return SimpleResponse.ok(null);
    } else {
      return new SimpleResponse(403);
    }
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }


  @JsonIgnore
  //在序列化的时候忽略
  public String getException() {
    return exception;
  }

  public void setException(String exception) {
    this.exception = exception;
  }


}
