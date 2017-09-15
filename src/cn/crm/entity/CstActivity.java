package cn.crm.entity;

import java.sql.Timestamp;

/**
 * CstActivity entity. @author MyEclipse Persistence Tools
 */

public class CstActivity implements java.io.Serializable {

	// Fields

	private Long atvId;
	private CstCustomer cstCustomer;
	private Timestamp atvDate;
	private String atvPlace;
	private String atvTitle;
	private String atvDesc;
	private String atvFlag;

	// Constructors

	/** default constructor */
	public CstActivity() {
	}

	/** minimal constructor */
	public CstActivity(Long atvId, CstCustomer cstCustomer, Timestamp atvDate,
			String atvPlace, String atvTitle, String atvFlag) {
		this.atvId = atvId;
		this.cstCustomer = cstCustomer;
		this.atvDate = atvDate;
		this.atvPlace = atvPlace;
		this.atvTitle = atvTitle;
		this.atvFlag = atvFlag;
	}

	/** full constructor */
	public CstActivity(Long atvId, CstCustomer cstCustomer, Timestamp atvDate,
			String atvPlace, String atvTitle, String atvDesc, String atvFlag) {
		this.atvId = atvId;
		this.cstCustomer = cstCustomer;
		this.atvDate = atvDate;
		this.atvPlace = atvPlace;
		this.atvTitle = atvTitle;
		this.atvDesc = atvDesc;
		this.atvFlag = atvFlag;
	}

	// Property accessors

	public Long getAtvId() {
		return this.atvId;
	}

	public void setAtvId(Long atvId) {
		this.atvId = atvId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public Timestamp getAtvDate() {
		return this.atvDate;
	}

	public void setAtvDate(Timestamp atvDate) {
		this.atvDate = atvDate;
	}

	public String getAtvPlace() {
		return this.atvPlace;
	}

	public void setAtvPlace(String atvPlace) {
		this.atvPlace = atvPlace;
	}

	public String getAtvTitle() {
		return this.atvTitle;
	}

	public void setAtvTitle(String atvTitle) {
		this.atvTitle = atvTitle;
	}

	public String getAtvDesc() {
		return this.atvDesc;
	}

	public void setAtvDesc(String atvDesc) {
		this.atvDesc = atvDesc;
	}

	public String getAtvFlag() {
		return this.atvFlag;
	}

	public void setAtvFlag(String atvFlag) {
		this.atvFlag = atvFlag;
	}

}