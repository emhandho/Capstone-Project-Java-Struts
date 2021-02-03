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
public class DeleteAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	String email, msg, firstname, lastname;
	Admin dao = new Admin();
	
	@Override
	public String execute() throws Exception {
		try {
			int isDeleted = dao.deleteUserDetails(email);
			if (isDeleted != 0) {
				msg = firstname + lastname + " record deleted Successfully!";
			} else {
				msg = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETED";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	
}
