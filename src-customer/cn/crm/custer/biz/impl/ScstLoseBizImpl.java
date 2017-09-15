package cn.crm.custer.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import cn.crm.common.basedao.DaoHelp;
import cn.crm.custer.biz.ScstLostBiz;
import cn.crm.custer.blur.cstLos;
import cn.crm.entity.CstCustomer;
import cn.crm.entity.CstLost;
import cn.crm.entity.SysRole;
import cn.crm.entity.SysUser;

@SuppressWarnings("all")
@Component("scstLostBiz")
public class ScstLoseBizImpl implements ScstLostBiz {

	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;// 数据库访问层对象

	/**
	 * 查询流失信息并分页显示
	 */

	public List<CstLost> searchLose(Integer pagesize, Integer pageindex) {
		Criterion cri = Restrictions.eq("lstFlag", "0");
		return dao.criOperateAsc(CstLost.class, cri, "lstId", pagesize,
				pageindex);
	}

	/**
	 * 计算总的页数（在流失信息的首页显示）
	 */
	public Integer countSize(Integer pagesize) {
		Integer count = this.searchLose(null, null).size();
		Integer temp = count / pagesize;
		return count % pagesize == 0 ? temp : temp + 1;
	}

	/**
	 * 查询所有的客户经理信息
	 */
	public List<SysUser> searchUser() {
		// 查询角色为经理的用户信息
		SysRole sysRole = new SysRole();
		sysRole.setRoleId((long) 5);
		Criterion cri = Restrictions.eq("sysRole", sysRole);
		return dao.criOperateAsc(SysUser.class, cri, "usrId", null, null);
	}

	/**
	 * 动态条件下查询流失信息并分页显示
	 */
	public List<CstLost> searchTrend(cstLos cstlo, Integer pagesize,
			Integer pageindex) {
		List<Object> list = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
		sb.append(" FROM CstLost WHERE lstFlag=0 ");

		if (cstlo.getName() != null && !"".equals(cstlo.getName())) {
			String temp = "%" + cstlo.getName() + "%";
			sb.append("AND cstCustomer.custName LIKE ? ");
			list.add(temp);
		}
		if (cstlo.getUserid() != null && !"".equals(cstlo.getUserid())) {
			sb.append("AND sysUser.usrId=? ");
			list.add(cstlo.getUserid());
		}
		if (cstlo.getStatus() != null && !"".equals(cstlo.getStatus())) {
			sb.append("AND lstStatus=?");
			list.add(cstlo.getStatus());
		}
		Object[] params = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			params[i] = list.get(i);
		}
		return dao.searchList(sb.toString(), params, pagesize, pageindex);
	}

	/**
	 * 计算总页数（动态条件下查询流失信息）
	 */
	public Integer countpage(cstLos cstlo, Integer pagesize) {
		Integer count = this.searchTrend(cstlo, null, null).size();
		Integer temp = count / pagesize;
		return count % pagesize == 0 ? temp : temp + 1;
	}

	/**
	 * 获取一条流失信息
	 */
	public CstLost searchOne(Long losid) {
		CstLost lost = null;
		Criterion cri = Restrictions.eq("lstFlag", "0");
		if (losid != null && !"".equals(losid)) {
			cri = Restrictions.and(cri, Restrictions.eq("lstId", losid));
		}
		List<CstLost> list = dao.criOperate(CstLost.class, cri, null, null);
		if (list != null && list.size() > 0) {
			lost = list.get(0);
		}
		return lost;
	}

	/**
	 * 更新流失原因通过第id
	 */
	public boolean updateLosure(CstLost cstLost) {
		Integer n = null;
		String hql = "UPDATE CstLost SET lstStatus='3',lstReason=?  WHERE lstId=? ";
		Object[] params = { cstLost.getLstReason(), cstLost.getLstId() };
		n = dao.deletequery(hql, params);
		if (n != null && !"".equals(n)) {
			return true;
		}

		return false;
	}

	/**
	 * 暂缓流失信息并更新到暂缓流失状态
	 */
	public boolean updateloDefer(CstLost cstLost) {
		Integer n = null;
		String hql = "UPDATE CstLost SET lstStatus='2',lstDelay=?  WHERE lstId=? ";
		Object[] params = { cstLost.getLstDelay(), cstLost.getLstId() };
		n = dao.deletequery(hql, params);
		if (n != null && !"".equals(n)) {
			return true;
		}

		return false;
	}

}
