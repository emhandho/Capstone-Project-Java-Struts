/**
 * 
 */
package com.capstoneproject.action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.capstoneproject.dao.Admin;
import com.capstoneproject.model.AdminModel;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Anonymous
 *
 */
public class AdminLoginAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 2211981189839990338L;
	private String uemail, upass;
	private Admin dao = new Admin();
	private ResultSet rs = null;
	private Map<String,Object> userSession;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;
	}
	
	private boolean isValidUser(AdminModel user) throws Exception {
		try {
			rs = dao.fetchLoginAdmin(uemail.trim());
		
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
		AdminModel user = (AdminModel) userSession.get("user");
		if (user != null) {
			return SUCCESS;
		} else {
			AdminModel u = new AdminModel();
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