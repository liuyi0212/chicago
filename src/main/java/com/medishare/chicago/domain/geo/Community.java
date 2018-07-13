package com.medishare.chicago.domain.geo;

import java.io.Serializable;

/**
 * 社区
 * 
 * @author laurence
 *
 */
public class Community implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String name;

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

}
