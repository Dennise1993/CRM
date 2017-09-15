package cn.crm.custer.biz.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import cn.crm.common.basedao.DaoHelp;
import cn.crm.custer.biz.ScstCustomerBiz;
import cn.crm.custer.blur.cstCust;
import cn.crm.entity.BasDict;
import cn.crm.entity.CstCustomer;
import cn.crm.entity.SysRole;
import cn.crm.entity.SysUser;

@SuppressWarnings("all")
@Component("customerBiz")
public class ScstCustomerBizImpl implements ScstCustomerBiz {

	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;

	/**
	 * 客户关系模型首页显示
	 */

	public List<CstCustomer> searchCstCustomer(Integer pagesize,
			Integer pageindex) {
		Criterion cri = Restrictions.eq("custStatus", "0");
		return dao.criOperate(CstCustomer.class, cri, pagesize, pageindex);

	}

	/**
	 * 计算总页数
	 */
	public Integer countPage(Integer pagesize) {
		Integer count = this.searchCstCustomer(null, null).size();
		Integer temp = count / pagesize;
		return count % pagesize == 0 ? temp : temp + 1;
	}

	/**
	 * 级联查询结果并计算总页数
	 */
	public Integer faintlyCountPage(cstCust cstcust, Integer pagesize) {
		Integer count = this.searchFaintly(cstcust, null, null).size();
		Integer temp = count / pagesize;
		return count % pagesize == 0 ? temp : temp + 1;
	}

	/**
	 * 模糊查询并分页显示
	 */
	public List<CstCustomer> searchFaintly(cstCust cstcust, Integer pagesize,
			Integer pageindex) {
		// 组合查询全局变量
		Criterion cri = Restrictions.eq("custStatus", "0");
		// 客户名称
		String tem = "%" + cstcust.getClient() + "%";
		Criterion cusna = Restrictions.like("custName", tem);
		// 客户经理编号
		SysUser sysUser = new SysUser();
		sysUser.setUsrId(cstcust.getMana());
		Criterion syu = Restrictions.eq("sysUser", sysUser);
		// 等级编号
		BasDict basDict = new BasDict();
		basDict.setDictId(cstcust.getRankid());
		Criterion badi = Restrictions.eq("basDict", basDict);
		// 地区名称
		String time = "%" + cstcust.getDisc() + "%";
		Criterion scre = Restrictions.like("custRegion", time);
		// 组合查询的条件判断

		if (cstcust.getClient() != null && !"".equals(cstcust.getClient())) {

			cri = Restrictions.and(cri, cusna);
		}
		if (cstcust.getMana() != null && !"".equals(cstcust.getMana())) {

			cri = Restrictions.and(cri, syu);
		}
		if (cstcust.getRankid() != null && !"".equals(cstcust.getRankid())) {

			cri = Restrictions.and(cri, badi);
		}
		if (cstcust.getDisc() != null && !"".equals(cstcust.getDisc())) {

			cri = Restrictions.and(cri, scre);
		}
		return dao.criOperate(CstCustomer.class, cri, pagesize, pageindex);
	}

	/**
	 * 通过客户编号来查询一条信息
	 */
	public CstCustomer searchOne(String str) {
		CstCustomer tomo = null;
		String hql = "from CstCustomer where custStatus='0' and custNo= '"
				+ str + "'";
		List<CstCustomer> list = dao.searchList(hql, null, null, null);
		if (list != null && list.size() > 0) {
			tomo = list.get(0);
		}
		return tomo;
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
	 * 查询所有客户等级
	 */
	public List<BasDict> searchBas() {
		String hql = "from BasDict where dictId BETWEEN 1 AND 3 ";
		return dao.searchList(hql, null, null, null);
	}

	/**
	 * 保存编辑的数据
	 */
	public void updatecustomer(CstCustomer tomer) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE CstCustomer SET custName=?,custRegion=?,sysUser=?, ");
		sb.append(" basDict=?, custSatisfy=?, custCredit=?, custAddress=?, ");
		sb.append(" custZip=?, custTel=?, custFax=?, custWebsite=? WHERE custNo='"
				+ tomer.getCustNo() + "'");

		Object[] params = { tomer.getCustName(), tomer.getCustRegion(),
				tomer.getSysUser(), tomer.getBasDict(), tomer.getCustSatisfy(),
				tomer.getCustCredit(), tomer.getCustAddress(),
				tomer.getCustZip(), tomer.getCustTel(), tomer.getCustFax(),
				tomer.getCustWebsite() };
               dao.deletequery(sb.toString(), params);
	}

	/**
	 * 删除客户信息
	 */
	public void deletecustomer(CstCustomer tomer) {
   
		String hql="UPDATE CstCustomer SET custStatus='2' WHERE custNo='"+tomer.getCustNo()+"'";
		  dao.deletequery(hql, null);
	}

}
