package cn.crm.base.biz;


import cn.crm.base.entity.QueryBaseIf;
import cn.crm.common.util.PageBean;
import cn.crm.entity.BasDict;

public interface BaseBiz {
	
	public PageBean getBasDictByIf(Integer pageindex,Integer pagesize,QueryBaseIf bean);
	
	public Integer showDict();
	
	public void saveOrUpdate(BasDict basDict);
	
	public void delDict(Integer delId);
	
	public BasDict showUptDict(Integer delId);

}
