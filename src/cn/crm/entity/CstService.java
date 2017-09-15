package cn.crm.entity;

import java.util.Date;



/**
 * CstService entity. @author MyEclipse Persistence Tools
 */

public class CstService implements java.io.Serializable {

	// Fields

	private Long svrId;
	private CstCustomer cstCustomer; //公司名字
	private BasDict basDict; //服务词典
	private SysUser sysUserBySvrCreateId; //创建人姓名
	private SysUser sysUserBySvrDueId; //分配用户
	private String svrTitle;  //服务标题
	private String svrStatus; //服务状态
	private String svrRequest; //服务请求
	private Date svrCreateDate; //创建时间
	private Date svrDueDate; //分配时间
	private String svrDeal;  //处理请求
	private Date svrDealDate; //处理时间
	private String svrResult;  //处理结果
	private String svrSatisfy; //满意度
	private String svrFlag;  //是否删除

	// Constructors

	/** default constructor */
	public CstService() {
	}

	/** minimal constructor */
	public CstService(Long svrId, CstCustomer cstCustomer, BasDict basDict,
			SysUser sysUserBySvrCreateId, String svrRequest) {
		this.svrId = svrId;
		this.setCstCustomer(cstCustomer);
		this.basDict = basDict;
		this.sysUserBySvrCreateId = sysUserBySvrCreateId;
		this.svrRequest = svrRequest;
	}

	/** full constructor */
	public CstService(Long svrId, CstCustomer cstCustomer, BasDict basDict,
			SysUser sysUserBySvrCreateId, SysUser sysUserBySvrDueId,
			String svrTitle, String svrStatus, String svrRequest,
			Date svrCreateDate, Date svrDueDate, String svrDeal,
			Date svrDealDate, String svrResult, String svrSatisfy,
			String svrFlag) {
		this.svrId = svrId;
		this.setCstCustomer(cstCustomer);
		this.basDict = basDict;
		this.sysUserBySvrCreateId = sysUserBySvrCreateId;
		this.sysUserBySvrDueId = sysUserBySvrDueId;
		this.svrTitle = svrTitle;
		this.svrStatus = svrStatus;
		this.svrRequest = svrRequest;
		this.svrCreateDate = svrCreateDate;
		this.svrDueDate = svrDueDate;
		this.svrDeal = svrDeal;
		this.svrDealDate = svrDealDate;
		this.svrResult = svrResult;
		this.svrSatisfy = svrSatisfy;
		this.svrFlag = svrFlag;
	}

	// Property accessors

	public Long getSvrId() {
		return this.svrId;
	}

	public void setSvrId(Long svrId) {
		this.svrId = svrId;
	}

	

	public BasDict getBasDict() {
		return this.basDict;
	}

	public void setBasDict(BasDict basDict) {
		this.basDict = basDict;
	}

	public SysUser getSysUserBySvrCreateId() {
		return this.sysUserBySvrCreateId;
	}

	public void setSysUserBySvrCreateId(SysUser sysUserBySvrCreateId) {
		this.sysUserBySvrCreateId = sysUserBySvrCreateId;
	}

	public SysUser getSysUserBySvrDueId() {
		return this.sysUserBySvrDueId;
	}

	public void setSysUserBySvrDueId(SysUser sysUserBySvrDueId) {
		this.sysUserBySvrDueId = sysUserBySvrDueId;
	}

	public String getSvrTitle() {
		return this.svrTitle;
	}

	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}

	public String getSvrStatus() {
		return this.svrStatus;
	}

	public void setSvrStatus(String svrStatus) {
		this.svrStatus = svrStatus;
	}

	public String getSvrRequest() {
		return this.svrRequest;
	}

	public void setSvrRequest(String svrRequest) {
		this.svrRequest = svrRequest;
	}

	public Date getSvrCreateDate() {
		return this.svrCreateDate;
	}

	public void setSvrCreateDate(Date svrCreateDate) {
		this.svrCreateDate = svrCreateDate;
	}

	public Date getSvrDueDate() {
		return this.svrDueDate;
	}

	public void setSvrDueDate(Date svrDueDate) {
		this.svrDueDate = svrDueDate;
	}

	public String getSvrDeal() {
		return this.svrDeal;
	}

	public void setSvrDeal(String svrDeal) {
		this.svrDeal = svrDeal;
	}

	public Date getSvrDealDate() {
		return this.svrDealDate;
	}

	public void setSvrDealDate(Date svrDealDate) {
		this.svrDealDate = svrDealDate;
	}

	public String getSvrResult() {
		return this.svrResult;
	}

	public void setSvrResult(String svrResult) {
		this.svrResult = svrResult;
	}

	public String getSvrSatisfy() {
		return this.svrSatisfy;
	}

	public void setSvrSatisfy(String svrSatisfy) {
		this.svrSatisfy = svrSatisfy;
	}

	public String getSvrFlag() {
		return this.svrFlag;
	}

	public void setSvrFlag(String svrFlag) {
		this.svrFlag = svrFlag;
	}

	public CstCustomer getCstCustomer() {
		return cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

}