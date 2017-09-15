package cn.crm.base.action;

import com.opensymphony.xwork2.ActionContext;

import cn.crm.base.entity.QueryProductIf;
import cn.crm.common.baseaction.BaseAction;
import cn.crm.common.util.PageBean;
import cn.crm.entity.Product;

public class BaseProductAction extends BaseAction<Product> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QueryProductIf queryProduct;
	private Product product=super.model;
	
	
	
	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public QueryProductIf getQueryProduct() {
		return queryProduct;
	}



	public void setQueryProduct(QueryProductIf queryProduct) {
		this.queryProduct = queryProduct;
	}



	public String showProduct(){
		PageBean pageBean=productBiz.getProductByIf(pageNum, pageSize, queryProduct);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "success";
	}
	
	

}
