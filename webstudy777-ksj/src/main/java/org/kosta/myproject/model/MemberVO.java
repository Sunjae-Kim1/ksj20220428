package org.kosta.myproject.model;

import java.io.Serializable;

public class MemberVO implements Serializable{
	private static final long serialVersionUID = -4293757649420709499L;
	private String id;
	private String password;
	private String name;
	private int age;
	public MemberVO() {
		super();
	}
	public MemberVO(String id, String name, int age, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.password = password;
	}	
	public MemberVO(String id,String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + "]";
	}
}