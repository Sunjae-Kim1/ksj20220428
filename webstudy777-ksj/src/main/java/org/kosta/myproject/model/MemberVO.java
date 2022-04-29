package org.kosta.myproject.model;

public class MemberVO {
	private String id;
	private String name;
	private String age;
	public MemberVO(String id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public MemberVO() {
		super();
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
