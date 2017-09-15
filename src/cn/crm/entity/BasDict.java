package cn.crm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * BasDict entity. @author MyEclipse Persistence Tools
 */

public class BasDict implements java.io.Serializable {

	// Fields

	private Long dictId;
	private String dictType;
	private String dictItem;
	private String dictValue;
	private String dictIsEditable;
	private String dictStatus;
	private Set cstCustomers = new HashSet();
	private Set cstServices = new HashSet();

	// Constructors

	/** default constructor */
	public BasDict() {
	}

	/** minimal constructor */
	public BasDict(Long dictId, String dictType, String dictItem,
			String dictValue, String dictIsEditable, String dictStatus) {
		this.dictId = dictId;
		this.dictType = dictType;
		this.dictItem = dictItem;
		this.dictValue = dictValue;
		this.dictIsEditable = dictIsEditable;
		this.dictStatus = dictStatus;
	}

	/** full constructor */
	public BasDict(Long dictId, String dictType, String dictItem,
			String dictValue, String dictIsEditable, String dictStatus,
			Set cstCustomers, Set cstServices) {
		this.dictId = dictId;
		this.dictType = dictType;
		this.dictItem = dictItem;
		this.dictValue = dictValue;
		this.dictIsEditable = dictIsEditable;
		this.dictStatus = dictStatus;
		this.cstCustomers = cstCustomers;
		this.cstServices = cstServices;
	}

	// Property accessors

	public Long getDictId() {
		return this.dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public String getDictType() {
		return this.dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictItem() {
		return this.dictItem;
	}

	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}

	public String getDictValue() {
		return this.dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public String getDictIsEditable() {
		return this.dictIsEditable;
	}

	public void setDictIsEditable(String dictIsEditable) {
		this.dictIsEditable = dictIsEditable;
	}

	public String getDictStatus() {
		return this.dictStatus;
	}

	public void setDictStatus(String dictStatus) {
		this.dictStatus = dictStatus;
	}

	public Set getCstCustomers() {
		return this.cstCustomers;
	}

	public void setCstCustomers(Set cstCustomers) {
		this.cstCustomers = cstCustomers;
	}

	public Set getCstServices() {
		return this.cstServices;
	}

	public void setCstServices(Set cstServices) {
		this.cstServices = cstServices;
	}

}