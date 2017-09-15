package cn.crm.rept.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cn.crm.common.baseaction.BaseAction;
import cn.crm.common.util.PageBean;
import cn.crm.common.util.SearchParams;
import cn.crm.entity.CstCustomer;

@SuppressWarnings("serial")
public class ContributionAnalysisAction extends BaseAction<CstCustomer> {
	//准备分页信息

	
	private SearchParams searchParams=new SearchParams();
	

	/**
	 * 显示所有公司所有年份的订单总额
	 * @return
	 */
	public String show(){
		//System.out.println("页面传来的用户名："+searchParams.getCustName());
		PageBean pageBean=contributionAnalysisBiz.getContriPageBean(pageNum,pageSize,searchParams);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "show";
	}


	public SearchParams getSearchParams() {
		return searchParams;
	}
	public void setSearchParams(SearchParams searchParams) {
		this.searchParams = searchParams;
	}
	

}
