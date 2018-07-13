package com.medishare.chicago.domain.reservation;

import java.io.Serializable;

public class ResultReservation implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  /**
   * 接口状态码
   */
  protected int code;
  /**
   * 携带数据
   */
  protected Result data;
  
  /**
   * 异常信息
   */
  protected String errMsg;
  
  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public Result getData() {
    return data;
  }

  public void setData(Result data) {
    this.data = data;
  }

  public String getErrMsg() {
    return errMsg;
  }

  public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
  }
  
}
