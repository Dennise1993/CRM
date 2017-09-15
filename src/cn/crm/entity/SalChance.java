package cn.crm.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * SalChance entity. @author MyEclipse Persistence Tools
 */

public class SalChance implements java.io.Serializable {

	// Fields

	private Long chcId;
	private SysUser sysUserByChcDueId;
	private SysUser sysUserByChcCreateId;
	private String chcSource;
	private String chcCustName;
	private String chcTitle;
	private Double chcRate;
	private String chcLinkman;
	private String chcTel;
	private String chcMobile;
	private String chcDesc;
	private Timestamp chcCreateDate;
	private Timestamp chcDueDate;
	private String chcStatus;
	private String chcFlag;
	private Set cstPlans = new HashSet(0);

	// Constructors

	/** default constructor */
	public SalChance() {
	}

	/** minimal constructor */
	public SalChance(Long chcId, SysUser sysUserByChcCreateId,
			String chcCustName, String chcTitle, Double chcRate,
			String chcLinkman, String chcMobile, String chcDesc,
			Timestamp chcCreateDate, String chcStatus, String chcFlag) {
		this.chcId = chcId;
		this.sysUserByChcCreateId = sysUserByChcCreateId;
		this.chcCustName = chcCustName;
		this.chcTitle = chcTitle;
		this.chcRate = chcRate;
		this.chcLinkman = chcLinkman;
		this.chcMobile = chcMobile;
		this.chcDesc = chcDesc;
		this.chcCreateDate = chcCreateDate;
		this.chcStatus = chcStatus;
		this.chcFlag = chcFlag;
	}

	/** full constructor */
	public SalChance(Long chcId, SysUser sysUserByChcDueId,
			SysUser sysUserByChcCreateId, String chcSource, String chcCustName,
			String chcTitle, Double chcRate, String chcLinkman, String chcTel,
			String chcMobile, String chcDesc, Timestamp chcCreateDate,
			Timestamp chcDueDate, String chcStatus, String chcFlag, Set cstPlans) {
		this.chcId = chcId;
		this.sysUserByChcDueId = sysUserByChcDueId;
		this.sysUserByChcCreateId = sysUserByChcCreateId;
		this.chcSource = chcSource;
		this.chcCustName = chcCustName;
		this.chcTitle = chcTitle;
		this.chcRate = chcRate;
		this.chcLinkman = chcLinkman;
		this.chcTel = chcTel;
		this.chcMobile = chcMobile;
		this.chcDesc = chcDesc;
		this.chcCreateDate = chcCreateDate;
		this.chcDueDate = chcDueDate;
		this.chcStatus = chcStatus;
		this.chcFlag = chcFlag;
		this.cstPlans = cstPlans;
	}

	// Property accessors

	public Long getChcId() {
		return this.chcId;
	}

	public void setChcId(Long chcId) {
		this.chcId = chcId;
	}

	public SysUser getSysUserByChcDueId() {
		return this.sysUserByChcDueId;
	}

	public void setSysUserByChcDueId(SysUser sysUserByChcDueId) {
		this.sysUserByChcDueId = sysUserByChcDueId;
	}

	public SysUser getSysUserByChcCreateId() {
		return this.sysUserByChcCreateId;
	}

	public void setSysUserByChcCreateId(SysUser sysUserByChcCreateId) {
		this.sysUserByChcCreateId = sysUserByChcCreateId;
	}

	public String getChcSource() {
		return this.chcSource;
	}

	public void setChcSource(String chcSource) {
		this.chcSource = chcSource;
	}

	public String getChcCustName() {
		return this.chcCustName;
	}

	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}

	public String getChcTitle() {
		return this.chcTitle;
	}

	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}

	public Double getChcRate() {
		return this.chcRate;
	}

	public void setChcRate(Double chcRate) {
		this.chcRate = chcRate;
	}

	public String getChcLinkman() {
		return this.chcLinkman;
	}

	public void setChcLinkman(String chcLinkman) {
		this.chcLinkman = chcLinkman;
	}

	public String getChcTel() {
		return this.chcTel;
	}

	public void setChcTel(String chcTel) {
		this.chcTel = chcTel;
	}

	public String getChcMobile() {
		return this.chcMobile;
	}

	public void setChcMobile(String chcMobile) {
		this.chcMobile = chcMobile;
	}

	public String getChcDesc() {
		return this.chcDesc;
	}

	public void setChcDesc(String chcDesc) {
		this.chcDesc = chcDesc;
	}

	public Timestamp getChcCreateDate() {
		return this.chcCreateDate;
	}

	public void setChcCreateDate(Timestamp chcCreateDate) {
		this.chcCreateDate = chcCreateDate;
	}

	public Timestamp getChcDueDate() {
		return this.chcDueDate;
	}

	public void setChcDueDate(Timestamp chcDueDate) {
		this.chcDueDate = chcDueDate;
	}

	public String getChcStatus() {
		return this.chcStatus;
	}

	public void setChcStatus(String chcStatus) {
		this.chcStatus = chcStatus;
	}

	public String getChcFlag() {
		return this.chcFlag;
	}

	public void setChcFlag(String chcFlag) {
		this.chcFlag = chcFlag;
	}

	public Set getCstPlans() {
		return this.cstPlans;
	}

	public void setCstPlans(Set cstPlans) {
		this.cstPlans = cstPlans;
	}

}