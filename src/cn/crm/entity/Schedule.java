package cn.crm.entity;

import java.sql.Timestamp;

/**
 * Schedule entity. @author MyEclipse Persistence Tools
 */

public class Schedule implements java.io.Serializable {

	// Fields

	private Long schId;
	private SysUser sysUser;
	private String schName;
	private String schContext;
	private Timestamp schDate;
	private String schFlag;

	// Constructors

	/** default constructor */
	public Schedule() {
	}

	/** minimal constructor */
	public Schedule(Long schId, SysUser sysUser, String schFlag) {
		this.schId = schId;
		this.sysUser = sysUser;
		this.schFlag = schFlag;
	}

	/** full constructor */
	public Schedule(Long schId, SysUser sysUser, String schName,
			String schContext, Timestamp schDate, String schFlag) {
		this.schId = schId;
		this.sysUser = sysUser;
		this.schName = schName;
		this.schContext = schContext;
		this.schDate = schDate;
		this.schFlag = schFlag;
	}

	// Property accessors

	public Long getSchId() {
		return this.schId;
	}

	public void setSchId(Long schId) {
		this.schId = schId;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getSchName() {
		return this.schName;
	}

	public void setSchName(String schName) {
		this.schName = schName;
	}

	public String getSchContext() {
		return this.schContext;
	}

	public void setSchContext(String schContext) {
		this.schContext = schContext;
	}

	public Timestamp getSchDate() {
		return this.schDate;
	}

	public void setSchDate(Timestamp schDate) {
		this.schDate = schDate;
	}

	public String getSchFlag() {
		return this.schFlag;
	}

	public void setSchFlag(String schFlag) {
		this.schFlag = schFlag;
	}

}