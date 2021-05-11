package com.ojas.model;

import java.util.List;

public class MemberList {
	private List<Member> members;

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "MemberList [members=" + members + "]";
	}

	public MemberList() {
		super();
	}

}
