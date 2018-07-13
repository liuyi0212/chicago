package com.medishare.chicago.domain.member;

import com.medishare.chicago.domain.base.BaseRequest;
import com.medishare.chicago.domain.activity.Activity;
import com.medishare.chicago.domain.geo.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuy on 2018/4/3.
 */
public abstract class Member extends BaseRequest {

    /**
     * 会员ID
     */
    protected String id;

    /**
     * 省ID
     */
    protected String provinceId;

    /**

     * 城市ID
     */
    protected String cityId;

    /**
     * 行政区ID
     */
    protected String districtId;

    /**
     * 城镇ID
     */
    protected String townId;

    /**
     * 社区ID
     */
    protected String communityId;
    /**
     * 纬度
     */
    protected Double latitude;
    /**
     * 经度
     */
    protected Double longitude;

    /**
     * 登录名
     */
    protected String username;

    /**
     * 真实姓名
     */
    protected String realname;

    /**
     * 性别
     */
    protected String gender;

    /**
     * 身高
     */
    protected String height;

    /**
     * 体重
     */

    protected String weight;

    /**
     * 身体质量指数
     */
    protected String BMI;

    /**
     * 个人描述
     */
    protected String description;

    /**
     * 头像
     */
    protected String portrait;

    /**
     * 邀请状态
     */
    protected String activeStatus;

    /**
     * 电话
     */
    protected String phone;

    /**
     * 邮件
     */
    protected String email;

    /**
     * 注册日期
     */
    protected Date created;

    /**
     * 更新日期
     */
    protected Date updated;

    /**
     * 是否停用
     */
    protected Boolean disabled;

    /**
     * 注册来源
     */
    protected String source;

    /**
     * 生日
     */
    protected Date birthday;

    /**
     * 详细地址
     */
    protected String address;

    /**
     * 密码
     */
    protected String password;

    /**
     * 密码salt
     */
    protected String pwdsalt;

    /**
     * 省
     */
    protected Province province;

    /**
     * 城市
     */
    protected City city;

    /**
     * 行政区域
     */
    protected District district;

    /**
     * 城镇
     */
    protected Town town;

    /**
     * 社区
     */
    protected Community community;

    /**
     * 活动数据汇总
     */
    protected Activity activity;
    /**
     * 令牌
     */
    protected String token;
    /**
     * 推荐分数
     */
    protected double score = 0;
    /**
     * 影响因子及得分数
     */
    protected Map<String, Double> scoreMap = new HashMap<String, Double>();
    /**
     * 线下签约集合
     */
    protected List<String> offLineContractIds;

    /**
     * 微信unionid
     */
    protected String unionid;

    /**
     * 微信openid
     */
    protected String openid;
    /**
     * 网易云账号
     */
    protected String wyyAccid;
    /**
     * 网易云密码
     */
    protected String wyyPwd;

    /**
     * 身份证url
     */
    protected String cardUrl;

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String bMI) {
        BMI = bMI;
    }
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        //this.portrait = portrait.replace("media", "cdn1");
        this.portrait = portrait;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwdsalt() {
        return pwdsalt;
    }

    public void setPwdsalt(String pwdsalt) {
        this.pwdsalt = pwdsalt;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemberId() {
        return this.getClass().getName() + "_" + this.getId();
    }

    public String getPushKey() {
        return DigestUtils.sha1Hex(getMemberId());
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Map<String, Double> getScoreMap() {
        return scoreMap;
    }

    public void setScoreMap(Map<String, Double> scoreMap) {
        this.scoreMap = scoreMap;
    }

    public List<String> getOffLineContractIds() {
        return offLineContractIds;
    }

    public void setOffLineContractIds(List<String> offLineContractIds) {
        this.offLineContractIds = offLineContractIds;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Member member = (Member) o;
        return id.equals(member.id);
    }

    @Override public int hashCode() {
        return id.hashCode();
    }


    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("com.Do_1832"));
        System.out.println(DigestUtils.sha1Hex("com.Do_1832"));
        System.out.println(DigestUtils.sha1Hex("com.Do_1832").length());
        System.out.println(DigestUtils.sha1Hex("com.Do_1832"));
    }

    public String getWyyAccid() {
        return wyyAccid;
    }

    public void setWyyAccid(String wyyAccid) {
        this.wyyAccid = wyyAccid;
    }

    public String getWyyPwd() {
        return wyyPwd;
    }

    public void setWyyPwd(String wyyPwd) {
        this.wyyPwd = wyyPwd;
    }

    public String getCardUrl() {
        return cardUrl;
    }

    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl;
    }


}
