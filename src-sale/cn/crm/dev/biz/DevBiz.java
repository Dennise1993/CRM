package cn.crm.dev.biz;

import cn.crm.common.util.PageBean;
import cn.crm.dev.query.QueryDev;
import cn.crm.entity.CstPlan;
import cn.crm.entity.SalChance;

public interface DevBiz {
	public PageBean showDevList(Integer pageindex,Integer pagesize,QueryDev bean);
	public SalChance showDevPlan(Integer chcId);
	public Long maxPlanId();
	public void savePlan(CstPlan cstPlan);
}
