package cn.crm.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * CstCustomer entity. @author MyEclipse Persistence Tools
 */

public class CstCustomer implements java.io.Serializable {

	// Fields

	private String custNo;
	private BasDict basDict;
	private SysUser sysUser;
	private String custName;
	private String custRegion;
	private String custSatisfy;
	private String custCredit;
	private String custAddress;
	private String custZip;
	private String custTel;
	private String custFax;
	private String custWebsite;
	private String custLicenceNo;
	private String custChieftain;
	private BigDecimal custBankroll;
	private BigDecimal custTurnover;
	private String custBank;
	private String custBankAccount;
	private String custLocalTaxNo;
	private String custNationalTaxNo;
	private String custStatus;
	private Set orderses = new HashSet(0);
	private Set cstLosts = new HashSet(0);
	private Set cstLinkmans = new HashSet(0);
	private Set cstActivities = new HashSet(0);
	private Set cstServices = new HashSet(0);

	// Constructors

	/** default constructor */
	public CstCustomer() {
	}

	/** minimal constructor */
	public CstCustomer(String custNo, BasDict basDict, SysUser sysUser,
			String custName, String custSatisfy, String custCredit,
			String custAddress, String custLicenceNo, String custChieftain,
			String custBank, String custBankAccount, String custLocalTaxNo,
			String custNationalTaxNo, String custStatus) {
		this.custNo = custNo;
		this.basDict = basDict;
		this.sysUser = sysUser;
		this.custName = custName;
		this.custSatisfy = custSatisfy;
		this.custCredit = custCredit;
		this.custAddress = custAddress;
		this.custLicenceNo = custLicenceNo;
		this.custChieftain = custChieftain;
		this.custBank = custBank;
		this.custBankAccount = custBankAccount;
		this.custLocalTaxNo = custLocalTaxNo;
		this.custNationalTaxNo = custNationalTaxNo;
		this.custStatus = custStatus;
	}

	/** full constructor */
	public CstCustomer(String custNo, BasDict basDict, SysUser sysUser,
			String custName, String custRegion, String custSatisfy,
			String custCredit, String custAddress, String custZip,
			String custTel, String custFax, String custWebsite,
			String custLicenceNo, String custChieftain,
			BigDecimal custBankroll, BigDecimal custTurnover, String custBank,
			String custBankAccount, String custLocalTaxNo,
			String custNationalTaxNo, String custStatus, Set orderses,
			Set cstLosts, Set cstLinkmans, Set cstActivities, Set cstServices) {
		this.custNo = custNo;
		this.basDict = basDict;
		this.sysUser = sysUser;
		this.custName = custName;
		this.custRegion = custRegion;
		this.custSatisfy = custSatisfy;
		this.custCredit = custCredit;
		this.custAddress = custAddress;
		this.custZip = custZip;
		this.custTel = custTel;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
		this.custLicenceNo = custLicenceNo;
		this.custChieftain = custChieftain;
		this.custBankroll = custBankroll;
		this.custTurnover = custTurnover;
		this.custBank = custBank;
		this.custBankAccount = custBankAccount;
		this.custLocalTaxNo = custLocalTaxNo;
		this.custNationalTaxNo = custNationalTaxNo;
		this.custStatus = custStatus;
		this.orderses = orderses;
		this.cstLosts = cstLosts;
		this.cstLinkmans = cstLinkmans;
		this.cstActivities = cstActivities;
		this.cstServices = cstServices;
	}

	// Property accessors

	public String getCustNo() {
		return this.custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public BasDict getBasDict() {
		return this.basDict;
	}

	public void setBasDict(BasDict basDict) {
		this.basDict = basDict;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustRegion() {
		return this.custRegion;
	}

	public void setCustRegion(String custRegion) {
		this.custRegion = custRegion;
	}

	public String getCustSatisfy() {
		return this.custSatisfy;
	}

	public void setCustSatisfy(String custSatisfy) {
		this.custSatisfy = custSatisfy;
	}

	public String getCustCredit() {
		return this.custCredit;
	}

	public void setCustCredit(String custCredit) {
		this.custCredit = custCredit;
	}

	public String getCustAddress() {
		return this.custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustZip() {
		return this.custZip;
	}

	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}

	public String getCustTel() {
		return this.custTel;
	}

	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}

	public String getCustFax() {
		return this.custFax;
	}

	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}

	public String getCustWebsite() {
		return this.custWebsite;
	}

	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}

	public String getCustLicenceNo() {
		return this.custLicenceNo;
	}

	public void setCustLicenceNo(String custLicenceNo) {
		this.custLicenceNo = custLicenceNo;
	}

	public String getCustChieftain() {
		return this.custChieftain;
	}

	public void setCustChieftain(String custChieftain) {
		this.custChieftain = custChieftain;
	}

	public BigDecimal getCustBankroll() {
		return this.custBankroll;
	}

	public void setCustBankroll(BigDecimal custBankroll) {
		this.custBankroll = custBankroll;
	}

	public BigDecimal getCustTurnover() {
		return this.custTurnover;
	}

	public void setCustTurnover(BigDecimal custTurnover) {
		this.custTurnover = custTurnover;
	}

	public String getCustBank() {
		return this.custBank;
	}

	public void setCustBank(String custBank) {
		this.custBank = custBank;
	}

	public String getCustBankAccount() {
		return this.custBankAccount;
	}

	public void setCustBankAccount(String custBankAccount) {
		this.custBankAccount = custBankAccount;
	}

	public String getCustLocalTaxNo() {
		return this.custLocalTaxNo;
	}

	public void setCustLocalTaxNo(String custLocalTaxNo) {
		this.custLocalTaxNo = custLocalTaxNo;
	}

	public String getCustNationalTaxNo() {
		return this.custNationalTaxNo;
	}

	public void setCustNationalTaxNo(String custNationalTaxNo) {
		this.custNationalTaxNo = custNationalTaxNo;
	}

	public String getCustStatus() {
		return this.custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getCstLosts() {
		return this.cstLosts;
	}

	public void setCstLosts(Set cstLosts) {
		this.cstLosts = cstLosts;
	}

	public Set getCstLinkmans() {
		return this.cstLinkmans;
	}

	public void setCstLinkmans(Set cstLinkmans) {
		this.cstLinkmans = cstLinkmans;
	}

	public Set getCstActivities() {
		return this.cstActivities;
	}

	public void setCstActivities(Set cstActivities) {
		this.cstActivities = cstActivities;
	}

	public Set getCstServices() {
		return this.cstServices;
	}

	public void setCstServices(Set cstServices) {
		this.cstServices = cstServices;
	}

}