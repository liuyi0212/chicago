package com.medishare.chicago.domain.finance;

import java.io.Serializable;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 上午11:02
 * @descripttion: com.medishare.chicago.domain.finance
 */
public class CardInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 银行账号
     */
    protected String id;

    /**
     * 财务账号
     */
    protected String accountId;

    /**
     * 用户账户名字
     */
    protected String ownName;

    /**
     * 银行名
     */
    protected String bankName;

    /**
     * 卡号
     */
    protected String bankCardNo;

    /**
     * 网点
     */
    protected String bankAddr;
    /**
     * 1无效， 0 正常
     */
    protected String disabled;

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

    public String getBankAddr() {
        return bankAddr;
    }

    public void setBankAddr(String bankAddr) {
        this.bankAddr = bankAddr;
    }

}
