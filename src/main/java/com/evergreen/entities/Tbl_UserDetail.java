package com.evergreen.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Tbl_UserDetail.findAll", query = "select u from Tbl_UserDetail u order by u.fullname"),
		@NamedQuery(name = "Tbl_UserDetail.countAll", query = "select count(*) from Tbl_UserDetail u"),
		@NamedQuery(name = "Tbl_UserDetail.findByEmail", query = "select u from Tbl_UserDetail u where u.email = :email"),
		@NamedQuery(name = "Tbl_UserDetail.checkLogin", query = "select u from Tbl_UserDetail u where u.email = :email and pwd = :password") })

public class Tbl_UserDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(name = "fullname", length = 100, nullable = false)
	private String fullname;
	private String email;
	private String pwd;

	public Tbl_UserDetail() {
		super();
	}

	public Tbl_UserDetail(Integer userId, String email, String fullname, String pwd) {
		super();
		this.userId = userId;
		this.fullname = fullname;
		this.email = email;
		this.pwd = pwd;
	}

	public Tbl_UserDetail(String email, String fullname, String pwd) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.pwd = pwd;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Tbl_UserDetail [userId=" + userId + ", fullname=" + fullname + ", email=" + email + ", pwd=" + pwd
				+ "]";
	}
}
