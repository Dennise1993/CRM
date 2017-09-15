package cn.crm.entity;

import java.sql.Timestamp;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Long msgId;
	private SysUser sysUserByMsgReceiveUserId;
	private SysUser sysUserByMsgSendUserId;
	private String msgParam;
	private Timestamp msgSendDate;
	private Timestamp msgReceiveDate;
	private String msgReceiveParam;
	private String msgStatus;
	private String msgFlag;
	private String msgTitle;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Long msgId, SysUser sysUserByMsgReceiveUserId,
			SysUser sysUserByMsgSendUserId, String msgParam,
			Timestamp msgSendDate, String msgStatus, String msgFlag,
			String msgTitle) {
		this.msgId = msgId;
		this.sysUserByMsgReceiveUserId = sysUserByMsgReceiveUserId;
		this.sysUserByMsgSendUserId = sysUserByMsgSendUserId;
		this.msgParam = msgParam;
		this.msgSendDate = msgSendDate;
		this.msgStatus = msgStatus;
		this.msgFlag = msgFlag;
		this.msgTitle = msgTitle;
	}

	/** full constructor */
	public Message(Long msgId, SysUser sysUserByMsgReceiveUserId,
			SysUser sysUserByMsgSendUserId, String msgParam,
			Timestamp msgSendDate, Timestamp msgReceiveDate,
			String msgReceiveParam, String msgStatus, String msgFlag,
			String msgTitle) {
		this.msgId = msgId;
		this.sysUserByMsgReceiveUserId = sysUserByMsgReceiveUserId;
		this.sysUserByMsgSendUserId = sysUserByMsgSendUserId;
		this.msgParam = msgParam;
		this.msgSendDate = msgSendDate;
		this.msgReceiveDate = msgReceiveDate;
		this.msgReceiveParam = msgReceiveParam;
		this.msgStatus = msgStatus;
		this.msgFlag = msgFlag;
		this.msgTitle = msgTitle;
	}

	// Property accessors

	public Long getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public SysUser getSysUserByMsgReceiveUserId() {
		return this.sysUserByMsgReceiveUserId;
	}

	public void setSysUserByMsgReceiveUserId(SysUser sysUserByMsgReceiveUserId) {
		this.sysUserByMsgReceiveUserId = sysUserByMsgReceiveUserId;
	}

	public SysUser getSysUserByMsgSendUserId() {
		return this.sysUserByMsgSendUserId;
	}

	public void setSysUserByMsgSendUserId(SysUser sysUserByMsgSendUserId) {
		this.sysUserByMsgSendUserId = sysUserByMsgSendUserId;
	}

	public String getMsgParam() {
		return this.msgParam;
	}

	public void setMsgParam(String msgParam) {
		this.msgParam = msgParam;
	}

	public Timestamp getMsgSendDate() {
		return this.msgSendDate;
	}

	public void setMsgSendDate(Timestamp msgSendDate) {
		this.msgSendDate = msgSendDate;
	}

	public Timestamp getMsgReceiveDate() {
		return this.msgReceiveDate;
	}

	public void setMsgReceiveDate(Timestamp msgReceiveDate) {
		this.msgReceiveDate = msgReceiveDate;
	}

	public String getMsgReceiveParam() {
		return this.msgReceiveParam;
	}

	public void setMsgReceiveParam(String msgReceiveParam) {
		this.msgReceiveParam = msgReceiveParam;
	}

	public String getMsgStatus() {
		return this.msgStatus;
	}

	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}

	public String getMsgFlag() {
		return this.msgFlag;
	}

	public void setMsgFlag(String msgFlag) {
		this.msgFlag = msgFlag;
	}

	public String getMsgTitle() {
		return this.msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

}