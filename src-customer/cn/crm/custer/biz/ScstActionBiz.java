package cn.crm.custer.biz;

import java.util.List;

import cn.crm.entity.CstActivity;

public interface ScstActionBiz {
	
	/**
	 *  活动首页显示数据并分页显示
	 * @return
	 */
	public List<CstActivity>  searchActivity(String ast,Integer pagesize,Integer pageindex);
	
	/**
	 * 计算总页数
	 */
   public Integer countActivity(String ast,Integer pagesize);
   /**
    *  编辑显示一条活动的信息
    */
   public CstActivity searchOne(Long actid);
   
   /**
    * 更新一条数据活动信息
    */
   public boolean updateActivity(CstActivity activ);
   
   /**
    * 删除一条活动信息
    */
   public boolean delactivity(CstActivity activ);
    
   /**
    * 保存一条数据信息
    */
   public void saveActivity(CstActivity activ);
}
