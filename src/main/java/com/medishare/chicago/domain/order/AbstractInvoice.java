package com.medishare.chicago.domain.order;

import com.medishare.chicago.domain.Money;
import com.medishare.chicago.domain.member.Doctor;
import com.medishare.chicago.domain.member.Patient;

import java.util.List;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 上午11:07
 * @descripttion: com.medishare.chicago.domain.order
 */
public class AbstractInvoice extends Invoice {

    private static final long serialVersionUID = 1L;

    final static String nm = "汇总订单";

    /**
     * 批次
     */
    protected String batch;

    /**
     * 所有服务单的ID
     */
    protected List<String> doctorServeIds;

    /**
     * 汇总的各种服务单
     */
    protected List<Invoice> order;

    /**
     * 退款金额
     */
    protected Double refundAmount;

    /**
     * 退款理由
     */
    protected String refundReason;

    /**
     * 自定义服务金额记录id
     */
    protected String serviceMoneyId;

    /**
     * 订单对应服务包服务包类型
     */
    protected String groupType;

    /**
     * 医生端下单服务项
     */
    protected List<String> serviceIds;

    /**
     * 是否医生下单1是0否
     */
    protected String proStatus;
    /**
     * 子服务项id
     */
    protected List<String> subAgreementIds;
    /**
     * pro下单
     * 医生服务费
     */
    protected Money serviceCharge;
    /**
     * 订单取现状态
     */
    protected Integer cashStatus;

    /**
     * gpa姓名
     */
    protected String gpaName;

    /**
     * ma姓名
     */
    protected String maName;

    public String getMaName() {
        return maName;
    }

    public void setMaName(String maName) {
        this.maName = maName;
    }

    /**
     * 备注
     */
    protected String remarks;

    /**
     * 聊天医生ID  employed_doctorId
     */
    protected String chatEmployedId;
    /**
     * 就诊人身份证号
     */
    protected String treatPeopleIdcard;
    /**
     * 就诊人地址
     */
    protected String treatPeopleAddress;
    /**
     * 就诊人电话
     */
    protected String treatPeoplePhone;

    public Integer getCashStatus() {
        return cashStatus;
    }

    public void setCashStatus(Integer cashStatus) {
        this.cashStatus = cashStatus;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    /**
     * 临时字段－> 存储患者电话号码
     */
    protected String patientPhone;

    /**
     * 订单评价状态 （0 未评价 1 已评价）
     */
    protected String evaluationStatus;
    /**
     * 疾病列表
     */
    protected List<String> diseaseList;

    /**
     * 提醒标识
     * 0 需要 1 不需要
     */
    protected String remindFlag;

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(String evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

    public List<String> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<String> serviceIds) {
        this.serviceIds = serviceIds;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    @Override
    public String getInvoiceTypeName() {
        return nm;
    }

    @Override
    public Class getOwnerTypeClass() {
        return Patient.class;
    }

    @Override
    public Class getPartyBTypeClass() {
        return Doctor.class;
    }

    public List<String> getDoctorServeIds() {
        return doctorServeIds;
    }

    public void setDoctorServeIds(List<String> doctorServeIds) {
        this.doctorServeIds = doctorServeIds;
    }

    public List<Invoice> getOrder() {
        return order;
    }

    public void setOrder(List<Invoice> order) {
        this.order = order;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getServiceMoneyId() {
        return serviceMoneyId;
    }

    public void setServiceMoneyId(String serviceMoneyId) {
        this.serviceMoneyId = serviceMoneyId;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public List<String> getSubAgreementIds() {
        return subAgreementIds;
    }

    public void setSubAgreementIds(List<String> subAgreementIds) {
        this.subAgreementIds = subAgreementIds;
    }

    public Money getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Money serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getGpaName() {
        return gpaName;
    }

    public void setGpaName(String gpaName) {
        this.gpaName = gpaName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getChatEmployedId() {
        return chatEmployedId;
    }

    public void setChatEmployedId(String chatEmployedId) {
        this.chatEmployedId = chatEmployedId;
    }

    public List<String> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<String> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public String getTreatPeopleIdcard() {
        return treatPeopleIdcard;
    }

    public void setTreatPeopleIdcard(String treatPeopleIdcard) {
        this.treatPeopleIdcard = treatPeopleIdcard;
    }

    public String getTreatPeopleAddress() {
        return treatPeopleAddress;
    }

    public void setTreatPeopleAddress(String treatPeopleAddress) {
        this.treatPeopleAddress = treatPeopleAddress;
    }

    public String getRemindFlag() {
        return remindFlag;
    }

    public void setRemindFlag(String remindFlag) {
        this.remindFlag = remindFlag;
    }

    public String getTreatPeoplePhone() {
        return treatPeoplePhone;
    }

    public void setTreatPeoplePhone(String treatPeoplePhone) {
        this.treatPeoplePhone = treatPeoplePhone;
    }

}
