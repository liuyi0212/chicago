package com.medishare.chicago.domain.finance;

import com.medishare.chicago.domain.Money;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 上午11:06
 * @descripttion: com.medishare.chicago.domain.finance
 */
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账单号
     */
    protected String id;

    /**
     * 出款账户
     */
    protected String payerId;

    /**
     * 出款账户名
     */
    protected String payerName;

    /**
     * 入款账户
     */
    protected String beneficiaryId;

    /**
     * 入款账户名
     */
    protected String beneficiaryName;

    /**
     * 对应单号
     */
    protected String orderId;

    /**
     * 金额明细
     */
    protected Map<String, Money> cashDetail;

    /**
     * 抵用券明细
     */
    protected List<Coupon> couponDetail;

    /**
     * 总价值
     */
    protected Money amount;

    /**
     * 现金总额
     */
    protected Money cashTotal;

    /**
     * 抵用券总额
     */
    protected Money couponTotal;

    /**
     * 备注
     */
    protected List<String> memo;

    /**
     * 操作日志
     */
    protected String logging;

    /**
     * 生成时间
     */
    protected Date created;

    /**
     * 最后更新时间
     */
    protected Date updated;

    /**
     * 已支付的日期
     */
    protected Date paidDate;

    /**
     * 流水类型
     */
    protected String type;

    /**
     * 是否作废
     */
    protected boolean disabled;
    /**
     * (取现时产生的税额)
     */
    protected Money tallage;
    /**
     * 是否入账
     */
    protected String isBooked;
    /**
     * 商品id
     */
    protected String prodId;
    /**
     * 商品类型
     */
    protected String prodType;
    /**
     * 支付方式
     */
    protected String payMethod;

    public String getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(String isBooked) {
        this.isBooked = isBooked;
    }

    public Money getTallage() {
        return tallage;
    }

    public void setTallage(Money tallage) {
        this.tallage = tallage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(String beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public Map<String, Money> getCashDetail() {
        return cashDetail;
    }

    public void setCashDetail(Map<String, Money> cashDetail) {
        this.cashDetail = cashDetail;
    }

    public List<Coupon> getCouponDetail() {
        return couponDetail;
    }

    public void setCouponDetail(List<Coupon> couponDetail) {
        this.couponDetail = couponDetail;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Money getCashTotal() {
        return cashTotal;
    }

    public void setCashTotal(Money cashTotal) {
        this.cashTotal = cashTotal;
    }

    public Money getCouponTotal() {
        return couponTotal;
    }

    public void setCouponTotal(Money couponTotal) {
        this.couponTotal = couponTotal;
    }

    public List<String> getMemo() {
        return memo;
    }

    public void setMemo(List<String> memo) {
        this.memo = memo;
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

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public String getLogging() {
        return logging;
    }

    public void setLogging(String logging) {
        this.logging = logging;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

}
