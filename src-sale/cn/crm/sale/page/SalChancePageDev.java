package cn.crm.sale.page;

import java.util.Date;


/**
 *  销售机会管理页面实现类
 *  模糊查询
 */
public class SalChancePageDev {
	private String chcCustName;//客户名称
	private String chcLinkman;//联系人
	private Date chcCreateDate;//创建时间
	
	public Date getChcCreateDate() {
		return chcCreateDate;
	}

	public void setChcCreateDate(Date chcCreateDate) {
		this.chcCreateDate = chcCreateDate;
	}

	public String getChcCustName() {
		return chcCustName;
	}

	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}

	public String getChcLinkman() {
		return chcLinkman;
	}

	public void setChcLinkman(String chcLinkman) {
		this.chcLinkman = chcLinkman;
	}

	

	public SalChancePageDev() {
		
	}

}
