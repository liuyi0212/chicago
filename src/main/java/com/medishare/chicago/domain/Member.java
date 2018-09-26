package com.medishare.chicago.domain;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: liuy
 * @date: 2018/9/6
 * @time: 下午1:49
 * @descripttion: com.medishare.chicago.domain
 */
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 账号
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 身份证号码
     */
    private String idcard;
    /**
     * 创建时间
     */
    private Date created;
    /**
     *更新时间
     */
    private Date updated;
    /**
     * 省id
     */
    private String provinceId;
    /**
     * 省
     */
    private String provinceName;
    /**
     * 市id
     */
    private String cityId;
    /**
     * 市
     */
    private String cityName;
    /**
     * 区id
     */
    private String districtId;
    /**
     * 区
     */
    private String districtName;
    /**
     * 街道id
     */
    private String townId;
    /**
     * 街道
     */
    private String townName;
    /**
     * 居委会id
     */
    private String CommunityId;
    /**
     * 居委会
     */
    private String CommunityName;
    /**
     * 医院id
     */
    private String hospitalId;
    /**
     * 医院
     */
    private String hospitalName;
    /**
     * 医生擅长的IDs
     */
    private List<String> specialtyIds;
    /**
     * 性别
     */
    private String gender;
    /**
     * 头像地址
     */
    private String portrait;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 用戶类型 0 用户 1 医生
     */
    private String type;
    /**
     * 地址
     */
    private String address;
    /**
     * 设备类型 Android ios
     */
    private String devicePlat;
    /**
     * 手机号码前缀
     */
    private String prefix;
    /**
     * 邀请人id
     */
    private Long inviteId;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 距离
     */
    private Double distance;
    /**
     * 用户类型
     * 1-100用户
     * 101-200医院角色
     * 201-300医院
     *
     *
     */
    private String memberType;


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDevicePlat() {
        return devicePlat;
    }

    public void setDevicePlat(String devicePlat) {
        this.devicePlat = devicePlat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPushKey() {
        return DigestUtils.sha1Hex(getId().toString());
    }

    public Long getInviteId() {
        return inviteId;
    }

    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getTownId() {
        return townId;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public List<String> getSpecialtyIds() {
        return specialtyIds;
    }

    public void setSpecialtyIds(List<String> specialtyIds) {
        this.specialtyIds = specialtyIds;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
