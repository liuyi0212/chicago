package com.medishare.chicago.domain.activity;

import java.io.Serializable;

public class Activity implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 在线时间
   */
  protected long onlineSeconds;

  public long getOnlineSeconds() {
    return onlineSeconds;
  }

  public void setOnlineSeconds(long onlineSeconds) {
    this.onlineSeconds = onlineSeconds;
  }


}
