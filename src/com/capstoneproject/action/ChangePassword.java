/**
 * 
 */
package com.capstoneproject.action;

import com.capstoneproject.dao.Admin;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Anonymous
 *
 */
public class ChangePassword extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7427277725679783583L;
	private String email, unewpass;
	private String msg;
	Admin dao = new Admin();
	
	@Override
	public String execute() throws Exception { 
		try {
			System.out.println(email);
			System.out.println(unewpass);
			
			int i = dao.changePassword(unewpass, email);
			
			System.out.println(i);
			
			if (i > 0) {
				msg = "Password Change Successfully!";
			} else {
				msg = "Error Change Password!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "CHANGE";
	}
	
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUnewpass() {
		return unewpass;
	}



	public void setUnewpass(String unewpass) {
		this.unewpass = unewpass;
	}



	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
