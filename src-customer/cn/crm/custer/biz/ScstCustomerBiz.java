package cn.crm.custer.biz;

import java.util.List;

import cn.crm.custer.blur.cstCust;
import cn.crm.entity.BasDict;
import cn.crm.entity.CstCustomer;
import cn.crm.entity.SysUser;

public interface ScstCustomerBiz {

	/**
	 * 客户关系模型首页显示
	 * @return
	 */
	public List<CstCustomer> searchCstCustomer(Integer pagesize,Integer pageindex);
	/**
	 * 计算总页数		
	 */
	public Integer countPage(Integer pagesize);
	
	/**
	 * 级联查询计算总页数
	 */
	public Integer faintlyCountPage(cstCust cstcust,Integer pagesize);
	
	/**
	 * 模糊查询并分页显示
	 */
	public List<CstCustomer> searchFaintly(cstCust cstcust,Integer pagesize,Integer pageindex);
	
	/**
	 * 通过客户编号来查询一条信息
	 */
	public CstCustomer searchOne(String  str);
	
	/**
	 * 查询所有的经理信息
	 * @return
	 */
	public List<SysUser> searchUser();
	
    /**
     * 查询所有客户等级
     */
	 public List<BasDict> searchBas();
	
	
	/**
	 * 
     * 保存编辑的数据
     */	
	public void updatecustomer(CstCustomer tomer);
	
	/**
	 * 删除客户信息
	 */
	public void deletecustomer(CstCustomer tomer);
	
	
	
	
}
