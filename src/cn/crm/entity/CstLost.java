package cn.crm.entity;

import java.sql.Timestamp;

/**
 * CstLost entity. @author MyEclipse Persistence Tools
 */

public class CstLost implements java.io.Serializable {

	// Fields

	private Long lstId;
	private CstCustomer cstCustomer;
	private SysUser sysUser;
	private Timestamp lstLastOrderDate;
	private Timestamp lstLostDate;
	private String lstDelay;
	private String lstReason;
	private String lstStatus;
	private String lstFlag;

	// Constructors

	/** default constructor */
	public CstLost() {
	}

	/** minimal constructor */
	public CstLost(Long lstId, CstCustomer cstCustomer, SysUser sysUser,
			Timestamp lstLastOrderDate, String lstDelay, String lstReason,
			String lstStatus, String lstFlag) {
		this.lstId = lstId;
		this.cstCustomer = cstCustomer;
		this.sysUser = sysUser;
		this.lstLastOrderDate = lstLastOrderDate;
		this.lstDelay = lstDelay;
		this.lstReason = lstReason;
		this.lstStatus = lstStatus;
		this.lstFlag = lstFlag;
	}

	/** full constructor */
	public CstLost(Long lstId, CstCustomer cstCustomer, SysUser sysUser,
			Timestamp lstLastOrderDate, Timestamp lstLostDate, String lstDelay,
			String lstReason, String lstStatus, String lstFlag) {
		this.lstId = lstId;
		this.cstCustomer = cstCustomer;
		this.sysUser = sysUser;
		this.lstLastOrderDate = lstLastOrderDate;
		this.lstLostDate = lstLostDate;
		this.lstDelay = lstDelay;
		this.lstReason = lstReason;
		this.lstStatus = lstStatus;
		this.lstFlag = lstFlag;
	}

	// Property accessors

	public Long getLstId() {
		return this.lstId;
	}

	public void setLstId(Long lstId) {
		this.lstId = lstId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public Timestamp getLstLastOrderDate() {
		return this.lstLastOrderDate;
	}

	public void setLstLastOrderDate(Timestamp lstLastOrderDate) {
		this.lstLastOrderDate = lstLastOrderDate;
	}

	public Timestamp getLstLostDate() {
		return this.lstLostDate;
	}

	public void setLstLostDate(Timestamp lstLostDate) {
		this.lstLostDate = lstLostDate;
	}

	public String getLstDelay() {
		return this.lstDelay;
	}

	public void setLstDelay(String lstDelay) {
		this.lstDelay = lstDelay;
	}

	public String getLstReason() {
		return this.lstReason;
	}

	public void setLstReason(String lstReason) {
		this.lstReason = lstReason;
	}

	public String getLstStatus() {
		return this.lstStatus;
	}

	public void setLstStatus(String lstStatus) {
		this.lstStatus = lstStatus;
	}

	public String getLstFlag() {
		return this.lstFlag;
	}

	public void setLstFlag(String lstFlag) {
		this.lstFlag = lstFlag;
	}

}