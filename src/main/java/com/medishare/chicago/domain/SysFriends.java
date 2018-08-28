package com.medishare.chicago.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: liuy
 * @date: 2018/8/2
 * @time: 上午9:50
 * @descripttion: com.medishare.chicago.domain
 */
public class SysFriends  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String from;

    private String fromId;

    private String fromRealname;

    private String fromUserType;

    private String fromPhone;

    private String fromPinyin;

    private String fromPortrait;

    private String to;

    private String toId;

    private String toRealname;

    private String toUserType;

    private String toPhone;

    private String toPinyin;

    /**
     * 接收人拼音首字母
     */
    private String toInitials;

    private String toPortrait;

    private Date created;

    private Date updated;

    /**
     * 关系 申请apply 好友on 毁坏break
     */
    private String relationShip;

    private String tab;

    /**
     * 申请途径
     */
    private String applyWay;

    /**
     * 判断此申请记录是申请人还是接收人
     * from
     * to
     */
    private String fromTo;

    /**
     * 临时字段
     */
    private int relationShipOn;
    private int relationShipBreak;
    private int relationShipApply;
    private int relationShipTimeout;
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public String getFromPinyin() {
        return fromPinyin;
    }

    public void setFromPinyin(String fromPinyin) {
        this.fromPinyin = fromPinyin;
    }

    public String getApplyWay() {
        return applyWay;
    }

    public void setApplyWay(String applyWay) {
        this.applyWay = applyWay;
    }

    public String getFromUserType() {
        return fromUserType;
    }

    public void setFromUserType(String fromUserType) {
        this.fromUserType = fromUserType;
    }

    public String getToUserType() {
        return toUserType;
    }

    public void setToUserType(String toUserType) {
        this.toUserType = toUserType;
    }

    public String getFromPhone() {
        return fromPhone;
    }

    public void setFromPhone(String fromPhone) {
        this.fromPhone = fromPhone;
    }

    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    public int getRelationShipTimeout() {
        return relationShipTimeout;
    }

    public void setRelationShipTimeout(int relationShipTimeout) {
        this.relationShipTimeout = relationShipTimeout;
    }

    public int getRelationShipOn() {
        return relationShipOn;
    }

    public void setRelationShipOn(int relationShipOn) {
        this.relationShipOn = relationShipOn;
    }

    public int getRelationShipBreak() {
        return relationShipBreak;
    }

    public void setRelationShipBreak(int relationShipBreak) {
        this.relationShipBreak = relationShipBreak;
    }

    public int getRelationShipApply() {
        return relationShipApply;
    }

    public void setRelationShipApply(int relationShipApply) {
        this.relationShipApply = relationShipApply;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from == null ? null : from.trim();
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }

    public String getFromRealname() {
        return fromRealname;
    }

    public void setFromRealname(String fromRealname) {
        this.fromRealname = fromRealname == null ? null : fromRealname.trim();
    }

    public String getFromPortrait() {
        return fromPortrait;
    }

    public void setFromPortrait(String fromPortrait) {
        this.fromPortrait = fromPortrait == null ? null : fromPortrait.trim();
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to == null ? null : to.trim();
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }

    public String getToRealname() {
        return toRealname;
    }

    public void setToRealname(String toRealname) {
        this.toRealname = toRealname == null ? null : toRealname.trim();
    }

    public String getToPinyin() {
        return toPinyin;
    }

    public void setToPinyin(String toPinyin) {
        this.toPinyin = toPinyin == null ? null : toPinyin.trim();
    }

    public String getToInitials() {
        return toInitials;
    }

    public void setToInitials(String toInitials) {
        this.toInitials = toInitials;
    }

    public String getToPortrait() {
        return toPortrait;
    }

    public void setToPortrait(String toPortrait) {
        this.toPortrait = toPortrait == null ? null : toPortrait.trim();
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

    public String getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(String relationShip) {
        this.relationShip = relationShip == null ? null : relationShip.trim();
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab == null ? null : tab.trim();
    }
}

