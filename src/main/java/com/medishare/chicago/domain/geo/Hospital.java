package com.medishare.chicago.domain.geo;

import java.io.Serializable;
import java.util.Date;

/**
 * 医院信息
 * 
 * <pre>
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_bin NOT NULL,
  `province_id` int(11) DEFAULT NULL,
  `provicne_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `city_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL,
  `district_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `town_id` int(11) DEFAULT NULL,
  `town_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `organization_pic` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `organization_code` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `description` varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL COMMENT '医院类型，1 试点  2非试点',
  `feature` varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  `pic_id` int(11) DEFAULT NULL,
  `hospital_level` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `latitude` double(13,6) DEFAULT NULL COMMENT '纬度',
  `longitude` double(13,6) DEFAULT NULL COMMENT '经度',
  `phone` varchar(18) COLLATE utf8_bin DEFAULT NULL,
  `apply_number` int(11) DEFAULT '0' COMMENT '家庭医生申请数',
  `virtual_apply_number` int(11) DEFAULT '0' COMMENT '虚拟申请数',
  `website` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_vaccine` tinyint(4) DEFAULT NULL,
  `hospital_type` tinyint(4) DEFAULT NULL COMMENT '医院类别，1：卫生站；2：服务站；3：其他；',
  `hospital_degree` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `is_general` tinyint(4) DEFAULT NULL,
  `hospital_genre` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `is_public` tinyint(4) DEFAULT NULL COMMENT '0 未发布 1已发布',
 * </pre>
 * 
 * @author laurence
 *
 */
public class Hospital implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String name;
  protected String provinceId;
  protected String provinceName;
  protected String cityId;
  protected String cityName;
  protected String districtId;
  protected String districtName;
  protected String townId;
  protected String townName;
  protected String address;
  protected String orgId;
  protected String orgPic;
  protected String orgCode;
  protected String description;
  protected String type;
  protected String feature;
  protected String pic;
  protected String level;
  protected String phone;
  protected String website;
  protected int coverage;
  protected String depTemplate;//科室模板
  protected String attribute;
  // 医院图片.
  protected String photo;
  /**
   * 医院类型
   */
  protected String hospitalGenre;

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getDepTemplate() {
	return depTemplate;
}

public void setDepTemplate(String depTemplate) {
	this.depTemplate = depTemplate;
}

protected Date created;
  protected Date updated;

  protected boolean disabled;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public String getOrgPic() {
    return orgPic;
  }

  public void setOrgPic(String orgPic) {
    this.orgPic = orgPic;
  }

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getFeature() {
    return feature;
  }

  public void setFeature(String feature) {
    this.feature = feature;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public int getCoverage() {
    return coverage;
  }

  public void setCoverage(int coverage) {
    this.coverage = coverage;
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

  public boolean isDisabled() {
    return disabled;
  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

public String getAttribute() {
	return attribute;
}

public void setAttribute(String attribute) {
	this.attribute = attribute;
}

public String getHospitalGenre() {
	return hospitalGenre;
}

public void setHospitalGenre(String hospitalGenre) {
	this.hospitalGenre = hospitalGenre;
}

}
