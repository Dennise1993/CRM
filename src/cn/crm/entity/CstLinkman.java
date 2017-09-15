package cn.crm.entity;

/**
 * CstLinkman entity. @author MyEclipse Persistence Tools
 */

public class CstLinkman implements java.io.Serializable {

	// Fields

	private Long lkmId;
	private CstCustomer cstCustomer;
	private String lkmName;
	private String lkmSex;
	private String lkmPostion;
	private String lkmTel;
	private String lkmMobile;
	private String lkmMemo;
	private String lkmFlag;

	// Constructors

	/** default constructor */
	public CstLinkman() {
	}

	/** minimal constructor */
	public CstLinkman(Long lkmId, CstCustomer cstCustomer, String lkmName,
			String lkmTel, String lkmFlag) {
		this.lkmId = lkmId;
		this.cstCustomer = cstCustomer;
		this.lkmName = lkmName;
		this.lkmTel = lkmTel;
		this.lkmFlag = lkmFlag;
	}

	/** full constructor */
	public CstLinkman(Long lkmId, CstCustomer cstCustomer, String lkmName,
			String lkmSex, String lkmPostion, String lkmTel, String lkmMobile,
			String lkmMemo, String lkmFlag) {
		this.lkmId = lkmId;
		this.cstCustomer = cstCustomer;
		this.lkmName = lkmName;
		this.lkmSex = lkmSex;
		this.lkmPostion = lkmPostion;
		this.lkmTel = lkmTel;
		this.lkmMobile = lkmMobile;
		this.lkmMemo = lkmMemo;
		this.lkmFlag = lkmFlag;
	}

	// Property accessors

	public Long getLkmId() {
		return this.lkmId;
	}

	public void setLkmId(Long lkmId) {
		this.lkmId = lkmId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public String getLkmName() {
		return this.lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public String getLkmSex() {
		return this.lkmSex;
	}

	public void setLkmSex(String lkmSex) {
		this.lkmSex = lkmSex;
	}

	public String getLkmPostion() {
		return this.lkmPostion;
	}

	public void setLkmPostion(String lkmPostion) {
		this.lkmPostion = lkmPostion;
	}

	public String getLkmTel() {
		return this.lkmTel;
	}

	public void setLkmTel(String lkmTel) {
		this.lkmTel = lkmTel;
	}

	public String getLkmMobile() {
		return this.lkmMobile;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

	public String getLkmMemo() {
		return this.lkmMemo;
	}

	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

	public String getLkmFlag() {
		return this.lkmFlag;
	}

	public void setLkmFlag(String lkmFlag) {
		this.lkmFlag = lkmFlag;
	}

}