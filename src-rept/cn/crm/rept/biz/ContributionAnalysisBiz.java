package cn.crm.rept.biz;

import cn.crm.common.util.PageBean;
import cn.crm.common.util.SearchParams;

public interface ContributionAnalysisBiz {
	public PageBean getContriPageBean(int pageNum,int pageSize,SearchParams searchParams);

}
