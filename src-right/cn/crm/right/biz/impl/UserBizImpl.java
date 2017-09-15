package cn.crm.right.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.common.basedao.DaoHelp;
import cn.crm.entity.SysUser;
import cn.crm.right.biz.UserBiz;
@Component("userBiz")
public class UserBizImpl implements UserBiz {
	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;

	@Override
	public SysUser checkUser(String userName, String password) {
		SysUser user=null;
		String hql="from SysUser where usrName=? and usrPassword=?";
		Object[] params={userName,password};
		List list=dao.searchByParams(hql, params);
		if(list!=null && list.size()==1){
		   user=(SysUser) list.get(0);
		}
		return user;
	}

}
