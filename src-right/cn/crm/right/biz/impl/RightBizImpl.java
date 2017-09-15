package cn.crm.right.biz.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.common.basedao.DaoHelp;
import cn.crm.entity.SysRight;
import cn.crm.right.biz.RightBiz;
@Component("rightBiz")
@SuppressWarnings("unchecked")
public class RightBizImpl implements RightBiz {
	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;


	@Override
	public List<SysRight> getTopRights(){ 
		String hql="from SysRight where  rightCode <>0 and sysRight.rightCode=0";
		return dao.search(hql);
	}


	@Override
	public Collection<String> getAllRights() {
		String hql="select distinct s.rightUrl from SysRight s where s.rightUrl is not null";
		return dao.search(hql);
	}

}
