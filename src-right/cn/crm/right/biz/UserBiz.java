package cn.crm.right.biz;

import cn.crm.entity.SysUser;

public interface UserBiz {
	public SysUser checkUser(String userName,String password);
}
