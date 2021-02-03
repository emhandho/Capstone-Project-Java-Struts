package com.capstoneproject.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	
	
	private static final long serialVersionUID = -3499242021313411358L;
	private Map<String, Object> userSession;

	@Override
	public void setSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	
	@Override
	public String execute() {
		userSession.remove("user");
		return SUCCESS;
	}
}
