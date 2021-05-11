package com.ojas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "home")
public class Home {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private String name;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "home_id", referencedColumnName = "id")
	private List<Member> members = new ArrayList<Member>();

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

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Home() {
		super();
	}

	@Override
	public String toString() {
		return "Home [id=" + id + ", name=" + name + ", members=" + members + "]";
	}

}
