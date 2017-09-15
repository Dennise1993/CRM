package cn.crm.common.util;
/**
 * 搜索条件封参数装类
 * @author xupan
 *	查询条件很所时可以将查询条件封装到该类中，添加get/set方法
 */
public class SearchParams implements java.io.Serializable{
	private String roleId; //角色id
	private String roleName;//角色名
	private String usrId;//用户id
	private String usrName;//用户名
	
	private String lostCustomerName;//流失客户名称
	private String lostManageName;//流失客户的客户经理
	
	private String custName;//客户贡献分析客户姓名
	private String year;//年份
	
	 private String svrType;
     private String svrTitle;
     private String svrCustName;
     private String svrStatus;
     private String startSvrCreateDate;
     private String endSvrCreateDate;
	
	//--------------
     private String cusName;//客户名称
 	private String title;//概要
 	private String linkMan;//联系人
 	
 	
 	//---------------------
 	private String custNo;
 	private String customerName;
	private String custRegion;
	private String custManagerName;
	private String custLevelLabel;
	
	
	
	//------------------
	private String lostcustName;
	private String lostCustManagerName;
	private String lostStatus;
	
	
	
	@Override
	public String toString() {
		return "SearchParams [lostCustManagerName=" + lostCustManagerName
				+ ", lostStatus=" + lostStatus + ", lostcustName="
				+ lostcustName + "]";
	}

	public String getLostcustName() {
		return lostcustName;
	}

	public void setLostcustName(String lostcustName) {
		this.lostcustName = lostcustName;
	}

	public String getLostCustManagerName() {
		return lostCustManagerName;
	}

	public void setLostCustManagerName(String lostCustManagerName) {
		this.lostCustManagerName = lostCustManagerName;
	}

	public String getLostStatus() {
		return lostStatus;
	}

	public void setLostStatus(String lostStatus) {
		this.lostStatus = lostStatus;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCusName() {
 		return cusName;
 	}
 	public void setCusName(String cusName) {
 		this.cusName = cusName;
 	}
 	public String getTitle() {
 		return title;
 	}
 	public void setTitle(String title) {
 		this.title = title;
 	}
 	public String getLinkMan() {
 		return linkMan;
 	}
 	public void setLinkMan(String linkMan) {
 		this.linkMan = linkMan;
 	}

	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	
	public String getUsrId() {
		return usrId;
	}


	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}




	public String getUsrName() {
		return usrName;
	}


	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}


	public String getLostCustomerName() {
		return lostCustomerName;
	}


	public void setLostCustomerName(String lostCustomerName) {
		this.lostCustomerName = lostCustomerName;
	}


	public String getLostManageName() {
		return lostManageName;
	}


	public void setLostManageName(String lostManageName) {
		this.lostManageName = lostManageName;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}




	public String getSvrType() {
		return svrType;
	}


	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}


	public String getSvrTitle() {
		return svrTitle;
	}


	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}


	public String getSvrCustName() {
		return svrCustName;
	}


	public void setSvrCustName(String svrCustName) {
		this.svrCustName = svrCustName;
	}


	public String getSvrStatus() {
		return svrStatus;
	}


	public void setSvrStatus(String svrStatus) {
		this.svrStatus = svrStatus;
	}


	public String getStartSvrCreateDate() {
		return startSvrCreateDate;
	}


	public void setStartSvrCreateDate(String startSvrCreateDate) {
		this.startSvrCreateDate = startSvrCreateDate;
	}


	public String getEndSvrCreateDate() {
		return endSvrCreateDate;
	}


	public void setEndSvrCreateDate(String endSvrCreateDate) {
		this.endSvrCreateDate = endSvrCreateDate;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getCustRegion() {
		return custRegion;
	}
	public void setCustRegion(String custRegion) {
		this.custRegion = custRegion;
	}
	public String getCustManagerName() {
		return custManagerName;
	}
	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName;
	}
	public String getCustLevelLabel() {
		return custLevelLabel;
	}
	public void setCustLevelLabel(String custLevelLabel) {
		this.custLevelLabel = custLevelLabel;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	
	
}
