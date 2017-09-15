package cn.crm.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.common.basedao.DaoHelp;
import cn.crm.common.util.PageBean;

import cn.crm.entity.BasDict;
import cn.crm.entity.CstCustomer;
import cn.crm.entity.CstService;
import cn.crm.entity.CstServiceVague;
import cn.crm.entity.SysUser;
import cn.crm.service.biz.ServiceBiz;

@SuppressWarnings("rawtypes")
@Component("serviceBiz")
public class ServiceBizImpl implements ServiceBiz {

	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;

	/**
	 * 加载服务类型
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<BasDict> getServiceType() {

		String hql = "from BasDict where dictType='服务类型'";
		return dao.search(hql);
	}

	@Override
	public Serializable saveNewService(CstService cstService) {
		return dao.save(cstService);
	}

	@Override
	public List getMaxId() {
		String hql = "select max(svrId) from CstService";
		return dao.search(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CstCustomer> getAllCstCustomer() {
		String hql = "from CstCustomer";
		return dao.search(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CstService> getAllotService() {

		String hql = "from CstService where svrStatus='0' order by svrId desc";
		return dao.search(hql);
		// return dao.criOperate(CstService.class, null, null, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SysUser> getAllotUser() {
		String hql = "from SysUser where sysRole='5'";
		return dao.search(hql);
	}

	@Override
	public boolean saveAllotUser(CstService cst) {
		try {
			dao.update(cst);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CstService> getOneService(String id) {
		String hql = "from CstService where svrId=" + id;
		return dao.search(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageBean getAllByPage(SysUser user,CstServiceVague query,Integer pageIndex, Integer pageSize) {
//		String hql = "from CstService where svrStatus='0' order by svrId desc";
		StringBuffer hql = new StringBuffer("from CstService  where svrStatus='0'  " );
		StringBuffer hql2 = new StringBuffer("select count(*) from CstService where svrStatus='0' ");
		
		String name=null;
		System.out.println(query.getName());
		if(query!=null){
				if (query.getName() != null &&!"".equals(query.getName())) {
					name=query.getName() ;
					System.out.println(name);
					query.setName("%"+query.getName()+"%");
					hql.append(" and (cstCustomer.custName like :name)");
					hql2.append(" and (cstCustomer.custName like :name)");
				}
				if (query.getid() != null) {
					hql.append(" and (basDict.dictId like :id)");
					hql2.append(" and (basDict.dictId like :id)");
				}
				if (query.getDate() != null) {
					hql.append(" and (svrCreateDate = :date)");
					hql2.append(" and (svrCreateDate = :date)");
				}
		}
		List<CstService> list=dao.query(hql.toString(), query, pageIndex, pageSize);
		Long count = (Long) dao.uniqueResult(hql2.toString(), query);
		if(query!=null){
			query.setName(name);
		}
		return new PageBean(pageIndex, pageSize, count.intValue(), list);

	}

	@Override
	public boolean deleteService(CstService cst) {
		try {
			dao.update(cst);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public PageBean getServiceByID(String id,CstServiceVague query,Integer pageIndex, Integer pageSize) {
//		String hql = "from CstService where svrStatus='1' and sysUserBySvrDueId="
//				+ id + " order by svrId desc";
		StringBuffer hql = new StringBuffer("from CstService   where svrStatus='1' and sysUserBySvrDueId="+id );
		StringBuffer hql2 = new StringBuffer("select count(*) from CstService where svrStatus='1' and sysUserBySvrDueId="+id);
		
		String name=null;
		if(query!=null){
				if (query.getName() != null &&!"".equals(query.getName())) {
					name=query.getName() ;
					System.out.println(name);
					query.setName("%"+query.getName()+"%");
					hql.append(" and (cstCustomer.custName like :name)");
					hql2.append(" and (cstCustomer.custName like :name)");
				}
				if (query.getid() != null) {
					hql.append(" and (basDict.dictId like :id)");
					hql2.append(" and (basDict.dictId like :id)");
				}
				if (query.getDate() != null) {
					hql.append(" and (svrCreateDate = :date)");
					hql2.append(" and (svrCreateDate = :date)");
				}
		}
		List<CstService> list=dao.query(hql.toString(), query, pageIndex, pageSize);
		Long count = (Long) dao.uniqueResult(hql2.toString(), query);
		if(query!=null){
			query.setName(name);
		}
		return new PageBean(pageIndex, pageSize, count.intValue(), list);

	}

	@Override
	public List<CstService> getCountServiceByID(String id) {
		String hql = "from CstService where svrStatus='1' and sysUserBySvrDueId="
				+ id;
		return dao.search(hql);
	}

	
	@Override
	public List<SysUser> getOneUser(Long id) {
		String hql = "from SysUser where usrId=" + id;
		return dao.search(hql);
	}

	@Override
	public PageBean getFeedService(String id,CstServiceVague query,Integer pageIndex, Integer pageSize) {
//		String hql = "from CstService where svrStatus='3' and sysUserBySvrDueId="
//				+ id + " order by svrId desc";
		StringBuffer hql = new StringBuffer("from CstService where svrStatus='3' and sysUserBySvrDueId="+id);
		StringBuffer hql2 = new StringBuffer("select count(*) from CstService where svrStatus='3' and sysUserBySvrDueId="+id);
		
		String name=null;
		if(query!=null){
				if (query.getName() != null) {
					name=query.getName() ;
					query.setName("%"+query.getName()+"%");
					hql.append(" and (cstCustomer.custName like :name)");
					hql2.append(" and (cstCustomer.custName like :name)");
				}
				if (query.getid() != null) {
					hql.append(" and (basDict.dictId like :id)");
					hql2.append(" and (basDict.dictId like :id)");
				}
				if (query.getDate() != null) {
					hql.append(" and (svrCreateDate = :date)");
					hql2.append(" and (svrCreateDate = :date)");
				}
		}
		List<CstService> list=dao.query(hql.toString(), query, pageIndex, pageSize);
		Long count = (Long) dao.uniqueResult(hql2.toString(), query);
		if(query!=null){
			query.setName(name);
		}
		return new PageBean(pageIndex, pageSize, count.intValue(), list);
	}

	@Override
	public List<CstService> getFeedServiceByID(String id) {
		String hql = "from CstService where svrStatus='3' and sysUserBySvrDueId="
				+ id;
		return dao.search(hql);
	}

	

	@Override
	public PageBean getFileService(CstServiceVague query,Integer pageIndex, Integer pageSize) {
		StringBuffer hql = new StringBuffer("from CstService  where svrStatus='4' ");
		StringBuffer hql2 = new StringBuffer("select count(*) from CstService where svrStatus='4' ");
		
		String name=null;
		if(query!=null){
				if (query.getName() != null) {
					name=query.getName() ;
					query.setName("%"+query.getName()+"%");
					hql.append(" and (cstCustomer.custName like :name)");
					hql2.append(" and (cstCustomer.custName like :name)");
				}
				if (query.getid() != null) {
					hql.append(" and (basDict.dictId like :id)");
					hql2.append(" and (basDict.dictId like :id)");
				}
				if (query.getDate() != null) {
					hql.append(" and (svrCreateDate = :date)");
					hql2.append(" and (svrCreateDate = :date)");
				}
		}
		List<CstService> list=dao.query(hql.toString(), query, pageIndex, pageSize);
		Long count = (Long) dao.uniqueResult(hql2.toString(), query);
		if(query!=null){
			query.setName(name);
		}
		return new PageBean(pageIndex, pageSize, count.intValue(), list);
	}

	@Override
	public List<CstService> getServiceByVag(CstServiceVague vage,
			Integer pagesize, Integer pageindex) {
		// TODO Auto-generated method stub
		return null;
	}

}
