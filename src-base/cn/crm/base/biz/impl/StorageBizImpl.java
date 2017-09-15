package cn.crm.base.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.base.biz.StorageBiz;
import cn.crm.base.entity.QueryStorageIf;
import cn.crm.common.basedao.DaoHelp;
import cn.crm.common.util.PageBean;
import cn.crm.entity.Storage;
@Component("storageBiz")
public class StorageBizImpl implements StorageBiz {

	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PageBean getStorageByIf(Integer pageindex, Integer pagesize,
			QueryStorageIf bean) {
		StringBuffer hql = new StringBuffer("from Storage where 1=1 ");
		StringBuffer hql2 =new StringBuffer( "select count(*) from Storage where 1=1 ");
		String prodName = null,stkWarehouse = null;
		if(bean!=null){
			if (bean.getProdName() != null) {
				prodName=bean.getProdName();
				bean.setProdName("%"+bean.getProdName()+"%");
				hql.append(" and (product.prodName like :prodName)");
				hql2.append(" and (product.prodName like :prodName)");
			}
			if (bean.getStkWarehouse() != null) {
				stkWarehouse=bean.getStkWarehouse();
				bean.setStkWarehouse("%"+bean.getStkWarehouse()+"%");
				hql.append(" and (stkWarehouse like :stkWarehouse)");
				hql2.append(" and (stkWarehouse like :stkWarehouse)");
			}
		}
		List<Storage> list=dao.getByPage(hql.toString(), bean, pageindex, pagesize);
		Long count = (Long) dao.uniqueResult(hql2.toString(), bean);
		if(bean!=null){
			bean.setProdName(prodName);
			bean.setStkWarehouse(stkWarehouse);
		}
		return new PageBean(pageindex, pagesize, count.intValue(), list);
	}
	

}
