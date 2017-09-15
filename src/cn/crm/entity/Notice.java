package cn.crm.entity;

import java.sql.Timestamp;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	private Long notId;
	private SysUser sysUser;
	private String notParam;
	private Timestamp notCreatedate;
	private String notFlag;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** full constructor */
	public Notice(Long notId, SysUser sysUser, String notParam,
			Timestamp notCreatedate, String notFlag) {
		this.notId = notId;
		this.sysUser = sysUser;
		this.notParam = notParam;
		this.notCreatedate = notCreatedate;
		this.notFlag = notFlag;
	}

	// Property accessors

	public Long getNotId() {
		return this.notId;
	}

	public void setNotId(Long notId) {
		this.notId = notId;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getNotParam() {
		return this.notParam;
	}

	public void setNotParam(String notParam) {
		this.notParam = notParam;
	}

	public Timestamp getNotCreatedate() {
		return this.notCreatedate;
	}

	public void setNotCreatedate(Timestamp notCreatedate) {
		this.notCreatedate = notCreatedate;
	}

	public String getNotFlag() {
		return this.notFlag;
	}

	public void setNotFlag(String notFlag) {
		this.notFlag = notFlag;
	}

}