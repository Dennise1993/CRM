package cn.crm.entity;

import java.sql.Timestamp;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */

public class Log implements java.io.Serializable {

	// Fields

	private Long logId;
	private SysUser sysUser;
	private Timestamp logDate;
	private String logParam;
	private String logFlag;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** full constructor */
	public Log(Long logId, SysUser sysUser, Timestamp logDate, String logParam,
			String logFlag) {
		this.logId = logId;
		this.sysUser = sysUser;
		this.logDate = logDate;
		this.logParam = logParam;
		this.logFlag = logFlag;
	}

	// Property accessors

	public Long getLogId() {
		return this.logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public Timestamp getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}

	public String getLogParam() {
		return this.logParam;
	}

	public void setLogParam(String logParam) {
		this.logParam = logParam;
	}

	public String getLogFlag() {
		return this.logFlag;
	}

	public void setLogFlag(String logFlag) {
		this.logFlag = logFlag;
	}

}