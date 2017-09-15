package cn.crm.dev.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;

import cn.crm.common.baseaction.BaseAction;
import cn.crm.common.util.PageBean;
import cn.crm.dev.query.QueryDev;
import cn.crm.entity.CstPlan;
import cn.crm.entity.SalChance;

public class DevAction extends BaseAction<CstPlan>{
	
	private static final long serialVersionUID = 1L;
	private QueryDev queryDev;
	private SalChance sal;
	private Integer planId;//执行计划ID
	private CstPlan cstPlan=super.model;
	private Long maxPlanId;


	public Long getMaxPlanId() {
		return maxPlanId;
	}


	public void setMaxPlanId(Long maxPlanId) {
		this.maxPlanId = maxPlanId;
	}


	public CstPlan getCstPlan() {
		return cstPlan;
	}


	public void setCstPlan(CstPlan cstPlan) {
		this.cstPlan = cstPlan;
	}


	public SalChance getSal() {
		return sal;
	}


	public void setSal(SalChance sal) {
		this.sal = sal;
	}


	public Integer getPlanId() {
		return planId;
	}


	public void setPlanId(Integer planId) {
		this.planId = planId;
	}


	public QueryDev getQueryDev() {
		return queryDev;
	}


	public void setQueryDev(QueryDev queryDev) {
		this.queryDev = queryDev;
	}

	public String showDev(){
		PageBean pageBean=devBiz.showDevList(pageNum, pageSize, queryDev);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "success";
	}
	
	public String showPlan(){
		sal=devBiz.showDevPlan(planId);
		return "success";
	}
	public String savePlan(){
		System.out.println(cstPlan.getPlaTodo());
		//cstPlan.setPlaDate(new Date());
		cstPlan.setSalChance(sal);
		cstPlan.setPlaFlag("0");
		maxPlanId=devBiz.maxPlanId();
		cstPlan.setPlaId(maxPlanId);
		//devBiz.savePlan(cstPlan);
		return "success";
	}
	
	
	
}
