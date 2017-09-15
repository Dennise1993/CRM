package cn.crm.rept.biz.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.common.basedao.DaoHelp;
import cn.crm.common.util.PageBean;
import cn.crm.common.util.SearchParams;
import cn.crm.rept.biz.ServicesAnalysisBiz;

@Component("servicesAnalysisBiz")

public class ServicesAnalysisBizImpl implements ServicesAnalysisBiz {

	/**
	 * 显示服务分析，查询分页信息
	 */
	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;
	@Override
	public PageBean getSerAnalyPageBean(int pageNum, int pageSize,
			SearchParams searchParams) {
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT t1.serName,t2.nums FROM");
		sb.append(" (SELECT b.dict_id serId,b.dict_value serName FROM BAS_DICT b WHERE b.dict_type='服务类型' AND b.dict_status=0)t1,");
		sb.append(" (SELECT DISTINCT COUNT(*) nums,t.svr_type svrType FROM CST_SERVICE t");
		if (searchParams.getYear() != null && ! searchParams.getYear().equals("")){
			sb.append(" WHERE to_char(t.svr_create_date,'YYYY')=:year ");
		}
		sb.append(" GROUP BY t.svr_type)t2");
		sb.append(" WHERE t1.serId=t2.svrType");
		List<Object[]> recordList =dao.queryBySQLPage(sb.toString(), pageNum, pageSize,searchParams);
		//查询总数
		StringBuffer sb2=new StringBuffer();
		sb2.append("SELECT COUNT(*) FROM( ");
		sb2.append("SELECT t1.serName,t2.nums FROM");
		sb2.append(" (SELECT b.dict_id serId,b.dict_value serName FROM BAS_DICT b WHERE b.dict_type='服务类型' AND b.dict_status=0)t1,");
		sb2.append(" (SELECT DISTINCT COUNT(*) nums,t.svr_type svrType FROM CST_SERVICE t");
		if (searchParams.getYear() != null && ! searchParams.getYear().equals("")){
			System.out.println("=================>年份："+searchParams.getYear());
			sb2.append(" WHERE to_char(t.svr_create_date,'YYYY')=:year ");
		}
		sb2.append(" GROUP BY t.svr_type)t2");
		sb2.append(" WHERE t1.serId=t2.svrType)");
		BigDecimal count=(BigDecimal) dao.uniqueResultBySQL(sb2.toString(),searchParams);
		return new PageBean(pageNum,pageSize,count.intValue(),recordList);
	}

}
