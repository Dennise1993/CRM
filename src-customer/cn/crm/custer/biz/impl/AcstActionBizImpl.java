package cn.crm.custer.biz.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.common.basedao.DaoHelp;
import cn.crm.custer.biz.ScstActionBiz;
import cn.crm.entity.CstActivity;
import cn.crm.entity.CstCustomer;

@SuppressWarnings("all")
@Component("scstActionBiz")
public class AcstActionBizImpl implements ScstActionBiz {

	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;

	/**
	 * 活动首页显示数据并分页显示
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CstActivity> searchActivity(String ast, Integer pagesize,
			Integer pageindex) {
		// 查询没有删除条件
		Criterion cri = Restrictions.eq("atvFlag", "0");
		if (ast != null && !"".equals(ast)) {
			CstCustomer cstCustomer = new CstCustomer();
			cstCustomer.setCustNo(ast);
			Criterion as = Restrictions.eq("cstCustomer", cstCustomer);
		}
		return dao.criOperateAsc(CstActivity.class, cri, "atvId", pagesize,
				pageindex);
	}

	/**
	 * 计算总页数
	 */
	public Integer countActivity(String ast, Integer pagesize) {
		Integer count = this.searchActivity(ast, null, null).size();
		Integer temp = count / pagesize;
		return count % pagesize == 0 ? temp : temp + 1;

	}

	/**
	 * 编辑显示一条活动的信息
	 */
	public CstActivity searchOne(Long actid) {
		CstActivity act = null;
		Criterion cri = Restrictions.eq("atvFlag", "0");
		if (actid != null && !"".equals(actid)) {
			cri = Restrictions.and(cri, Restrictions.eq("atvId", actid));
		}

		List<CstActivity> list = dao.criOperateAsc(CstActivity.class, cri,
				"atvId", null, null);
		if (list != null && list.size() > 0) {
			act = list.get(0);
		}
		return act;
	}

	/**
	 * 更新一条数据
	 */
	public boolean updateActivity(CstActivity activ) {
		Integer n = null;
		String hql = "UPDATE CstActivity  SET atvDate=?,atvPlace=?,atvTitle=?,atvDesc=? WHERE atvId=?";
		Object[] params = { activ.getAtvDate(), activ.getAtvPlace(),
				activ.getAtvTitle(), activ.getAtvDesc(), activ.getAtvId() };
		n = dao.deletequery(hql, params);
		if (n == null) {
			return false;
		}

		return true;
	}

	/**
	 * 删除一条活动信息
	 */
	public boolean delactivity(CstActivity activ) {
		Integer n = null;
		String hql = "UPDATE CstActivity  SET atvFlag=1 WHERE atvId=?";
		Object[] params = { activ.getAtvId() };
		n = dao.deletequery(hql, params);
		if (n == null) {
			return false;
		}

		return true;
	}

	/**
	 * 保存一条数据信息
	 */
	public void saveActivity(CstActivity activ) {
		dao.save(activ);

	}

}
