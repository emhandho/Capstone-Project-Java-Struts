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
public class SearchAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	String search;
	ResultSet rs = null;
	UserModel bean = null;
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
					String param = rs.getString("firstname");
					
					if (search.toLowerCase().equals(param.toLowerCase())) {
						i++;
						bean = new UserModel();
						bean.setSrNo(i);
						bean.setFirstname(rs.getString("firstname"));
						bean.setLastname(rs.getString("lastname"));
						bean.setEmail(rs.getString("email"));
						userList.add(bean); 
					}
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
		
		return "success";
	}

	

	public List<UserModel> getUserList() {
		return userList;
	}

	public void setUserList(List<UserModel> userList) {
		this.userList = userList;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	
	
	
}
