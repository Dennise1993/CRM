package cn.crm.sale.biz;

import java.util.List;

import cn.crm.common.util.PageBean;
import cn.crm.entity.SalChance;
import cn.crm.entity.SysUser;
import cn.crm.sale.page.SalChancePageDev;

public interface SalChaneBiz {
	
	//销售机会管理的分页模糊查询查询条件
	public PageBean getSalChanceByIf(Integer pageindex,Integer pagesize,SalChancePageDev bean);
	
	//指派销售机会
	public SalChance showDispatch(Long chaId);
	//保存指派销售机会
	public SalChance AddDispatch(Long chaId);
	
	//修改销售机会
    public SalChance showPlan(Long chaId);
    //保存修改销售机会
    public SalChance AddshowPlan(Long chaId);
    
    //取出客户经理集合
  	public List<SysUser> usersBySal();
	
}
