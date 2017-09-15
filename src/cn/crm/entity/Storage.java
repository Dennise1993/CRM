package cn.crm.entity;

import java.math.BigDecimal;

/**
 * Storage entity. @author MyEclipse Persistence Tools
 */

public class Storage implements java.io.Serializable {

	// Fields

	private Long stkId;
	private Product product;
	private String stkWarehouse;
	private String stkWare;
	private BigDecimal stkCount;
	private String stkMemo;

	// Constructors

	/** default constructor */
	public Storage() {
	}

	/** minimal constructor */
	public Storage(Long stkId, Product product) {
		this.stkId = stkId;
		this.product = product;
	}

	/** full constructor */
	public Storage(Long stkId, Product product, String stkWarehouse,
			String stkWare, BigDecimal stkCount, String stkMemo) {
		this.stkId = stkId;
		this.product = product;
		this.stkWarehouse = stkWarehouse;
		this.stkWare = stkWare;
		this.stkCount = stkCount;
		this.stkMemo = stkMemo;
	}

	// Property accessors

	public Long getStkId() {
		return this.stkId;
	}

	public void setStkId(Long stkId) {
		this.stkId = stkId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getStkWarehouse() {
		return this.stkWarehouse;
	}

	public void setStkWarehouse(String stkWarehouse) {
		this.stkWarehouse = stkWarehouse;
	}

	public String getStkWare() {
		return this.stkWare;
	}

	public void setStkWare(String stkWare) {
		this.stkWare = stkWare;
	}

	public BigDecimal getStkCount() {
		return this.stkCount;
	}

	public void setStkCount(BigDecimal stkCount) {
		this.stkCount = stkCount;
	}

	public String getStkMemo() {
		return this.stkMemo;
	}

	public void setStkMemo(String stkMemo) {
		this.stkMemo = stkMemo;
	}

}