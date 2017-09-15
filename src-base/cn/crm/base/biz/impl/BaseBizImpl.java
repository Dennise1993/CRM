package cn.crm.base.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.base.biz.BaseBiz;
import cn.crm.base.entity.QueryBaseIf;
import cn.crm.common.basedao.DaoHelp;
import cn.crm.common.util.PageBean;
import cn.crm.entity.BasDict;
@Component("baseBiz")
@SuppressWarnings("unchecked")
public class BaseBizImpl implements BaseBiz {

	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;
	
	
	@Override
	public PageBean getBasDictByIf(Integer pageindex,Integer pagesize,QueryBaseIf bean ) {
		StringBuffer hql = new StringBuffer("from BasDict where dictStatus=0 ");
		StringBuffer hql2 =new StringBuffer( "select count(*) from BasDict where dictStatus=0");
		String dictType = null,dictItem = null,dictValue = null;
		if(bean!=null){
			if (bean.getDictType() != null) {
				dictType=bean.getDictType();
				bean.setDictType("%"+bean.getDictType()+"%");
				hql.append(" and (dictType like :dictType)");
				hql2.append(" and (dictType like :dictType)");
			}
			if (bean.getDictItem() != null) {
				dictItem=bean.getDictItem();
				bean.setDictItem("%"+bean.getDictItem()+"%");
				hql.append(" and (dictItem like :dictItem)");
				hql2.append(" and (dictItem like :dictItem)");
			}
			if (bean.getDictValue() != null) {
				dictValue=bean.getDictValue();
				bean.setDictValue("%"+bean.getDictValue()+"%");
				hql.append(" and (dictValue like :dictValue)");
				hql2.append(" and (dictValue like :dictValue)");
			}
		}
		List<BasDict> list=dao.getByPage(hql.toString(), bean, pageindex, pagesize);
		Long count = (Long) dao.uniqueResult(hql2.toString(), bean);
		if(bean!=null){
			bean.setDictType(dictType);
			bean.setDictItem(dictItem);
			bean.setDictValue(dictValue);
		}
		
		return new PageBean(pageindex, pagesize, count.intValue(), list);
	}


	@Override
	public Integer showDict() {
		String hql="select max(dictId) from BasDict";
		Long temp = (Long) dao.uniqueResult(hql.toString(),null);
		Integer max=Integer.valueOf(temp.toString());
		return max;
	}


	@Override
	public void saveOrUpdate(BasDict basDict) {
		dao.saveOrUpdate(basDict);
	}

	@Override
	public void delDict(Integer delId) {
		String hql="from BasDict where dictId = " + delId;
		BasDict basDict=(BasDict) dao.uniqueResult(hql,null);
		basDict.setDictStatus("1");
		dao.del(basDict);
	}


	@Override
	public BasDict showUptDict(Integer delId) {
		String hql="from BasDict where dictId = " + delId;
		BasDict basDict=(BasDict) dao.uniqueResult(hql,null);
		return basDict;
		
	}

}
