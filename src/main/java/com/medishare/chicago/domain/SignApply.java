package com.medishare.chicago.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: liuy
 * @date: 2018/8/2
 * @time: 上午9:44
 * @descripttion: com.medishare.chicago.domain
 */
public class SignApply implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;

    private String doctorId;

    private String doctorName;

    private String patientId;

    private String patientName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date patientBirthday;

    private String patientAge;

    private String patientPhone;

    private String patientMedicareCard;
    /**
     * 详细地址
     */
    private String patientAddress;
    /**
     * 申请状态 1申请中 2成功 3拒绝 4签约完成 5待支付 6支付完成
     */
    private String status;
    /**
     * 签约id
     */
    private String contractId;
    /**
     * 审批意见
     */
    private String opinion;

    private String created;

    private String updated;

    /**
     * 签约服务包自定义价格
     */
    private Money price;

    /**
     * 签约服务包ID
     */
    private String servicePack;

    /**
     * 医生团队
     */
    private String doctorTeam;

    /**
     * 医院ID
     */
    private String hospitalId;

    /**
     * 发起端-doc,pat
     */
    private String invitationFlag;

    private String operating;

    /**
     * 医生签名
     */
    private String docSignature;
    /**
     * 患者签名
     */
    private String patSignature;

    private String friend;

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getDocSignature() {
        return docSignature;
    }

    public void setDocSignature(String docSignature) {
        this.docSignature = docSignature;
    }

    public String getPatSignature() {
        return patSignature;
    }

    public void setPatSignature(String patSignature) {
        this.patSignature = patSignature;
    }

    public String getOperating() {
        return operating;
    }

    public void setOperating(String operating) {
        this.operating = operating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientMedicareCard() {
        return patientMedicareCard;
    }

    public void setPatientMedicareCard(String patientMedicareCard) {
        this.patientMedicareCard = patientMedicareCard;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Date getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(Date patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public String getServicePack() {
        return servicePack;
    }

    public void setServicePack(String servicePack) {
        this.servicePack = servicePack;
    }

    public String getDoctorTeam() {
        return doctorTeam;
    }

    public void setDoctorTeam(String doctorTeam) {
        this.doctorTeam = doctorTeam;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getInvitationFlag() {
        return invitationFlag;
    }

    public void setInvitationFlag(String invitationFlag) {
        this.invitationFlag = invitationFlag;
    }
}
