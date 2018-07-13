package com.medishare.chicago.domain.reservation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 结果
 */
public class Result implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  
  /**
   * 医院id
   */
  protected String hospitalId;
  
  /**
   * 医院名称
   */
  protected String hospitalName;
  
  /**
   * 地址
   */
  protected String address;
  
  /**
   * 科室id
   */
  protected String departmentId;
  
  /**
   * 科室名称
   */
  protected String departmentName;
  
  /**
   * 号源id
   */
  protected String sourceId;
  
  /**
   * 排班时间
   */
  protected String scheduleTime;
  
  /**
   * 身份证号 
   */
  protected String idCard;
  
  /**
   * 排班日分段 上午下午（am pm）
   */
  protected String dayPart;
  
  /**
   * 医生id
   */
  protected String doctorId;
  
  /**
   * 医生工号
   */
  protected String doctorJobNumber;
  
  /**
   * 医生姓名
   */
  protected String doctorName;
  
  /**
   * 职称
   */
  protected String jobTitle;
  
  /**
   * 擅长
   */
  protected String beGoodAt;
  
  /**
   * 头像
   */
  protected String headPortraitUrl;
  
  /**
   * 是否签约
   */
  protected String isSign;
  
  /**
   * his预约单号
   */
  protected String reservationNumber;
  
  /**
   * 状态
   */
  protected String status;
  
  /**
   * 是否需要住院
   */
  protected String isNeed;
  
  /**
   * 入院时间
   */
  protected String admissionHospitalTime;
  
  /**
   * 入院诊断
   */
  protected String admissionHospitalDiagnosis;
  
  /**
   * 出院时间
   */
  protected String leaveHospitalTime;
  
  /**
   * 出院诊断
   */
  protected String leaveHospitalDiagnosis;
  
  
  /**
   * 诊断信息
   */
  protected String diagnosis;

  /**
   * 处方信息
   */
  protected List<Prescription> prescriptions;
  
  /**
   * 预约序号
   */
  protected String reservationSerialNumber;
  
  /**
   * 就诊时间
   */
  protected String treatmentTime;
  
  /**
   * @return the hospitalId
   */
  public String getHospitalId() {
    return hospitalId;
  }

  /**
   * @param hospitalId the hospitalId to set
   */
  public void setHospitalId(String hospitalId) {
    this.hospitalId = hospitalId;
  }

  /**
   * @return the hospitalName
   */
  public String getHospitalName() {
    return hospitalName;
  }

  /**
   * @param hospitalName the hospitalName to set
   */
  public void setHospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
  }

  /**
   * @return the departmentId
   */
  public String getDepartmentId() {
    return departmentId;
  }

  /**
   * @param departmentId the departmentId to set
   */
  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  /**
   * @return the departmentName
   */
  public String getDepartmentName() {
    return departmentName;
  }

  /**
   * @param departmentName the departmentName to set
   */
  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  /**
   * @return the sourceId
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * @param sourceId the sourceId to set
   */
  public void setSourceId(String sourceId) {
    this.sourceId = sourceId;
  }

  /**
   * @return the scheduleTime
   */
  public String getScheduleTime() {
    return scheduleTime;
  }

  /**
   * @param scheduleTime the scheduleTime to set
   */
  public void setScheduleTime(String scheduleTime) {
    this.scheduleTime = scheduleTime;
  }

  /**
   * @return the idCard
   */
  public String getIdCard() {
    return idCard;
  }

  /**
   * @param idCard the idCard to set
   */
  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  /**
   * @return the dayPart
   */
  public String getDayPart() {
    return dayPart;
  }

  /**
   * @param dayPart the dayPart to set
   */
  public void setDayPart(String dayPart) {
    this.dayPart = dayPart;
  }

  /**
   * @return the doctorName
   */
  public String getDoctorName() {
    return doctorName;
  }

  /**
   * @param doctorName the doctorName to set
   */
  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }

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
   * @return the isSign
   */
  public String getIsSign() {
    return isSign;
  }

  /**
   * @param isSign the isSign to set
   */
  public void setIsSign(String isSign) {
    this.isSign = isSign;
  }

  /**
   * @return the reservationNumber
   */
  public String getReservationNumber() {
    return reservationNumber;
  }

  /**
   * @param reservationNumber the reservationNumber to set
   */
  public void setReservationNumber(String reservationNumber) {
    this.reservationNumber = reservationNumber;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * @return the admissionHospitalTime
   */
  public String getAdmissionHospitalTime() {
    return admissionHospitalTime;
  }

  /**
   * @param admissionHospitalTime the admissionHospitalTime to set
   */
  public void setAdmissionHospitalTime(String admissionHospitalTime) {
    this.admissionHospitalTime = admissionHospitalTime;
  }

  /**
   * @return the admissionHospitalDiagnosis
   */
  public String getAdmissionHospitalDiagnosis() {
    return admissionHospitalDiagnosis;
  }

  /**
   * @param admissionHospitalDiagnosis the admissionHospitalDiagnosis to set
   */
  public void setAdmissionHospitalDiagnosis(String admissionHospitalDiagnosis) {
    this.admissionHospitalDiagnosis = admissionHospitalDiagnosis;
  }

  /**
   * @return the leaveHospitalTime
   */
  public String getLeaveHospitalTime() {
    return leaveHospitalTime;
  }

  /**
   * @param leaveHospitalTime the leaveHospitalTime to set
   */
  public void setLeaveHospitalTime(String leaveHospitalTime) {
    this.leaveHospitalTime = leaveHospitalTime;
  }

  /**
   * @return the leaveHospitalDiagnosis
   */
  public String getLeaveHospitalDiagnosis() {
    return leaveHospitalDiagnosis;
  }

  /**
   * @param leaveHospitalDiagnosis the leaveHospitalDiagnosis to set
   */
  public void setLeaveHospitalDiagnosis(String leaveHospitalDiagnosis) {
    this.leaveHospitalDiagnosis = leaveHospitalDiagnosis;
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
   * @return the headPortraitUrl
   */
  public String getHeadPortraitUrl() {
    return headPortraitUrl;
  }

  /**
   * @param headPortraitUrl the headPortraitUrl to set
   */
  public void setHeadPortraitUrl(String headPortraitUrl) {
    this.headPortraitUrl = headPortraitUrl;
  }

  /**
   * @return the diagnosis
   */
  public String getDiagnosis() {
    return diagnosis;
  }

  /**
   * @param diagnosis the diagnosis to set
   */
  public void setDiagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
  }

  /**
   * @return the prescriptions
   */
  public List<Prescription> getPrescriptions() {
    return prescriptions;
  }

  /**
   * @param prescriptions the prescriptions to set
   */
  public void setPrescriptions(List<Prescription> prescriptions) {
    this.prescriptions = prescriptions;
  }

  /**
   * @return the isNeed
   */
  public String getIsNeed() {
    return isNeed;
  }

  /**
   * @param isNeed the isNeed to set
   */
  public void setIsNeed(String isNeed) {
    this.isNeed = isNeed;
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

  public String getReservationSerialNumber() {
    return reservationSerialNumber;
  }

  public void setReservationSerialNumber(String reservationSerialNumber) {
    this.reservationSerialNumber = reservationSerialNumber;
  }

  public String getTreatmentTime() {
    return treatmentTime;
  }

  public void setTreatmentTime(String treatmentTime) {
    this.treatmentTime = treatmentTime;
  }

  public String getDoctorJobNumber() {
    return doctorJobNumber;
  }

  public void setDoctorJobNumber(String doctorJobNumber) {
    this.doctorJobNumber = doctorJobNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}