package com.capstoneproject.action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.capstoneproject.dao.Admin;
import com.capstoneproject.model.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction extends ActionSupport implements SessionAware {

	
	private static final long serialVersionUID = 1L;
	private String firstname, lastname, email, companyname, city, country, password;
	ResultSet rs = null;
	Admin dao = new Admin();
	private boolean noData = false;
	private Map<String,Object> userSession;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;
	}
	
	@Override
	public String execute() throws Exception {
		UserModel user = (UserModel) userSession.get("user");
		if (user != null) {
			try {
				rs = dao.viewProfile(user.getEmail().trim());
				int i = 0;
				
				if(rs != null) {
					while (rs.next()) {
						i++;
						firstname = rs.getString("firstname");
						lastname = rs.getString("lastname");
						email = rs.getString("email");
						companyname = rs.getString("companyname");
						city = rs.getString("city");
						country = rs.getString("country");
						password = rs.getString("password").replaceAll("(?s).", "*");
					}
				}
				if (i == 0) {
					noData = false;
				} else {
					noData = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "PROFILE";
		} else {
			return "INPUT";
		}
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

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}
	
	
	
}