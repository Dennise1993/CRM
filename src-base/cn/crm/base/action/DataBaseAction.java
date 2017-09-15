package cn.crm.base.action;


import com.opensymphony.xwork2.ActionContext;

import cn.crm.base.entity.QueryBaseIf;
import cn.crm.common.baseaction.BaseAction;
import cn.crm.common.util.PageBean;
import cn.crm.entity.BasDict;


public class DataBaseAction  extends BaseAction<BasDict>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QueryBaseIf query;				//查询条件
	private Integer max;					//现有ID最大值
	private BasDict basDict=super.model;
	private Integer delId;					//删除的ID


	public Integer getDelId() {
		return delId;
	}


	public void setDelId(Integer delId) {
		this.delId = delId;
	}


	public BasDict getBasDict() {
		return basDict;
	}


	public void setBasDict(BasDict basDict) {
		this.basDict = basDict;
	}


	public Integer getMax() {
		return max;
	}


	public void setMax(Integer max) {
		this.max = max;
	}


	public QueryBaseIf getQuery() {
		return query;
	}


	public void setQuery(QueryBaseIf query) {
		this.query = query;
	}


	public String showDictByIf(){
		PageBean pageBean=baseBiz.getBasDictByIf(pageNum, pageSize, query);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "success";
	}
	
	public String showDict(){
		max=baseBiz.showDict()+1;
		return "success";
	}
	
	public String addDict(){
		basDict.setDictStatus("0");
		if(basDict.getDictIsEditable()!=null){
			basDict.setDictIsEditable("0");
		}else {
			basDict.setDictIsEditable("1");
		}
		baseBiz.saveOrUpdate(basDict);
		return "success";
	}
	
	public String delDict(){
		baseBiz.delDict(delId);
		return "success";
	}
	
	public String showUptDict(){
		basDict=baseBiz.showUptDict(delId);
		return "success";
	}
	
	public String uptDict(){
		basDict.setDictStatus("0");
		if(basDict.getDictIsEditable()!=null){
			basDict.setDictIsEditable("0");
		}else {
			basDict.setDictIsEditable("1");
		}
		baseBiz.saveOrUpdate(basDict);
		return "success";
	}
	
	
}
