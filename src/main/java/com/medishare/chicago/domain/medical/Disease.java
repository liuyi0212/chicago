package com.medishare.chicago.domain.medical;

import java.io.Serializable;

/**
 * 疾病
 * 
 * @author laurence
 *
 */
public class Disease implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 疾病ID
   */
  protected String id;

  /**
   * 层级号
   */
  protected Integer layer;

  /**
   * 上级疾病ID
   */
  protected String parentId;

  /**
   * 疾病名
   */
  protected String name;

  /**
   * 详情
   */
  protected String description;

  /**
   * 描述标签
   */
  protected String tags;

  /**
   * 整个疾病的路径
   */
  protected String path;
  
  /**
   * 临时字段 父类名称
   */
  protected String parentName;
  
  /**
   * 临时字段 父类ID
   */
  protected String parentID;
  
  public String getParentName() {
	return parentName;
  }

  public void setParentName(String parentName) {
	this.parentName = parentName;
  }

  public String getParentID() {
	return parentID;
  }

  public void setParentID(String parentID) {
	this.parentID = parentID;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getLayer() {
    return layer;
  }

  public void setLayer(Integer layer) {
    this.layer = layer;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

}
