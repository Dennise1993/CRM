package cn.crm.entity;

import java.util.Date;

/**
 * 
 * 模糊动态查询实体类
 * 
 * @author wangjun
 * 
 */
public class CstServiceVague {

	private String name; // 客户姓名
	private Long id; // 服务类型
	private String service; 
	private Date date; // 查询时间
	private String svrType;// 服务状态

	public CstServiceVague() {
		super();
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	

	

	public CstServiceVague(String name, String service, Date date) {
		super();
		this.name = name;
		this.service = service;
		this.date = date;
	}

	public CstServiceVague(String name, Date date) {

		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSvrType() {
		return svrType;
	}

	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}
}
