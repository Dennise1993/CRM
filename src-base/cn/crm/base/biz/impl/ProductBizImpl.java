package cn.crm.base.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.base.biz.ProductBiz;
import cn.crm.base.entity.QueryProductIf;
import cn.crm.common.basedao.DaoHelp;
import cn.crm.common.util.PageBean;
import cn.crm.entity.BasDict;
import cn.crm.entity.Product;
@Component("productBiz")
public class ProductBizImpl implements ProductBiz {

	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;
	
	@Override
	public PageBean getProductByIf(Integer pageindex, Integer pagesize,
			QueryProductIf bean) {
		StringBuffer hql = new StringBuffer("from Product where 1=1 ");
		StringBuffer hql2 =new StringBuffer( "select count(*) from Product where 1=1 ");
		String prodName = null,prodType = null,prodBatch = null;
		if(bean!=null){
			if (bean.getProdName() != null) {
				prodName=bean.getProdName();
				bean.setProdName("%"+bean.getProdName()+"%");
				hql.append(" and (prodName like :prodName)");
				hql2.append(" and (prodName like :prodName)");
			}
			if (bean.getProdType() != null) {
				prodType=bean.getProdType();
				bean.setProdType("%"+bean.getProdType()+"%");
				hql.append(" and (prodType like :prodType)");
				hql2.append(" and (prodType like :prodType)");
			}
			if (bean.getProdBatch() != null) {
				prodBatch=bean.getProdBatch();
				bean.setProdBatch("%"+bean.getProdBatch()+"%");
				hql.append(" and (prodBatch like :prodBatch)");
				hql2.append(" and (prodBatch like :prodBatch)");
			}
		}
		List<Product> list=dao.getByPage(hql.toString(), bean, pageindex, pagesize);
		Long count = (Long) dao.uniqueResult(hql2.toString(), bean);
		if(bean!=null){
			bean.setProdName(prodName);
			bean.setProdType(prodType);
			bean.setProdBatch(prodBatch);
		}
		return new PageBean(pageindex, pagesize, count.intValue(), list);
	}

}
