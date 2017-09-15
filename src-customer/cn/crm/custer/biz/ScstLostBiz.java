package cn.crm.custer.biz;

import java.util.List;

import cn.crm.custer.blur.cstLos;
import cn.crm.entity.CstLost;
import cn.crm.entity.SysUser;

public interface ScstLostBiz {
	
	
	/**
	 * 查询流失信息并分页显示
	 */
   public List<CstLost>  searchLose(Integer pagesize,Integer pageindex);
   
   
   /**
    * 计算总的页数（在流失信息的首页显示）
    */
   public Integer countSize(Integer pagesize);	
   
   /**
    * 查询所有的客户信息
    */
	public List<SysUser> searchUser();
	
	/**
	 *  动态条件下查询流失信息并分页显示
	 */
	public List<CstLost> searchTrend(cstLos cstlo,Integer pagesize,Integer pageindex);
	
	/**
	 *  计算总页数（动态条件下查询流失信息）
	 */
   public Integer countpage(cstLos cstlo,Integer pagesize);
   
   /**
    * 获取一条流失信息
    */
   public CstLost searchOne(Long losid);
   
   /**
    *   更新流失原因通过第id
    */
   public boolean updateLosure(CstLost cstLost);
   
   /**
    *   暂缓流失信息并更新到暂缓流失状态
    */
   public boolean updateloDefer(CstLost cstLost);
}
