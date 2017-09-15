package cn.crm.base.biz;

import cn.crm.base.entity.QueryStorageIf;
import cn.crm.common.util.PageBean;

public interface StorageBiz {
	public PageBean getStorageByIf(Integer pageindex,Integer pagesize,QueryStorageIf bean);
}
