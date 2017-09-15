package cn.crm.custer.biz.impl;

import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import cn.crm.common.basedao.DaoHelp;
import cn.crm.custer.biz.ScstLinkBiz;
import cn.crm.entity.CstCustomer;
import cn.crm.entity.CstLinkman;

@SuppressWarnings("all")
@Component("scstlinkBiz")
public class ScstLinkBizImpl implements ScstLinkBiz {
	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;

	/**
	 * 联系人模块首页显示并分页
	 * 
	 * @return
	 */

	public List<CstLinkman> searchcstlink(String ast, Integer pagesize,
			Integer pageindex) {
		//让其进行排序
		Criterion cri = Restrictions.eq("lkmFlag", "0");
		if (ast != null && !"".equals(ast)) {
			CstCustomer cstCustomer = new CstCustomer();
			cstCustomer.setCustNo(ast);
			Criterion cstc = Restrictions.eq("cstCustomer", cstCustomer);
			cri = Restrictions.and(cri, cstc);
		}
         
		return dao.criOperateAsc(CstLinkman.class, cri,"lkmId", pagesize, pageindex);
	}

	/**
	 * 分页显示时计算分的页数
	 */
	public Integer countpage(String ast, Integer pagesize) {
		Integer allcount = this.searchcstlink(ast, null, null).size();
		Integer temp = allcount / pagesize;
		return allcount % pagesize == 0 ? temp : temp + 1;
	}

	/**
	 * 编辑数据的时候显示一条数据信息
	 */
	public CstLinkman searchOne(Long linkid) {
		CstLinkman cstlink = null;
		Criterion cri = Restrictions.eq("lkmFlag", "0");
		if (linkid != null && !"".equals(linkid)) {
			Criterion link = Restrictions.eq("lkmId", linkid);
			cri = Restrictions.and(link, cri);
		}
		List<CstLinkman> list = dao.criOperate(CstLinkman.class, cri, null,
				null);
		if (list != null && list.size() > 0) {
			cstlink = list.get(0);
		}
		return cstlink;
	}

	/**
	 * 更改联系人信息
	 */
	public void updateLinkman(CstLinkman cstlink) {
		dao.updateObject(cstlink);

	}

	/**
	 * 删除联系人信息
	 */
	public boolean deleLinkman(Long linkid) {

		String hql = "UPDATE CstLinkman SET lkmFlag=1  WHERE LKM_ID=?";
		Object[] params = { linkid };
		if (dao.deletequery(hql, params) == null) {
			return false; 
		}
		return true;
	}

	/**
	 * 添加一条联系人信息
	 */
	public void saveMan(CstLinkman cstlink) {
		dao.save(cstlink);

	}

}
