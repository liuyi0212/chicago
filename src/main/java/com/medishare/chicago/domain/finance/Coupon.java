package com.medishare.chicago.domain.finance;

import com.medishare.chicago.domain.Money;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 上午11:06
 * @descripttion: com.medishare.chicago.domain.finance
 */
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    protected String id;

    /**
     * 货币价值
     */
    protected Money amt;

    /**
     * 折扣价值
     */
    protected double discount;

    /**
     * 归财务账号所有
     */
    protected String accountId;

    /**
     * 起始时间
     */
    protected Date fromDate;

    /**
     * 截止有效期
     */
    protected Date utilDate;

    /**
     * 红包标题
     */
    protected String title;

    /**
     * 备注
     */
    protected String memo;

    /**
     * 生成日期
     */
    protected Date created;

    /**
     * 最后更新日期
     */
    protected Date updated;

    /**
     * 是否完成抵用
     */
    protected Boolean isDeducted;

    /**
     * 抵用对应的订单
     */
    protected String abstractId;

    /**
     * 使用状态(已创建，锁定，已使用)
     */
    protected String status;

    /**
     * 是否关闭
     */
    protected Boolean disabled;

    /**
     * actId
     * @return
     */
    protected Integer actId;
    /**
     * 0 真实  1测试
     */
    protected String testing;
    /**
     * 审核表的id
     */
    protected String couponCheckId;

    /**
     * 优惠券来源
     */
    protected String source;
    /**
     * 0 固定模式 1 浮动模式
     */
    protected String pattern;
    /**
     * 0 立减 1 满减 2满折
     */
    protected String type;
    /**
     * 满减 设置的值
     */
    protected double threshold;
    /**
     * 0 优惠订单金额 1 优惠实付金额
     */
    protected String userType;
    /**
     * 服务包的ids,用逗号","分隔
     */
    protected String globalIds;
    /**
     * 服务项的ids,用逗号","分隔
     */
    protected String categoryIds;

    protected String templateId;


    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getSource() {
        return source;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getGlobalIds() {
        return globalIds;
    }

    public void setGlobalIds(String globalIds) {
        this.globalIds = globalIds;
    }

    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTesting() {
        return testing;
    }

    public void setTesting(String testing) {
        this.testing = testing;
    }

    public String getCouponCheckId() {
        return couponCheckId;
    }

    public void setCouponCheckId(String couponCheckId) {
        this.couponCheckId = couponCheckId;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public Money getAmt() {
        return amt;
    }

    public void setAmt(Money amt) {
        this.amt = amt;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getUtilDate() {
        return utilDate;
    }

    public void setUtilDate(Date utilDate) {
        this.utilDate = utilDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsDeducted() {
        return isDeducted;
    }

    public void setIsDeducted(Boolean isDeducted) {
        this.isDeducted = isDeducted;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractId() {
        return abstractId;
    }

    public void setAbstractId(String abstractId) {
        this.abstractId = abstractId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
