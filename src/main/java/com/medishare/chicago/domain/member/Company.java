package com.medishare.chicago.domain.member;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 上午11:04
 * @descripttion: com.medishare.chicago.domain.member
 */
public class Company extends Member {

    private static final long serialVersionUID = 1L;

    protected String memo;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
