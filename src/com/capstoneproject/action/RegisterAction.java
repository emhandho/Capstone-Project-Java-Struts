package com.capstoneproject.action;

import com.capstoneproject.dao.Admin;
import com.capstoneproject.model.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String ufirstname, ulastname, uemail, ucomname, ucity, ucountry, upass;
	private String msg = "";
	UserModel user = null;
	Admin dao = null;
	int ctr = 0;

	@Override
	public String execute() throws Exception {
		dao = new Admin();
		
		try {
			user = new UserModel();
			user.setFirstname(ufirstname);
			user.setLastname(ulastname);
			user.setEmail(uemail);
			user.setCompanyname(ucomname);
			user.setCity(ucity);
			user.setCountry(ucountry);
			user.setPassword(upass);
			
			ctr = dao.registerUser(user);
			if (ctr > 0) {
				msg = user.getFirstname() + " " + user.getLastname() + " registration Successfull!";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REGISTER";
	}

	

	public String getUfirstname() {
		return ufirstname;
	}



	public void setUfirstname(String ufirstname) {
		this.ufirstname = ufirstname;
	}



	public String getUlastname() {
		return ulastname;
	}



	public void setUlastname(String ulastname) {
		this.ulastname = ulastname;
	}



	public String getUemail() {
		return uemail;
	}



	public void setUemail(String uemail) {
		this.uemail = uemail;
	}



	public String getUcomname() {
		return ucomname;
	}



	public void setUcomname(String ucomname) {
		this.ucomname = ucomname;
	}



	public String getUcity() {
		return ucity;
	}



	public void setUcity(String ucity) {
		this.ucity = ucity;
	}



	public String getUcountry() {
		return ucountry;
	}



	public void setUcountry(String ucountry) {
		this.ucountry = ucountry;
	}



	public String getUpass() {
		return upass;
	}



	public void setUpass(String upass) {
		this.upass = upass;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

}
