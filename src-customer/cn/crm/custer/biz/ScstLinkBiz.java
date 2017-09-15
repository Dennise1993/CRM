package cn.crm.custer.biz;

import java.util.List;

import cn.crm.entity.CstLinkman;

public interface ScstLinkBiz {
	
	/**
	 * 首页显示并分页
	 * @return
	 */
	public List<CstLinkman> searchcstlink(String ast,Integer pagesize,Integer pageindex);
	
	/**
	 * 分页显示时计算分的页数
	 */
    public Integer countpage(String ast,Integer pagesize);
    
    /**
     * 编辑数据的时候显示一条数据信息
     */
    public CstLinkman searchOne(Long linkid);
    
    /**
     * 更改联系人信息
     */
    public void updateLinkman(CstLinkman cstlink);
    
    /**
     * 删除联系人信息
     */
    public boolean deleLinkman(Long linkid);  
    
    /**
     * 添加一条联系人信息
     */
    public void saveMan(CstLinkman cstlink);
}
