/**
 * 
 */
package com.capstoneproject.interceptor;

import java.util.Map;

import com.capstoneproject.model.AdminModel;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Anonymous
 *
 */
public class AdminAuthenticationInterceptor {

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> adminSession = actionInvocation.getInvocationContext().getSession();
		AdminModel user = (AdminModel) adminSession.get("user");
		
		if (user == null) {
			return ActionSupport.LOGIN;
		}
		return actionInvocation.invoke();
	}
}
