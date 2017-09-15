package cn.crm.custer.biz;

import java.util.List;

import cn.crm.entity.Orders;
import cn.crm.entity.OrdersLine;

public interface ScstOrderBiz {
	
	/**
	 * 首页显示订单信息并分页
	 * @return
	 */
	public List<Orders> seachOrder(String ast,Integer pagesize,Integer pageindex);
	
	/**
	 * 计算总页数
	 */
    public Integer countpage(String ast,Integer pagesize);
    
    /**
     * 通过订单的id显示订单的详情并分页显示
     */
    public List<OrdersLine>  searchLine(Long ordid, Integer pagesize,Integer pageindex);
    
    /**
     * 计算通过订单的id显示订单的详情能过分的页数
     */
    public Integer LineCountpage(Long ordid, Integer pagesize);
    
    /**
     *  通过订单id查询一条订单信息
     */
    public Orders seachOrderOne(Long ordid);
    
    /**
     * 计算订单商品的总金额
     */
    public Double allmoney(Long ordid);
}
