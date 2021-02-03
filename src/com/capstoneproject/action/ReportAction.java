/**
 * 
 */
package com.capstoneproject.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.capstoneproject.model.UserModel;
import com.capstoneproject.dao.Admin;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Anonymous
 *
 */
public class ReportAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	UserModel user = null;
	List<UserModel> userList = null;
	Admin dao = new Admin();
	private boolean noData = false;
	
	@Override
	public String execute() throws Exception {
		try {
			userList = new ArrayList<UserModel>();
			rs = dao.report();
			int i = 0;
			
			if(rs != null) {
				while (rs.next()) {
					i++;
					user = new UserModel();
					user.setSrNo(i);
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setEmail(rs.getString("email"));
					user.setCompanyname(rs.getString("companyname"));
					user.setCity(rs.getString("city"));
					user.setCountry(rs.getString("country"));
					user.setPassword(rs.getString("password").replaceAll("(?s).", "*"));
					userList.add(user);
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
		
		return "REPORT";
	}

	public List<UserModel> getUserList() {
		return userList;
	}

	public void setBeanList(List<UserModel> userList) {
		this.userList = userList;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}
	
	
	
}
