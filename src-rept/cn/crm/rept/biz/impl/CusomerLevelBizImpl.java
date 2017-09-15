package cn.crm.rept.biz.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.common.basedao.DaoHelp;
import cn.crm.common.util.PageBean;
import cn.crm.rept.biz.CustomerLevelBiz;
@Component("customerLevelBiz")
public class CusomerLevelBizImpl implements CustomerLevelBiz {
	
	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;


	/**
	 * 显示客户构成，查询分页信息
	 */
	@Override
	public PageBean getContriPageBean(int pageNum, int pageSize, int viewType) {
		if(viewType==0){
			return this.byLevel(pageNum, pageSize);			
		}else if(viewType==1){
			return this.byCredit(pageNum, pageSize);
		}else{
			return this.bySatisfy(pageNum, pageSize);
		}
	}
	
	public PageBean byLevel(int pageNum, int pageSize){
		StringBuffer sb=new StringBuffer("SELECT t2.item, t1.nums FROM ");
		sb.append("(SELECT DISTINCT(COUNT(*)) nums,t.cust_level cusl FROM CST_CUSTOMER t GROUP BY t.cust_level ) t1,");
		sb.append("(SELECT b.dict_item item,b.dict_value dicva FROM BAS_DICT b WHERE b.dict_type='企业客户等级')t2 ");
		sb.append("WHERE t1.cusl=t2.dicva ");
		sb.append("ORDER BY t1.nums DESC");
		@SuppressWarnings("unchecked")
		List<Object[]> recordList =dao.queryBySQLPage(sb.toString(), pageNum, pageSize);
		//查询总数
		StringBuffer sb2=new StringBuffer("SELECT COUNT(*) FROM(  ");
		sb2.append("SELECT t2.item, t1.nums FROM ");
		sb2.append("(SELECT DISTINCT(COUNT(*)) nums,t.cust_level cusl FROM CST_CUSTOMER t GROUP BY t.cust_level ) t1, ");
		sb2.append("    (SELECT b.dict_item item,b.dict_value dicva FROM BAS_DICT b WHERE b.dict_type='企业客户等级')t2 ");
		sb2.append("  WHERE t1.cusl=t2.dicva");
		sb2.append(" ORDER BY t1.nums DESC)");
		BigDecimal count=(BigDecimal) dao.uniqueResultBySQL(sb2.toString());
		return new PageBean(pageNum,pageSize,count.intValue(),recordList);
	}
	
	public PageBean byCredit(int pageNum, int pageSize){
		StringBuffer sb=new StringBuffer(" SELECT t2.item, t1.nums FROM ");
		sb.append("(SELECT DISTINCT(COUNT(*)) nums,t.cust_credit credit FROM CST_CUSTOMER t GROUP BY t.cust_credit ) t1,");
		sb.append("(SELECT b.dict_item item,b.dict_value dicva FROM BAS_DICT b WHERE b.dict_type='企业客户信用度')t2");
		sb.append(" WHERE t1.credit=t2.dicva ");
		sb.append("ORDER BY t1.nums DESC");
		@SuppressWarnings("unchecked")
		List<Object[]> recordList =dao.queryBySQLPage(sb.toString(), pageNum, pageSize);
		//查询总数
		StringBuffer sb2=new StringBuffer("SELECT COUNT(*) FROM(  ");
		sb2.append("SELECT t2.item, t1.nums FROM ");
		sb2.append("(SELECT DISTINCT(COUNT(*)) nums,t.cust_credit credit FROM CST_CUSTOMER t GROUP BY t.cust_credit ) t1, ");
		sb2.append(" (SELECT b.dict_item item,b.dict_value dicva FROM BAS_DICT b WHERE b.dict_type='企业客户信用度')t2 ");
		sb2.append(" WHERE t1.credit=t2.dicva");
		sb2.append(" ORDER BY t1.nums DESC)");
		BigDecimal count=(BigDecimal) dao.uniqueResultBySQL(sb2.toString());
		//System.out.println("==========数量===========>"+count);
		return new PageBean(pageNum,pageSize,count.intValue(),recordList);
	}
	
	public PageBean bySatisfy(int pageNum, int pageSize){
		StringBuffer sb=new StringBuffer(" SELECT t2.item, t1.nums FROM ");
		sb.append("(SELECT DISTINCT(COUNT(*)) nums,t.cust_satisfy satis FROM CST_CUSTOMER t GROUP BY t.cust_satisfy ) t1,");
		sb.append("(SELECT b.dict_item item,b.dict_value dicva FROM BAS_DICT b WHERE b.dict_type='企业客户满意度')t2");
		sb.append(" WHERE t1.satis=t2.dicva ");
		sb.append("ORDER BY t1.nums DESC");
		@SuppressWarnings("unchecked")
		List<Object[]> recordList =dao.queryBySQLPage(sb.toString(), pageNum, pageSize);
		//查询总数
		StringBuffer sb2=new StringBuffer("SELECT COUNT(*) FROM  ");
		sb2.append("(SELECT t2.item, t1.nums FROM ");
		sb2.append("(SELECT DISTINCT(COUNT(*)) nums,t.cust_satisfy satis FROM CST_CUSTOMER t GROUP BY t.cust_satisfy ) t1, ");
		sb2.append(" (SELECT b.dict_item item,b.dict_value dicva FROM BAS_DICT b WHERE b.dict_type='企业客户满意度')t2 ");
		sb2.append(" WHERE t1.satis=t2.dicva");
		sb2.append(" ORDER BY t1.nums DESC)");
		BigDecimal count=(BigDecimal) dao.uniqueResultBySQL(sb2.toString());
		//System.out.println("==========数量===========>"+count);
		return new PageBean(pageNum,pageSize,count.intValue(),recordList);
	}

}
