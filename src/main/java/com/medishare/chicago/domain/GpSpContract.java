package com.medishare.chicago.domain;

/**
 * @author: liuy
 * @date: 2018/8/2
 * @time: 下午2:07
 * @descripttion: com.medishare.chicago.domain
 */
public class GpSpContract {
    private static final long serialVersionUID = 1L;

    private String gp_id;
    private String sp_id;
    protected String status;//签约状态
    protected String contract;//签约描述

    public String getGp_id() {
        return gp_id;
    }

    public void setGp_id(String gp_id) {
        this.gp_id = gp_id;
    }

    public String getSp_id() {
        return sp_id;
    }

    public void setSp_id(String sp_id) {
        this.sp_id = sp_id;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getContract() {
        return contract;
    }
    public void setContract(String contract) {
        this.contract = contract;
    }
}
