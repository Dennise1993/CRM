package cn.crm.rept.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.crm.common.baseaction.BaseAction;
import cn.crm.common.util.PageBean;
import cn.crm.common.util.SearchParams;
import cn.crm.entity.CstLost;
import cn.crm.entity.SysUser;

public class LostAnalysisAction extends BaseAction<CstLost> {
	private SearchParams searchParams = new SearchParams();
	private List<SysUser> custManagers;//客户经理下拉列表

	public SearchParams getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(SearchParams searchParams) {
		this.searchParams = searchParams;
	}

	public List<SysUser> getCustManagers() {
		return custManagers;
	}

	public void setCustManagers(List<SysUser> custManagers) {
		this.custManagers = custManagers;
	}
	
	public String show(){
		custManagers=lostAnalysisBiz.showCustManagers();
		//System.out.println("==========================>集合数量："+custManagers.size());
		PageBean pageBean=lostAnalysisBiz.getLostPageBean(pageNum,pageSize,searchParams);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "show";
	}

}
