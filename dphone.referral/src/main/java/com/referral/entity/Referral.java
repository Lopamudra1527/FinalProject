package com.referral.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ref")
public class Referral {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userid;
	private String first_name;
	private String last_name;
	private int mobile;
	private String email;
	private int referral_points;
	private String status;

	public Referral() {
		super();
	}

	public Referral(int id, int userid, String first_name, String last_name, int mobile, String email,
			int referral_points, String status) {
		super();
		this.id = id;
		this.userid = userid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.email = email;
		this.referral_points = referral_points;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getReferral_points() {
		return referral_points;
	}

	public void setReferral_points(int referral_points) {
		this.referral_points = referral_points;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Referral [id=" + id + ", userid=" + userid + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", mobile=" + mobile + ", email=" + email + ", referral_points=" + referral_points + ", status="
				+ status + "]";
	}

}
