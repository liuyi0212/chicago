package com.medishare.chicago.api;

import java.util.List;

public class ScheduleDTO {
  
    /**
     * 医生Id
     */
    private String doctorId;
    
    /**
     * 医生工号
     */
    private String doctorJobNumber;
  
	/**
	 * 医生名称
	 */
	private String realname;
	
	/**
     * 医生身份证号
     */
    private String doctorIdCard;
	
	/**
	 * 科室名称
	 */
	private String titleType;
	/**
	 * 职称
	 */
	private String jobTitle;
	/**
	 * 擅长
	 */
	private String beGoodAt;
	
	/**
	 * 头像
	 */
	private String portrait;
	
	/**
     * 号源信息
     */
	private List<SourceDTO> sources;

  /**
   * @return the jobTitle
   */
  public String getJobTitle() {
    return jobTitle;
  }

  /**
   * @param jobTitle the jobTitle to set
   */
  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  /**
   * @return the beGoodAt
   */
  public String getBeGoodAt() {
    return beGoodAt;
  }

  /**
   * @param beGoodAt the beGoodAt to set
   */
  public void setBeGoodAt(String beGoodAt) {
    this.beGoodAt = beGoodAt;
  }

  /**
   * @return the sources
   */
  public List<SourceDTO> getSources() {
    return sources;
  }

  /**
   * @param sources the sources to set
   */
  public void setSources(List<SourceDTO> sources) {
    this.sources = sources;
  }

  /**
   * @return the realname
   */
  public String getRealname() {
    return realname;
  }

  /**
   * @param realname the realname to set
   */
  public void setRealname(String realname) {
    this.realname = realname;
  }

  /**
   * @return the titleType
   */
  public String getTitleType() {
    return titleType;
  }

  /**
   * @param titleType the titleType to set
   */
  public void setTitleType(String titleType) {
    this.titleType = titleType;
  }

  /**
   * @return the portrait
   */
  public String getPortrait() {
    return portrait;
  }

  /**
   * @param portrait the portrait to set
   */
  public void setPortrait(String portrait) {
    this.portrait = portrait;
  }

  /**
   * @return the doctorId
   */
  public String getDoctorId() {
    return doctorId;
  }

  /**
   * @param doctorId the doctorId to set
   */
  public void setDoctorId(String doctorId) {
    this.doctorId = doctorId;
  }

  public String getDoctorIdCard() {
    return doctorIdCard;
  }

  public void setDoctorIdCard(String doctorIdCard) {
    this.doctorIdCard = doctorIdCard;
  }

  public String getDoctorJobNumber() {
    return doctorJobNumber;
  }

  public void setDoctorJobNumber(String doctorJobNumber) {
    this.doctorJobNumber = doctorJobNumber;
  }

}
