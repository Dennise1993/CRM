package cn.crm.service.biz;

import java.io.Serializable;
import java.util.List;

import cn.crm.common.util.PageBean;
import cn.crm.entity.BasDict;
import cn.crm.entity.CstCustomer;
import cn.crm.entity.CstService;
import cn.crm.entity.CstServiceVague;
import cn.crm.entity.SysUser;

public interface ServiceBiz {
	// 取出服务类型
	public List<BasDict> getServiceType();

	// 新增一条服务
	public Serializable saveNewService(CstService cstService);

	// 取出最大的ID
	@SuppressWarnings("rawtypes")
	public List getMaxId();

	// 取出顾客信息
	public List<CstCustomer> getAllCstCustomer();

	// 取出所有的没有分配的服务
	public List<CstService> getAllotService();

	// 取出所有的没有分配的服务根据分页
	public PageBean getAllByPage(SysUser user,CstServiceVague query,Integer pageIndex, Integer pageSize);

	// 得到分配的所有角色
	public List<SysUser> getAllotUser();

	// 保存分配后的角色，然后更改服务状态为1（已分配）
	public boolean saveAllotUser(CstService cst);

	// 根据ID得到一条服务信息
	public List<CstService> getOneService(String id);

	// 删除一个服务，修改状态为3
	public boolean deleteService(CstService cst);

	// 动态模糊查询
	public List<CstService> getServiceByVag(CstServiceVague vage,Integer pagesize, Integer pageindex);

	// 分配服务，根据用户ID查出该ID下的所有没有处理的服务
	public PageBean getServiceByID(String id,CstServiceVague query,Integer pageIndex, Integer pageSize);
	
	//得到该id没有处理的服务的总数
	public List<CstService> getCountServiceByID(String id);
	
	
	//根据ID得到有一个用户
	public List<SysUser> getOneUser(Long id);
	
	//服务反馈
	public PageBean getFeedService(String id,CstServiceVague query,Integer pageIndex, Integer pageSize);
	
	//得到改ID下所有处理过的服务
	public List<CstService> getFeedServiceByID(String id);
	
	
	
	//得到所有已经归档的服务
	public PageBean getFileService(CstServiceVague query, Integer pageIndex, Integer pageSize);
	
	
}
