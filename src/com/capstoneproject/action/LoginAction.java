package com.capstoneproject.action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.capstoneproject.dao.Admin;
import com.capstoneproject.model.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 2211981189839990338L;
	private String uemail, upass;
	private Admin dao = new Admin();
	private ResultSet rs = null;
	private Map<String,Object> userSession;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;
	}
	
	private boolean isValidUser(UserModel user) throws Exception {
		try {
			rs = dao.fetchLoginUser(uemail.trim());
		
			if(rs != null) {
				while (rs.next()) {
					uemail = rs.getString("email");
					upass = rs.getString("password");
					
					if(user.getEmail().equals(uemail) && user.getPassword().equals(upass))
						return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public String execute() {
		clearFieldErrors();
		UserModel user = (UserModel) userSession.get("user");
		if (user != null) {
			return SUCCESS;
		} else {
			UserModel u = new UserModel();
			u.setEmail(uemail);
			u.setPassword(upass);
			
			try {
				if (isValidUser(u)) {
					userSession.put("user", u);
					return SUCCESS;
				} else {
					addFieldError("invalid", "Invalid username or password");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return INPUT;
		}
	}



	public String getUemail() {
		return uemail;
	}



	public void setUemail(String uemail) {
		this.uemail = uemail;
	}



	public String getUpass() {
		return upass;
	}



	public void setUpass(String upass) {
		this.upass = upass;
	}
	
	
}
