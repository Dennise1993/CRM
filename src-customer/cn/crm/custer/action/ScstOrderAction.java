package cn.crm.custer.action;

import java.util.List;

import cn.crm.custer.biz.ScstOrderBiz;
import cn.crm.entity.Orders;
import cn.crm.entity.OrdersLine;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class ScstOrderAction extends ActionSupport {
	
	private ScstOrderBiz scstOrderBiz;//获得ScstOrderBiz接口实例
	private String ast;// 客户编号
	private String gongname;// 客户名称
	private Integer allpage;// 划分的总页数
	private Integer pageindex;// 当前页数
	private List<Orders> ordlist;//orders对象集
	private List<OrdersLine> linlist;//ordersline的对象
	private Orders order;//订单的对象
	private Double allmone;//计算订单的总金额
	
	
	
	public Double getAllmone() {
		return allmone;
	}
	public void setAllmone(Double allmone) {
		this.allmone = allmone;
	}
	public List<OrdersLine> getLinlist() {
		return linlist;
	}
	public void setLinlist(List<OrdersLine> linlist) {
		this.linlist = linlist;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public List<Orders> getOrdlist() {
		return ordlist;
	}
	public void setOrdlist(List<Orders> ordlist) {
		this.ordlist = ordlist;
	}
	public String getAst() {
		return ast;
	}
    public void setAst(String ast) {
		this.ast = ast;
	}
	public String getGongname() {
		return gongname;
	}
	public void setGongname(String gongname) {
		this.gongname = gongname;
	}
	public Integer getAllpage() {
		return allpage;
	}
	public void setAllpage(Integer allpage) {
		this.allpage = allpage;
	}
	public Integer getPageindex() {
		return pageindex;
	}
	public void setPageindex(Integer pageindex) {
		this.pageindex = pageindex;
	}
	public void setScstOrderBiz(ScstOrderBiz scstOrderBiz) {
		this.scstOrderBiz = scstOrderBiz;
	}
    /**
     * 订单首页显示并分页
     */
	public String scusShow(){
		Integer pagesize = 2;
		allpage = scstOrderBiz.countpage(ast, pagesize);
		if (pageindex == null || "".equals(pageindex)) {
			pageindex = 1;
		}
		if (pageindex < 1) {
			pageindex = 1;
		}
		if (pageindex > allpage) {
			pageindex = allpage;
		}
		
		ordlist=scstOrderBiz.seachOrder(ast, pagesize, pageindex);
		return "ordsuccess";
		
	}
	
	/**
	 * 通过订单的id查询订单的详情
	 * @return
	 */
	public String scstcsreShow(){
		
		Integer pagesize = 2;
		allpage = scstOrderBiz.LineCountpage(order.getOdrId(), pagesize);
		if (pageindex == null || "".equals(pageindex)) {
			pageindex = 1;
		}
		if (pageindex < 1) {
			pageindex = 1;
		}
		if (pageindex > allpage) {
			pageindex = allpage;
		}
		linlist=scstOrderBiz.searchLine(order.getOdrId(), pagesize, pageindex);
		
		allmone=scstOrderBiz.allmoney(order.getOdrId());
		
		order=scstOrderBiz.seachOrderOne(order.getOdrId());
		
		return "carsccess";
	}
}
