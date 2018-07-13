package com.medishare.chicago.domain.reservation;

import java.io.Serializable;

//处方详情
public class Description implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  // 药物名称
  protected String drugName;
  // 药物数量
  protected String amount;
  // 药物规格
  protected String specification;
  // 药物用法
  protected String usage;
  // 药物时长
  protected String duration;
  
  public Description() {
  }
  
  /**
   * @return the drugName
   */
  public String getDrugName() {
    return drugName;
  }
  /**
   * @param drugName the drugName to set
   */
  public void setDrugName(String drugName) {
    this.drugName = drugName;
  }
  /**
   * @return the amount
   */
  public String getAmount() {
    return amount;
  }
  /**
   * @param amount the amount to set
   */
  public void setAmount(String amount) {
    this.amount = amount;
  }
  /**
   * @return the specification
   */
  public String getSpecification() {
    return specification;
  }
  /**
   * @param specification the specification to set
   */
  public void setSpecification(String specification) {
    this.specification = specification;
  }
  /**
   * @return the usage
   */
  public String getUsage() {
    return usage;
  }
  /**
   * @param usage the usage to set
   */
  public void setUsage(String usage) {
    this.usage = usage;
  }
  /**
   * @return the duration
   */
  public String getDuration() {
    return duration;
  }
  /**
   * @param duration the duration to set
   */
  public void setDuration(String duration) {
    this.duration = duration;
  }
}
