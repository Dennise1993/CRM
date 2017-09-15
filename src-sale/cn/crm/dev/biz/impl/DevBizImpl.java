package cn.crm.dev.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.common.basedao.DaoHelp;
import cn.crm.common.util.PageBean;
import cn.crm.dev.biz.DevBiz;
import cn.crm.dev.query.QueryDev;
import cn.crm.entity.CstPlan;
import cn.crm.entity.SalChance;
@Component("devBiz")
public class DevBizImpl implements DevBiz {
	
	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;

	@Override
	public PageBean showDevList(Integer pageindex, Integer pagesize, QueryDev bean) {
		StringBuffer hql = new StringBuffer("from SalChance where 1=1");
		StringBuffer hql2 =new StringBuffer( "select count(*) from SalChance where 1=1");
		String chcCustName = null;
		String chcLinkman = null;
		String chcTitle =null;
		if(bean!=null){
			if (bean.getChcCustName() != null && !"".equals(bean.getChcCustName()) ) {
				chcCustName=bean.getChcCustName();
				bean.setChcCustName("%"+bean.getChcCustName()+"%");
				hql.append(" and (chcCustName like :chcCustName)");
				hql2.append(" and (chcCustName like :chcCustName)");
			}
			if (bean.getChcLinkman() != null && !"".equals(bean.getChcLinkman())) {
				chcLinkman=bean.getChcLinkman();
				bean.setChcCustName("%"+bean.getChcLinkman()+"%");
				hql.append(" and (chcLinkman like :chcLinkman)");
				hql2.append(" and (chcLinkman like :chcLinkman)");
			}
			if (bean.getChcTitle() != null && !"".equals(bean.getChcTitle())) {
				chcTitle=bean.getChcTitle();
				bean.setChcTitle("%"+bean.getChcTitle()+"%");
				hql.append(" and (chcTitle like :chcTitle)");
				hql2.append(" and (chcTitle like :chcTitle)");
			}
		}
		List<SalChance> list=dao.getByPage(hql.toString(), bean, pageindex, pagesize);
		Long count = (Long) dao.uniqueResult(hql2.toString(), bean);
		if(bean!=null){
			bean.setChcCustName(chcCustName);
			bean.setChcLinkman(chcLinkman);
			bean.setChcTitle(chcTitle);
		}
		return new PageBean(pageindex, pagesize, count.intValue(), list);
	}

	@Override
	public SalChance showDevPlan(Integer chcId) {
		String sql="from SalChance where chcId="+chcId;
		SalChance sal= (SalChance) dao.uniqueResult(sql, null);
		return sal;
	}

	@Override
	public Long maxPlanId() {
		String str="select max(plaId) from CstPlan";
		Long count = (Long) dao.uniqueResult(str, null);
		return count;
	}

	@Override
	public void savePlan(CstPlan cstPlan) {
		dao.save(cstPlan);
	}

}
