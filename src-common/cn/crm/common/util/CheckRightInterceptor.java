package cn.crm.common.util;

import cn.crm.common.baseaction.ActionHelper;
import cn.crm.common.constants.Constants;
import cn.crm.entity.SysUser;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckRightInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	/*	System.out.println("------------------>之前");
		String result = invocation.invoke(); 
		System.out.println("----------------->之后");
		return result;*/
		//获取信息
		SysUser loginUser= (SysUser) ActionHelper.getSession(Constants.LOGIN_USER);
		String privUrl=invocation.getProxy().getActionName();
		System.out.println("=================>"+privUrl+"<===============");
		//System.out.println(loginUser);
		//如果未登录，就转到登录页面
		if(loginUser == null){
			if(privUrl.startsWith("userRight_login")){
			//如果是准备去登录，就放行
				return invocation.invoke();
			}else{
			//如果不是去登录，就转到登录页面
			return "loginUI";
			}
		}else{
			if(loginUser.hasRightsByURL(privUrl)){
				//如果有权限，就放行
				return invocation.invoke();
			}else{
				//如果没有权限，就转到提示页面
				return "noPrivilegeError";
			}
		}
	}

}
