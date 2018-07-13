package com.medishare.chicago.domain.request;

import com.medishare.chicago.domain.base.BaseRequest;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
public class DoctorRequest extends BaseRequest{

    private String id ;
    //用户姓名
    private String realName;
    //用户登录名
    private String userName;
    //省
    private String provinceId;
    private String provinceName;
    //市
    private String cityId;
    private String cityName;
    //区
    private String districtId;
    private String districtName;
    //街道
    private String townId;
    private String townName;
    //社区
    private String communityId;
    private String communityName;
    //医院
    private String hospitalId;
    private String hospitalName;
    //标签 格式：字符串逗号分隔。"tag1,tag2,tag3,tag4"
    private String tag;

    //医生ids
    private List<String> docIds;

    //医生标签
    private List<String> docTags;

    public List<String> getDocIds() {
        return docIds;
    }

    public void setDocIds(List<String> docIds) {
        this.docIds = docIds;
    }

    public List<String> getDocTags() {
        return docTags;
    }

    public void setDocTags(List<String> docTags) {
        this.docTags = docTags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getTownId() {
        return townId;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
