package cn.crm.custer.biz.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.common.basedao.DaoHelp;
import cn.crm.custer.biz.ScstOrderBiz;
import cn.crm.entity.CstCustomer;
import cn.crm.entity.Orders;
import cn.crm.entity.OrdersLine;

@SuppressWarnings("all")
@Component("scstOrderBiz")
public class ScstOrderBizImpl implements ScstOrderBiz {

	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;

	/**
	 * 首页显示订单信息并分页
	 * 
	 * @return
	 */
	public List<Orders> seachOrder(String ast, Integer pagesize,
			Integer pageindex) {
		Criterion cri = null;
		if (ast != null && !"".equals(ast)) {
			CstCustomer cstCustomer = new CstCustomer();
			cstCustomer.setCustNo(ast);
			cri = Restrictions.eq("cstCustomer", cstCustomer);
		}

		return dao.criOperateAsc(Orders.class, cri, "odrId", pagesize,
				pageindex);
	}

	/**
	 * 计算总页数
	 */
	public Integer countpage(String ast, Integer pagesize) {
		Integer count = this.seachOrder(ast, null, null).size();
		Integer temp = count / pagesize;
		return count % pagesize == 0 ? temp : temp + 1;
	}

	/**
	 * 通过订单的id显示订单的详情并分页显示
	 */
	public List<OrdersLine> searchLine(Long ordid, Integer pagesize,
			Integer pageindex) {
		Criterion cri = null;
		if (ordid != null && !"".equals(ordid)) {
			Orders orders = new Orders();
			orders.setOdrId(ordid);
			cri = Restrictions.eq("orders", orders);
		}
		return dao.criOperateAsc(OrdersLine.class, cri, "oddId", pagesize,
				pageindex);
	}

	/**
	 * 计算通过订单的id显示订单的详情能过分的页数
	 */
	public Integer LineCountpage(Long ordid, Integer pagesize) {
		Integer count = this.searchLine(ordid, null, null).size();
		Integer temp = count / pagesize;
		return count % pagesize == 0 ? temp : temp + 1;
	}

	/**
	 * 通过订单id查询一条订单信息
	 */
	public Orders seachOrderOne(Long ordid) {
		Orders order = null;
		Criterion cri = null;
		if (ordid != null && !"".equals(ordid)) {
			cri = Restrictions.eq("odrId", ordid);
		}
		List<Orders> list = dao.criOperate(Orders.class, cri, null, null);
		if (list != null && list.size() > 0) {
			order = list.get(0);
		}
		return order;
	}

	/**
	 * 计算订单商品的总金额
	 */
	public Double allmoney(Long ordid) {
		Double tem = null;
		List<OrdersLine> list = this.searchLine(ordid, null, null);
		for (int i = 0; i < list.size(); i++) {
			tem = list.get(i).getOddCount()
					* list.get(i).getProduct().getProdPrice();
			tem+=tem;
		}
		return tem;
	}

}
