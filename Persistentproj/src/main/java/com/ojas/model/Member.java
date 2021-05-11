package com.ojas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private boolean concent;

	public boolean isConcent() {
		return concent;
	}

	public void setConcent(boolean concent) {
		this.concent = concent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Member() {
		super();
	}

	public Member(int id, String name, boolean concent) {
		super();
		this.id = id;
		this.name = name;
		this.concent = concent;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", concent=" + concent + "]";
	}

}
