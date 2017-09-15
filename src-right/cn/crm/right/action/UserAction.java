package cn.crm.right.action;

import cn.crm.common.baseaction.ActionHelper;
import cn.crm.common.baseaction.BaseAction;
import cn.crm.common.constants.Constants;
import cn.crm.entity.SysUser;

public class UserAction extends BaseAction<SysUser> {
	/** 登录页面*/
	public String loginUI() throws Exception{
		return "loginUI";
	}
	/** 登录*/
	public String login() throws Exception{
		SysUser loginUser=userBiz.checkUser(model.getUsrName(), model.getUsrPassword());
		if(loginUser !=null){
			ActionHelper.putSession(Constants.LOGIN_USER, loginUser);
		    return "toIndex";
		}else{
			addFieldError("login","用户名或密码不正确！");
		    return "loginUI";
		}
	}
	/** 注销*/
	public String logout() throws Exception{
		ActionHelper.removeSession(Constants.LOGIN_USER);
		return "logout";
	}
}
