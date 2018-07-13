package com.medishare.chicago.domain.geo;

import java.io.Serializable;

/**
 * 城镇
 * 
 * @author laurence
 *
 */
public class Town implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String id;
	protected String name;
	protected String districtId;
	/**
	 * 纬度
	 */
	protected Double latitude;
	/**
	 * 经度
	 */
	protected Double longitude;

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

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

}
