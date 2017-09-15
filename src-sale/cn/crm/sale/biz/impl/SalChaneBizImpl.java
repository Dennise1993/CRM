package cn.crm.sale.biz.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import cn.crm.common.basedao.DaoHelp;
import cn.crm.common.util.PageBean;
import cn.crm.entity.SalChance;
import cn.crm.entity.SysUser;
import cn.crm.sale.biz.SalChaneBiz;
import cn.crm.sale.page.SalChancePageDev;

@Component("salChaneBiz")
@SuppressWarnings("unchecked")
public class SalChaneBizImpl implements SalChaneBiz {

	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;

	/**
	 *  客户开发计划的分页模糊查询查询条件 的实现
	 */
	@Override
	public PageBean getSalChanceByIf(Integer pageindex, Integer pagesize,
			SalChancePageDev bean) {
		StringBuffer hql = new StringBuffer("from SalChance where 1=1");
		StringBuffer hql2 =new StringBuffer( "select count(*) from SalChance where 1=1");
		String chcCustName = null;
		String chcLinkman = null;
		//Date chcCreateDate = null;
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
			/**
			 * 日期可能报异常
			 */
			if (bean.getChcCreateDate() != null  &&	 !"".equals(bean.getChcCreateDate())) {
				/*chcCreateDate=(Date) bean.getChcCreateDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.format(chcCreateDate);
				bean.setChcCreateDate(chcCreateDate);*/
				hql.append(" and (chcCreateDate like :chcCreateDate)");//日期加等号
				hql2.append(" and (chcCreateDate like :chcCreateDate)");
			}
		}
		List<SalChance> list=dao.getByPage(hql.toString(), bean, pageindex, pagesize);
		Long count = (Long) dao.uniqueResult(hql2.toString(), bean);
		if(bean!=null){
			bean.setChcCustName(chcCustName);
			bean.setChcLinkman(chcLinkman);
			//bean.setChcCreateDate(chcCreateDate);
		}
		
		return new PageBean(pageindex, pagesize, count.intValue(), list);
	
	}

	//指派销售机会
	@Override
	public SalChance showDispatch(Long chaId) {
		String hql="from SalChance where chcId = " + chaId;
		SalChance salchance =(SalChance) dao.uniqueResult(hql, null);
		return salchance;
	}
	
	//保存指派销售机会
	@Override
	public SalChance AddDispatch(Long chaId) {
		String hql="from SalChance where chcId = " + chaId;
		SalChance salchance =(SalChance) dao.uniqueResult(hql, null);
		return salchance;
	}

	//修改销售机会
	@Override
	public SalChance showPlan(Long chaId) {
		String hql="from SalChance where chcId = " + chaId;
		SalChance salchance =(SalChance) dao.uniqueResult(hql, null);
		return salchance;
	}
	
	//保存修改销售机会
	@Override
	public SalChance AddshowPlan(Long chaId) {
		String hql="from SalChance where chcId = " + chaId;
		SalChance salchance =(SalChance) dao.uniqueResult(hql, null);
		return salchance;
	}

	//取出经理的集合
	@Override
	public List<SysUser> usersBySal() {
		String hql="from SysUser where sysRole.roleId=5 ";
		List<SysUser> list=dao.search(hql);
		return list;
	}

	

	
	
}
