package cn.crm.base.biz;

import cn.crm.base.entity.QueryProductIf;
import cn.crm.common.util.PageBean;

public interface ProductBiz {
	public PageBean getProductByIf(Integer pageindex,Integer pagesize,QueryProductIf bean);
	

}
