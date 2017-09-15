package cn.crm.base.entity;

public class QueryProductIf {
	private String prodName;			//商品名称
	private String prodType;			//商品型号
	private String prodBatch;			//商品批次
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getProdBatch() {
		return prodBatch;
	}
	public void setProdBatch(String prodBatch) {
		this.prodBatch = prodBatch;
	}
	public QueryProductIf() {
	}
	
}
