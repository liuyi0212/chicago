package com.medishare.chicago.domain.order;

import com.medishare.chicago.domain.Money;
import com.medishare.chicago.domain.finance.Account;
import com.medishare.chicago.domain.finance.Payment;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 上午11:00
 * @descripttion: com.medishare.chicago.domain.order
 */
public abstract class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单据ID
     */
    protected String id;

    /**
     * 甲方Id
     */
    protected String ownerId;

    /**
     * 甲方名字
     */
    protected String ownerName;

    /**
     * 甲方类型
     */
    protected String ownerType;

    /**
     * 甲方
     */
    protected Account owner;

    /**
     * 乙方Id
     */
    protected String partyBId;

    /**
     * 乙方名字
     */
    protected String partyBName;

    /**
     * 乙方类型
     */
    protected String partyBType;

    /**
     * 乙方
     */
    protected Account partyB;

    /**
     * 支付单Id
     */
    protected String paymentId;

    /**
     * 账单
     */
    protected Payment bill;

    /**
     * 备注
     */
    protected List<String> memo;

    /**
     * 服务形式命名
     */
    protected String title;

    /**
     * 描述
     */
    protected String description;

    /**
     * 订单生成时间
     */
    protected Date created;

    /**
     * 最后更新
     */
    protected Date updated;

    /**
     * 是否关闭
     */
    protected boolean disabled;

    /**
     * 价格
     */
    protected Money price;

    /**
     * 订单流程状态
     */
    protected String status;

    /**
     * 合同ID
     */
    protected String agreementId;

    /**
     * 提醒时间
     */
    protected Date alertAt;

    /**
     * 双向回拨标识Id
     */
    protected String callId;
    /**
     * 是否查看
     */
    protected String readState;
    /**
     * 用户家人id（老年服务包患者id）
     */
    protected String patientFamilyId;

    /**
     * 用户真实姓名
     */
    protected String originName;
    /**
     * 医生收益
     */
    protected Money earnings;
    /**
     * 平台收益
     */
    protected Money platformEarnings;
    /**
     * 病情描述语音列表
     */
    protected List<String> descVoiceList;

    /**
     * 被服务患者ID
     */
    protected String servedUserId;
    /**
     * 被服务患者姓名
     */
    protected String servedUserName;

    /**
     * 是否为冲账订单.
     * @return
     */
    protected boolean isRepairer;


    public boolean isRepairer() {
        return isRepairer;
    }

    public void setRepairer(boolean repairer) {
        isRepairer = repairer;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    /**
     * 单据类型
     *
     * @return
     */
    abstract public String getInvoiceTypeName();

    /**
     * 甲方类型
     *
     * @return
     */
    abstract public Class getOwnerTypeClass();

    /**
     * 乙方类型
     *
     * @return
     */
    abstract public Class getPartyBTypeClass();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public Payment getBill() {
        return bill;
    }

    public void setBill(Payment bill) {
        this.bill = bill;
    }

    public List<String> getMemo() {
        return memo;
    }

    public void setMemo(List<String> memo) {
        this.memo = memo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Account getPartyB() {
        return partyB;
    }

    public void setPartyB(Account partyB) {
        this.partyB = partyB;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getPartyBId() {
        return partyBId;
    }

    public void setPartyBId(String partyBId) {
        this.partyBId = partyBId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public void setPartyBType(String partyBType) {
        this.partyBType = partyBType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPartyBName() {
        return partyBName;
    }

    public void setPartyBName(String partyBName) {
        this.partyBName = partyBName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public String getPartyBType() {
        return partyBType;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public Date getAlertAt() {
        return alertAt;
    }

    public void setAlertAt(Date alertAt) {
        this.alertAt = alertAt;
    }

    public String getReadState() {
        return readState;
    }

    public void setReadState(String readState) {
        this.readState = readState;
    }

    public String getPatientFamilyId() {
        return patientFamilyId;
    }

    public void setPatientFamilyId(String patientFamilyId) {
        this.patientFamilyId = patientFamilyId;
    }

    public Money getEarnings() {
        return earnings;
    }

    public void setEarnings(Money earnings) {
        this.earnings = earnings;
    }

    public Money getPlatformEarnings() {
        return platformEarnings;
    }

    public void setPlatformEarnings(Money platformEarnings) {
        this.platformEarnings = platformEarnings;
    }

    public List<String> getDescVoiceList() {
        return descVoiceList;
    }

    public void setDescVoiceList(List<String> descVoiceList) {
        this.descVoiceList = descVoiceList;
    }

    public String getServedUserId() {
        return servedUserId;
    }

    public void setServedUserId(String servedUserId) {
        this.servedUserId = servedUserId;
    }

    public String getServedUserName() {
        return servedUserName;
    }

    public void setServedUserName(String servedUserName) {
        this.servedUserName = servedUserName;
    }
}
