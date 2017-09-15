package cn.crm.top.biz;

import cn.crm.entity.SysUser;

public interface SSysuserBiz {
	
	/**
	 * 新增一条用户信息
	 */
	public void addsysuser(SysUser user);
	public Long getMaxUserId();
}
