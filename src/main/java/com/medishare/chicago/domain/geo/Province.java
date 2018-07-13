package com.medishare.chicago.domain.geo;

import java.io.Serializable;
import java.util.List;

/**
 * 省
 * 
 * @author laurence
 *
 */
public class Province implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String name;

  protected List<City> cityList;

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

  public List<City> getCityList() {
    return cityList;
  }

  public void setCityList(List<City> cityList) {
    this.cityList = cityList;
  }
}
