package com.medishare.chicago.domain.finance;

import com.medishare.chicago.domain.Money;
import com.medishare.chicago.util.AccountUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 上午11:01
 * @descripttion: com.medishare.chicago.domain.finance
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 财务账号ID
     */
    protected String id;

    /**
     * 对应的用户账号类型
     */
    protected String userTypeClass;

    /**
     * 对应的用户账号ID
     */
    protected String userTypeId;

    /**
     * 对应的用户账号名字
     */
    protected String name;

    /**
     * 备注
     */
    protected String memo;

    /**
     * 支付笔数
     */
    protected int countPaid;

    /**
     * 收入笔数
     */
    protected int countIncome;

    /**
     * 总支出
     */
    protected Money paid;

    /**
     * 总收入
     */
    protected Money income;

    /**
     * 余额
     */
    protected Money balance;

    /**
     * 注册日期
     */
    protected Date created;

    /**
     * 更新日期
     */
    protected Date updated;

    /**
     * 银行账号
     */
    protected List<CardInfo> bankAccount;

    /**
     * 是否停用
     */
    protected boolean disabled;

    public Object getUserAccount() {
        return AccountUtils.getUserAccount(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserTypeClass() {
        return userTypeClass;
    }

    public void setUserTypeClass(String userTypeClass) {
        this.userTypeClass = userTypeClass;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
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

    public int getCountPaid() {
        return countPaid;
    }

    public void setCountPaid(int countPaid) {
        this.countPaid = countPaid;
    }

    public int getCountIncome() {
        return countIncome;
    }

    public void setCountIncome(int countIncome) {
        this.countIncome = countIncome;
    }

    public Money getPaid() {
        return paid;
    }

    public void setPaid(Money paid) {
        this.paid = paid;
    }

    public Money getIncome() {
        return income;
    }

    public void setIncome(Money income) {
        this.income = income;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public List<CardInfo> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<CardInfo> bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}