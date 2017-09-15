package cn.crm.rept.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.crm.common.basedao.DaoHelp;
import cn.crm.common.util.PageBean;
import cn.crm.common.util.SearchParams;
import cn.crm.entity.CstLost;
import cn.crm.entity.SysUser;
import cn.crm.rept.biz.LostAnalysisBiz;

@Component("lostAnalysisBiz")
public class LostAnalysisBizImpl implements LostAnalysisBiz {

	@Autowired
	@Qualifier("dao")
	private DaoHelp dao;

	/**
	 * 显示客户经理下拉列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SysUser> showCustManagers() {
		String hql = "from SysUser s where s.sysRole.roleId=5";
		return dao.search(hql);
	}

	// select
	// c.cstCustomer.custName,c.lstLastOrderDate,c.sysUser.usrName,c.lstReason
	// from CstLost c where 1=1
	@SuppressWarnings("unchecked")
	@Override
	public PageBean getLostPageBean(int pageNum, int pageSize,
			SearchParams searchParams) {
		// 查询列表
		System.out.println("=======================》进入获得pageBean方法");
		String origin = null;
		StringBuffer sb = new StringBuffer();
		sb.append(" from CstLost c where 1=1");
		
			if (searchParams.getLostCustomerName() != null
					&& !"".equals(searchParams.getLostCustomerName())) {
				System.out.println("===========>客户名字参数："+searchParams.getLostCustomerName());
				origin = searchParams.getLostCustomerName();
				sb.append(" and c.cstCustomer.custName like :lostCustomerName");
				searchParams.setLostCustomerName("%"
						+ searchParams.getLostCustomerName()+"%");
			}
			if (searchParams.getLostManageName() != null
					&& !"".equals(searchParams.getLostManageName())) {
				System.out.println("===========>经理名字参数："+searchParams.getLostManageName());
				sb.append(" and c.sysUser.usrName =:lostManageName");
			}
		
		List<CstLost> lostCusList = dao.getByPage(sb.toString(), searchParams,
				pageNum, pageSize);
		System.out.println("==================>集合数量："+lostCusList.size());
		for(CstLost c:lostCusList){
			System.out.println("-----------------------------------------------------------------");
			System.out.println("流失客户名字："+c.getCstCustomer().getCustName());
			System.out.println("客户经理名字："+c.getSysUser().getUsrName());
			System.out.println("-----------------------------------------------------------------");
		}
		System.out.println("========================================================");
		// 查询数量
		StringBuffer sb2 = new StringBuffer("select count(*) from CstLost c where 1=1 ");
		
			if (searchParams.getLostCustomerName() != null
					&& !"".equals(searchParams.getLostCustomerName())) {
				System.out.println("===========>客户名字参数2"+searchParams.getLostCustomerName());
				sb2.append(" and c.cstCustomer.custName like :lostCustomerName");
				
			}
			if (searchParams.getLostManageName() != null
					&& !"".equals(searchParams.getLostManageName())) {
				System.out.println("===========>经理名字参数2："+searchParams.getLostManageName());
				sb2.append(" and c.sysUser.usrName =:lostManageName");
			
		}
		
		Long count = (Long) dao.uniqueResult(sb2.toString(), searchParams);
		System.out.println("======================>总条目："+count);
		
		searchParams.setLostCustomerName(origin);
		
		return new PageBean(pageNum, pageSize, count.intValue(), lostCusList);
	}

}
