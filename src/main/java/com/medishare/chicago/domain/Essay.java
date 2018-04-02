package com.medishare.chicago.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 咨询文章
 * 
 * @author laurence
 *
 */
public class Essay implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 咨询ID
	 */
	protected String id;

	/**
	 * 标题
	 */
	protected String title;
	/**
	 * icon
	 */
	protected String icon;
	/**
	 * 链接地址
	 */
	protected String link;

	/**
	 * H5格式全文
	 */
	protected String body; // html5

	/**
	 * 所属类目
	 */
	protected String category;
	
	/**
	 * 发布到 1：米喜 2：号百 
	 */
	protected String releaseTo;
	/**
	 * 创建日期
	 * 
	 * @return
	 */
	protected Date created;

	/**
	 * 更新日期
	 * 
	 * @return
	 */
	protected Date updated;
	/**
	 * 内容
	 */
	protected String content;

	/**
	 * 市
	 */
	protected String city;
	/**
	 * 关键字
	 */
	protected String pccategory;

	protected List<Map<String, String>> otherThing;

	protected String category0;

	protected String releaseTo0;

	protected String category1;

	protected String releaseTo1;

	protected String category2;

	protected String releaseTo2;

	protected String category3;

	protected String releaseTo3;

	public String getCategory0() {
		return category0;
	}

	public void setCategory0(String category0) {
		this.category0 = category0;
	}

	public String getReleaseTo0() {
		return releaseTo0;
	}

	public void setReleaseTo0(String releaseTo0) {
		this.releaseTo0 = releaseTo0;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getReleaseTo1() {
		return releaseTo1;
	}

	public void setReleaseTo1(String releaseTo1) {
		this.releaseTo1 = releaseTo1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getReleaseTo2() {
		return releaseTo2;
	}

	public void setReleaseTo2(String releaseTo2) {
		this.releaseTo2 = releaseTo2;
	}

	public String getCategory3() {
		return category3;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}

	public String getReleaseTo3() {
		return releaseTo3;
	}

	public void setReleaseTo3(String releaseTo3) {
		this.releaseTo3 = releaseTo3;
	}

	public List<Map<String, String>> getOtherThing() {
		return otherThing;
	}

	public void setOtherThing(List<Map<String, String>> otherThing) {
		this.otherThing = otherThing;
	}

	public String getPccategory() {
		return pccategory;
	}

	public void setPccategory(String pccategory) {
		this.pccategory = pccategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReleaseTo() {
		return releaseTo;
	}

	public void setReleaseTo(String releaseTo) {
		this.releaseTo = releaseTo;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
