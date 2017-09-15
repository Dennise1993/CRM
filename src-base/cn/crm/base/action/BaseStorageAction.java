package cn.crm.base.action;

import com.opensymphony.xwork2.ActionContext;

import cn.crm.base.entity.QueryStorageIf;
import cn.crm.common.baseaction.BaseAction;
import cn.crm.common.util.PageBean;
import cn.crm.entity.Storage;

public class BaseStorageAction extends BaseAction<Storage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QueryStorageIf queryStorage;
	private Storage storage=super.model;
	public QueryStorageIf getQueryStorage() {
		return queryStorage;
	}

	public void setQueryStorage(QueryStorageIf queryStorage) {
		this.queryStorage = queryStorage;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	
	
	public String showStorage(){
		PageBean pageBean=storageBiz.getStorageByIf(pageNum, pageSize, queryStorage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "success";
	}
	
}
