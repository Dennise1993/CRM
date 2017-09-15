package cn.crm.base.entity;
/**
 * 查询条件类
 */
public class QueryBaseIf {
	private String dictType;		//类别
	private String dictItem;		//条目
	private String dictValue;		//值
	
	
	public String getDictType() {
		return dictType;
	}


	public void setDictType(String dictType) {
		this.dictType = dictType;
	}


	public String getDictItem() {
		return dictItem;
	}


	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}


	public String getDictValue() {
		return dictValue;
	}


	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}


	public QueryBaseIf(){
		
	}
	
	
}
