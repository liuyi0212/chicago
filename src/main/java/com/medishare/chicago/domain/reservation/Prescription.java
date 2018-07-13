package com.medishare.chicago.domain.reservation;

import java.io.Serializable;
import java.util.List;

//处方
public class Prescription implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  // 处方描述
  protected List<Description> descriptions;
  // 处方医生
  protected String doctorName;
  // 处方时间
  protected String prescriptionTime;
  
  public Prescription() {
  }

  /**
   * @return the description
   */
  public List<Description> getDescriptions() {
    return descriptions;
  }

  /**
   * @param description the description to set
   */
  public void setDescriptions(List<Description> descriptions) {
    this.descriptions = descriptions;
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

  public String getPrescriptionTime() {
    return prescriptionTime;
  }

  public void setPrescriptionTime(String prescriptionTime) {
    this.prescriptionTime = prescriptionTime;
  }
}