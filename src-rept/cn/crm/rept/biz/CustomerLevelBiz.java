package cn.crm.rept.biz;

import cn.crm.common.util.PageBean;
import cn.crm.common.util.SearchParams;

public interface CustomerLevelBiz {
	public PageBean getContriPageBean(int pageNum,int pageSize,int viewType);

}
