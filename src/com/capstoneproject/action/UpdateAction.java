package com.capstoneproject.action;

import java.sql.ResultSet;

import com.capstoneproject.dao.Admin;
import com.capstoneproject.model.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {
	
	private static final long serialVersionUID = 3L;
	private String firstname, lastname, email, companyname, city, country, password, emailhidden;
	private String msg;
	UserModel user = null;
	ResultSet rs = null;
	Admin dao = new Admin();
	String submitType;
	
	@Override
	public String execute() throws Exception {
		try {
			if (submitType.equals("updatedata")) {
				user = new UserModel();
				rs = dao.fetchUserDetails(email.trim());
				if (rs != null) {
					while (rs.next()) {
						firstname = rs.getString("firstname");
						lastname = rs.getString("lastname");
						email = rs.getString("email");
						companyname = rs.getString("companyname");
						city = rs.getString("city");
						country = rs.getString("country");
						password = rs.getString("password");
					}
				}
			} else {
				int i = dao.updateUserDetails(firstname, lastname, email, companyname, city, country, password, emailhidden);
				
				if (i > 0) {
					msg = "Record Update Successfully!";
				} else {
					msg = "error!";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "UPDATE"; 
	}

	

	

	public String getFirstname() {
		return firstname;
	}





	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}





	public String getLastname() {
		return lastname;
	}





	public void setLastname(String lastname) {
		this.lastname = lastname;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getCompanyname() {
		return companyname;
	}





	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getCountry() {
		return country;
	}





	public void setCountry(String country) {
		this.country = country;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getEmailhidden() {
		return emailhidden;
	}





	public void setEmailhidden(String emailhidden) {
		this.emailhidden = emailhidden;
	}





	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
	
	
}
