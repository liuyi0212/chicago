package com.medishare.chicago.domain.activity;

import java.util.Date;

/**
 * 医生活跃汇总信息
 * 
 * @author laurence
 *
 */
public class DoctorActivity extends Activity {

	private static final long serialVersionUID = 1L;

	/**
	 * 医生Id
	 */
	protected String doctorId;

	/**
	 * 签约人数
	 */
	protected Integer countContracts;

	/**
	 * 已服务图文咨询
	 */
	protected Integer countServedText;

	/**
	 * 已服务电话问诊
	 */
	protected Integer countServedPhone;

	/**
	 * 已服务上门
	 */
	protected Integer countServedOnCall;

	/**
	 * 待图文咨询
	 */
	protected Integer countPendingText;

	/**
	 * 待电话问诊
	 */
	protected Integer countPendingPhone;

	/**
	 * 待上门服务
	 */
	protected Integer countPendingOnCall;

	/**
	 * 星级评定
	 */
	protected Float rate;
	/**
	 * 接诊开始时间
	 */
	protected Date inserviceStart;
	/**
	 * 其他服务中
	 * @return
	 */
	protected Integer countPendingOther;
	/**
	 * 其他服务
	 */
	protected Integer countServedOther;
	

	public Integer getCountPendingOther() {
		return countPendingOther;
	}

	public void setCountPendingOther(Integer countPendingOther) {
		this.countPendingOther = countPendingOther;
	}

	public Integer getCountServedOther() {
		return countServedOther;
	}

	public void setCountServedOther(Integer countServedOther) {
		this.countServedOther = countServedOther;
	}

	public Date getInserviceStart() {
		return inserviceStart;
	}

	public void setInserviceStart(Date inserviceStart) {
		this.inserviceStart = inserviceStart;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getCountContracts() {
		return countContracts;
	}

	public void setCountContracts(Integer countContracts) {
		this.countContracts = countContracts;
	}

	public Integer getCountServedText() {
		return countServedText;
	}

	public void setCountServedText(Integer countServedText) {
		this.countServedText = countServedText;
	}

	public Integer getCountServedPhone() {
		return countServedPhone;
	}

	public void setCountServedPhone(Integer countServedPhone) {
		this.countServedPhone = countServedPhone;
	}

	public Integer getCountServedOnCall() {
		return countServedOnCall;
	}

	public void setCountServedOnCall(Integer countServedOnCall) {
		this.countServedOnCall = countServedOnCall;
	}

	public Integer getCountPendingText() {
		return countPendingText;
	}

	public void setCountPendingText(Integer countPendingText) {
		this.countPendingText = countPendingText;
	}

	public Integer getCountPendingPhone() {
		return countPendingPhone;
	}

	public void setCountPendingPhone(Integer countPendingPhone) {
		this.countPendingPhone = countPendingPhone;
	}

	public Integer getCountPendingOnCall() {
		return countPendingOnCall;
	}

	public void setCountPendingOnCall(Integer countPendingOnCall) {
		this.countPendingOnCall = countPendingOnCall;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

}
