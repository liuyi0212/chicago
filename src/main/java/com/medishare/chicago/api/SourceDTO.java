package com.medishare.chicago.api;

public class SourceDTO {

  /** 号源id */
  private String sourceId;
  /** 排班时间 */
  private Long scheduleTime;
  /** 排班日分段 上午下午（am pm ad） */
  private String dayPart;
  /** 排班日分段 上午下午 全天（am pm ad） */
  private String dayPartName;
  /** 门诊类型 */
  private String outpatientType;

  /** @return the sourceId */
  public String getSourceId() {
    return sourceId;
  }

  /** @param sourceId the sourceId to set */
  public void setSourceId(String sourceId) {
    this.sourceId = sourceId;
  }

  /** @return the scheduleTime */
  public Long getScheduleTime() {
    return scheduleTime;
  }

  /** @param scheduleTime the scheduleTime to set */
  public void setScheduleTime(Long scheduleTime) {
    this.scheduleTime = scheduleTime;
  }

  /** @return the dayPart */
  public String getDayPart() {
    return dayPart;
  }

  /** @param dayPart the dayPart to set */
  public void setDayPart(String dayPart) {
    this.dayPart = dayPart;
  }

  /** @return the outpatientType */
  public String getOutpatientType() {
    return outpatientType;
  }

  /** @param outpatientType the outpatientType to set */
  public void setOutpatientType(String outpatientType) {
    this.outpatientType = outpatientType;
  }

  public String getDayPartName() {
    return dayPartName;
  }

  public void setDayPartName(String dayPartName) {
    this.dayPartName = dayPartName;
  }


}
