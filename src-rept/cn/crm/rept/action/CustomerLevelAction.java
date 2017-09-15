package cn.crm.rept.action;

import com.opensymphony.xwork2.ActionContext;

import cn.crm.common.baseaction.BaseAction;
import cn.crm.common.util.PageBean;
import cn.crm.entity.CstCustomer;

@SuppressWarnings("serial")
public class CustomerLevelAction extends BaseAction<CstCustomer> {
	/**
	 * 0表示按等级
	 * 1表示按信用度
	 * 2表示按满意度
	 */
	private int viewType=0;

	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}
	
	/**
	 * 显示客户构成
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception{
		PageBean pageBean=customerLevelBiz.getContriPageBean(pageNum,pageSize,viewType);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "show";
		
	}

}
