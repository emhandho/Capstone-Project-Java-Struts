package com.capstoneproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capstoneproject.model.UserModel;

public class Admin {
	
	
	/**
	 * to Get Connection from database using jdbc api
	 */
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/capstoneproject?autoReconnect=true&useSSL=false", "root", "admin");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * to save data from registering
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int registerUser(UserModel user) throws Exception {
		int i = 0;
		try {
			String sql = "insert into software_programmer (firstname, lastname, email, companyname, city, country, password) values (?,?,?,?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getCompanyname());
			ps.setString(5, user.getCity());
			ps.setString(6, user.getCountry());
			ps.setString(7, user.getPassword());
			
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}
	

	/**
	 * to fetch user data for login
	 * @param uemail
	 * @return
	 * @throws Exception
	 */
	public ResultSet fetchLoginUser(String uemail) throws Exception {
		ResultSet rs = null;
		try {
			String sql = "select email, password from software_programmer where email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, uemail);
			
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	/**
	 * to fetch admin data for login
	 * @param uemail
	 * @return
	 * @throws Exception
	 */
	public ResultSet fetchLoginAdmin(String uemail) throws Exception {
		ResultSet rs = null;
		try {
			String sql = "select email, password from administrator where email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, uemail);
			
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	// method for fetch saved user data
	public ResultSet viewProfile(String uemail) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT firstname, lastname, email, companyname, city, country, password FROM software_programmer where email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, uemail);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	// method for fetching the data for the search list
	public ResultSet report() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT firstname, lastname, email, companyname, city, country, password FROM software_programmer";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
		
	// method for fetch old data to be update
	public ResultSet fetchUserDetails(String uemail) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT firstname, lastname, email, companyname, city, country, password FROM software_programmer WHERE email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, uemail);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	// method for update new data in database
	public int updateUserDetails(String ufirstname, String ulastname, String uemail, String ucomname, String ucity, String ucountry, String upass, String uemailhidden)
				throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE software_programmer SET firstname=?,lastname=?,email=?,companyname=?,city=?,country=?,password=? WHERE email=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, ufirstname);
				ps.setString(2, ulastname);
				ps.setString(3, uemail);
				ps.setString(4, ucomname);
				ps.setString(5, ucity);
				ps.setString(6, ucountry);
				ps.setString(7, upass);
				ps.setString(8, uemailhidden);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
		
	// methos for change the password for forgetting the current password
	public int changePassword(String uconpass, String email) throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE software_programmer SET password=? WHERE email=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, uconpass);
				ps.setString(2, email);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
		
		
	// method for delete the record
	public int deleteUserDetails(String email) throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "DELETE FROM software_programmer WHERE EMAIL=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, email);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
}
