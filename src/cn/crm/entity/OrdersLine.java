package cn.crm.entity;

/**
 * OrdersLine entity. @author MyEclipse Persistence Tools
 */

public class OrdersLine implements java.io.Serializable {

	// Fields

	private Long oddId;
	private Orders orders;
	private Product product;
	private Long oddCount;
	private String oddUnit;

	// Constructors

	/** default constructor */
	public OrdersLine() {
	}

	/** full constructor */
	public OrdersLine(Long oddId, Orders orders, Product product,
			Long oddCount, String oddUnit) {
		this.oddId = oddId;
		this.orders = orders;
		this.product = product;
		this.oddCount = oddCount;
		this.oddUnit = oddUnit;
	}

	// Property accessors

	public Long getOddId() {
		return this.oddId;
	}

	public void setOddId(Long oddId) {
		this.oddId = oddId;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getOddCount() {
		return this.oddCount;
	}

	public void setOddCount(Long oddCount) {
		this.oddCount = oddCount;
	}

	public String getOddUnit() {
		return this.oddUnit;
	}

	public void setOddUnit(String oddUnit) {
		this.oddUnit = oddUnit;
	}

}