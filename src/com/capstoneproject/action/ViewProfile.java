/**
 * 
 */
package com.capstoneproject.action;

import java.sql.ResultSet;

import com.capstoneproject.dao.Admin;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Anonymous
 *
 */
public class ViewProfile extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String firstname, lastname, email, comname, city, country, password;
	ResultSet rs = null;
	Admin dao = new Admin();
	private boolean noData = false;
	
	@Override
	public String execute() throws Exception {
		try {
			rs = dao.viewProfile(email.trim());
			int i = 0;
			
			if(rs != null) {
				while (rs.next()) {
					i++;
					firstname = rs.getString("firstname");
					lastname = rs.getString("lastname");
					email = rs.getString("email");
					comname = rs.getString("companyname");
					city = rs.getString("city");
					country = rs.getString("country");
					password = rs.getString("password").replaceAll("(?s).", "*");;
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



	public String getComname() {
		return comname;
	}



	public void setComname(String comname) {
		this.comname = comname;
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
