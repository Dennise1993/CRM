package cn.crm.top.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import cn.crm.entity.SysUser;
import cn.crm.top.biz.SSysuserBiz;

@SuppressWarnings("all")
public class SSysuserAction extends ActionSupport{
	
	//添加用户信息
	@Resource
    private SSysuserBiz sysuserBiz;
	
	public SSysuserBiz getSysuserBiz() {
		return sysuserBiz;
	}

	public void setSysuserBiz(SSysuserBiz sysuserBiz) {
		this.sysuserBiz = sysuserBiz;
	}


	private SysUser sysuser;//用户实体类

    
    
	public SysUser getSysuser() {
		return sysuser;
	}

	public void setSysuser(SysUser sysuser) {
		this.sysuser = sysuser;
	}


	/**
	 *   添加用户
	 */
    public String addUser(){
    	sysuser.setUsrId(sysuserBiz.getMaxUserId());
    	sysuser.setUsrFlag("1");
    	sysuserBiz.addsysuser(sysuser);
		return "success";
    }
}
