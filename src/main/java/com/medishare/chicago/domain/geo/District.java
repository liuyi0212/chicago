package com.medishare.chicago.domain.geo;

import java.io.Serializable;
import java.util.List;

/**
 * 行政区域
 * 
 * @author laurence
 *
 */
public class District implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String id;
	protected String name;
	protected String cityId;

	/**
	 * 纬度
	 */
	protected Double latitude;
	/**
	 * 经度
	 */
	protected Double longitude;
	
	/**
	 * 区医院信息
	 */
	protected List<Hospital> hospitals;

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

	public List<Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(List<Hospital> hospitals) {
		this.hospitals = hospitals;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
}
