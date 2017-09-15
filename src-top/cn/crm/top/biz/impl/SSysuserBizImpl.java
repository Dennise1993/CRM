package cn.crm.top.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import cn.crm.common.basedao.DaoHelp;
import cn.crm.entity.SysUser;
import cn.crm.top.biz.SSysuserBiz;
 




@Component("sysuserBiz")
public class SSysuserBizImpl implements SSysuserBiz {
    @Autowired
    @Qualifier("dao")
	private DaoHelp dao;//引入dao实例
	
	/**
	 * 新增一条用户信息
	 */
	public void addsysuser(SysUser user) {
	  dao.save(user);	
	}

	@Override
	public Long getMaxUserId() {
		String hql="select max(usrId) from SysUser";
		return ((Long) dao.uniqueResult(hql, null)+1);
	}

}
