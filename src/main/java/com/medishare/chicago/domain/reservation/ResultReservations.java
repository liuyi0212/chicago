package com.medishare.chicago.domain.reservation;

import java.io.Serializable;
import java.util.List;

public class ResultReservations implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  /**
   * 接口状态码
   */
  protected int code;
  /**
   * 携带数据
   */
  protected List<Result> data;
  
  /**
   * 异常信息
   */
  protected String errMsg;
  
  /**
   * @return the code
   */
  public int getCode() {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode(int code) {
    this.code = code;
  }

  /**
   * @return the data
   */
  public List<Result> getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(List<Result> data) {
    this.data = data;
  }

  public String getErrMsg() {
    return errMsg;
  }

  public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
  }
  
}
