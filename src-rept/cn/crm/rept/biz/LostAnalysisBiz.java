package cn.crm.rept.biz;

import java.util.List;

import cn.crm.common.util.PageBean;
import cn.crm.common.util.SearchParams;
import cn.crm.entity.SysUser;

public interface LostAnalysisBiz {
	public List<SysUser> showCustManagers();
	public PageBean getLostPageBean(int pageNum,int pageSize,SearchParams searchParams);

}
