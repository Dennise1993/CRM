package cn.crm.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Long odrId;
	private CstCustomer cstCustomer;
	private Timestamp odrDate;
	private String odrAddr;
	private String odrStatus;
	private Set ordersLines = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Long odrId, CstCustomer cstCustomer, Timestamp odrDate,
			String odrAddr, String odrStatus) {
		this.odrId = odrId;
		this.cstCustomer = cstCustomer;
		this.odrDate = odrDate;
		this.odrAddr = odrAddr;
		this.odrStatus = odrStatus;
	}

	/** full constructor */
	public Orders(Long odrId, CstCustomer cstCustomer, Timestamp odrDate,
			String odrAddr, String odrStatus, Set ordersLines) {
		this.odrId = odrId;
		this.cstCustomer = cstCustomer;
		this.odrDate = odrDate;
		this.odrAddr = odrAddr;
		this.odrStatus = odrStatus;
		this.ordersLines = ordersLines;
	}

	// Property accessors

	public Long getOdrId() {
		return this.odrId;
	}

	public void setOdrId(Long odrId) {
		this.odrId = odrId;
	}

	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	public Timestamp getOdrDate() {
		return this.odrDate;
	}

	public void setOdrDate(Timestamp odrDate) {
		this.odrDate = odrDate;
	}

	public String getOdrAddr() {
		return this.odrAddr;
	}

	public void setOdrAddr(String odrAddr) {
		this.odrAddr = odrAddr;
	}

	public String getOdrStatus() {
		return this.odrStatus;
	}

	public void setOdrStatus(String odrStatus) {
		this.odrStatus = odrStatus;
	}

	public Set getOrdersLines() {
		return this.ordersLines;
	}

	public void setOrdersLines(Set ordersLines) {
		this.ordersLines = ordersLines;
	}

}