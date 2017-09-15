package cn.crm.rept.biz.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.common.basedao.DaoHelp;
import cn.crm.common.util.PageBean;
import cn.crm.common.util.SearchParams;
import cn.crm.entity.CstCustomer;
import cn.crm.entity.Orders;
import cn.crm.entity.OrdersLine;
import cn.crm.rept.biz.ContributionAnalysisBiz;

@Component("contributionAnalysisBiz")
@SuppressWarnings("unchecked")
public class ContributionAnalysisBizImpl implements ContributionAnalysisBiz {
	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;

	/**
	 * 显示订单总额，查询分页信息
	 */
	@Override
	public PageBean getContriPageBean(int pageNum, int pageSize,
			SearchParams params) {
		// 查询列表
		StringBuffer sb = new StringBuffer("from CstCustomer where 1=1");
		//System.out.println("页面传来的用户名："+params.getCusName());
       String origin=params.getCustName();
		if (params.getCustName() != null && ! "".equals(params.getCustName())) {
			//System.out.println("进入方法");
			sb.append(" and custName like :custName");
			params.setCustName("%" + params.getCustName() + "%");
		}

		List<CstCustomer> customerList = dao.getByPage(sb.toString(), params,
				pageNum, pageSize);
		Map<String, Integer> priceMap = new HashMap<String, Integer>();
		//List timeList = new ArrayList();
		int money = 0;
		for (CstCustomer c : customerList) {
			Set<Orders> orders = c.getOrderses();

			for (Orders order : orders) {
				// 获得订单的时间
				Timestamp oTime = order.getOdrDate();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(oTime);
				// 取出年份
				int year = calendar.get(Calendar.YEAR);
				// 与params中的year做对比
				if (params.getYear() != null && ! params.getYear().equals("")) {
					//System.out.println("页面参数："+params.getYear());
					int paramYear = Integer.parseInt(params.getYear());
					if (paramYear == year) {
						Set<OrdersLine> ordersLines = order.getOrdersLines();
						for (OrdersLine ol : ordersLines) {
							int count = ol.getOddCount().intValue();
							double price = ol.getProduct().getProdPrice();
							money += price * count;
							priceMap.put(c.getCustNo(), money);
						}
					}
				}else{
					Set<OrdersLine> ordersLines = order.getOrdersLines();
					for (OrdersLine ol : ordersLines) {
						int count = ol.getOddCount().intValue();
						double price = ol.getProduct().getProdPrice();
						money += price * count;
						priceMap.put(c.getCustNo(), money);
						//System.out.println("进入计算金额方法");
					}
				}

			}

		}
		// 查询总数量
		StringBuffer hql2 =new StringBuffer( "select count(*) from CstCustomer where 1=1");
		if (params.getCustName() != null && ! "".equals(params.getCustName())) {
			hql2.append(" and custName like :custName");
			params.setCustName("%" + params.getCustName() + "%");
		}
		Long count = (Long) dao.uniqueResult(hql2.toString(), params);
		//System.out.println("查询记录数量："+count);
		params.setCustName(origin);
		return new PageBean(pageNum, pageSize, count.intValue(), customerList,
				priceMap);
	}

}
