package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "description_tbl")
public class Description extends BaseEntity {

	@Column(length = 2000)
	private String brief;//praragraph
	//description.brief

	public Description(String brief) {
		super();
		this.brief = brief;
	}

	public Description() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Override
	public String toString() {
		return "Description [brief=" + brief + "]";
	}
	
	
}
