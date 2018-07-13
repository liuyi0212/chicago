package com.medishare.chicago.domain.member;

import com.medishare.chicago.domain.medical.Disease;

import java.util.Date;
import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
public class Patient extends Member {

    private static final long serialVersionUID = 1L;

    /**
     * 显示名
     */
    protected String nickname;

    /**
     * 身份证(或其它证件)
     */
    protected String idCard;

    /**
     * 证件类型
     */
    protected String idType;

    /**
     * 患者关心疾病
     */
    protected List<String> focusIds;

    /**
     * 签约ID
     */
    protected String contractId;
    /**
     * 小红点（医生端标记） 1 显示小红点 2不显示小红点 临时字段（在order_contract中）
     */
    protected String reddotStatus;
    /**
     * 1gps地理位置 2 患者信息表中地理位置
     */
    protected String positionStatus;
    /**
     * 医生打标签
     */
    protected List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * 患者真实姓名（回访姓名）
     */
    protected String originName;

    /**
     * 完整地址 包含省市区街道社区和详细地址
     *
     */
    protected String fullAddress;

    /**
     * 医保卡号
     */
    protected String medicareCard;
    /**
     * 身份证上传时间
     */
    protected Date cardUploadTime;
    /**
     * 拍照地址
     */
    protected String photoAddr;

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(String positionStatus) {
        this.positionStatus = positionStatus;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getReddotStatus() {
        return reddotStatus;
    }

    public void setReddotStatus(String reddotStatus) {
        this.reddotStatus = reddotStatus;
    }

    protected List<Disease> focus;
    protected Doctor signedDoctor; // 签约医生
    protected String distance;  //距离


    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public List<String> getFocusIds() {
        return focusIds;
    }

    public void setFocusIds(List<String> focusIds) {
        this.focusIds = focusIds;
    }

    public List<Disease> getFocus() {
        return focus;
    }

    public void setFocus(List<Disease> focus) {
        this.focus = focus;
    }

    public Doctor getSignedDoctor() {
        return signedDoctor;
    }

    public void setSignedDoctor(Doctor signedDoctor) {
        this.signedDoctor = signedDoctor;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getMedicareCard() {
        return medicareCard;
    }

    public void setMedicareCard(String medicareCard) {
        this.medicareCard = medicareCard;
    }

    public Date getCardUploadTime() {
        return cardUploadTime;
    }

    public void setCardUploadTime(Date cardUploadTime) {
        this.cardUploadTime = cardUploadTime;
    }

    public String getPhotoAddr() {
        return photoAddr;
    }

    public void setPhotoAddr(String photoAddr) {
        this.photoAddr = photoAddr;
    }

}
