package com.capstoneproject.interceptor;

import java.util.Map;

import com.capstoneproject.model.UserModel;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UserAuthenticationInterceptor implements Interceptor {

	
	private static final long serialVersionUID = -3338845448076030092L;

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	public void init() {
		// TODO Auto-generated method stub
		
	}

	
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> userSession = actionInvocation.getInvocationContext().getSession();
		UserModel user = (UserModel) userSession.get("user");
		
		if (user == null) {
			return ActionSupport.LOGIN;
		}
		return actionInvocation.invoke();
	}

}
