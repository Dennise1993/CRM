package cn.crm.rept.biz;

import cn.crm.common.util.PageBean;
import cn.crm.common.util.SearchParams;

public interface ServicesAnalysisBiz {
	public PageBean getSerAnalyPageBean(int pageNum,int pageSize,SearchParams searchParams);
}
