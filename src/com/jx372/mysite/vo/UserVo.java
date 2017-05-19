package com.jx372.mysite.vo;

public class UserVo {
	private Long no;
	private String name;
	private String email;
	private String passwd;
	private String gender;
	
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", email=" + email + ", passwd=" + passwd + ", gender=" + gender
				+ "]";
	}
	public final Long getNo() {
		return no;
	}
	
	public final void setNo(Long no) {
		this.no = no;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getPasswd() {
		return passwd;
	}
	public final void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public final String getGender() {
		return gender;
	}
	public final void setGender(String gender) {
		this.gender = gender;
	}
}
