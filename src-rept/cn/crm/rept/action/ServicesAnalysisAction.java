package cn.crm.rept.action;

import com.opensymphony.xwork2.ActionContext;

import cn.crm.common.baseaction.BaseAction;
import cn.crm.common.util.PageBean;
import cn.crm.common.util.SearchParams;
import cn.crm.entity.CstService;

public class ServicesAnalysisAction extends BaseAction<CstService> {
	private SearchParams searchParams=new SearchParams();

	public SearchParams getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(SearchParams searchParams) {
		this.searchParams = searchParams;
	}
	
	/**
	 * 显示客户服务分析
	 */
	public String show(){
		PageBean pageBean=servicesAnalysisBiz.getSerAnalyPageBean(pageNum,pageSize,searchParams);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "show";
	}

}
