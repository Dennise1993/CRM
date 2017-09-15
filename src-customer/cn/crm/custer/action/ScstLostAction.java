package cn.crm.custer.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.crm.custer.biz.ScstLostBiz;
import cn.crm.custer.blur.cstLos;
import cn.crm.entity.CstLost;
import cn.crm.entity.SysUser;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class ScstLostAction extends ActionSupport {

	private ScstLostBiz scstLostBiz;//获得ScstLostBiz的一个对象
	private Integer pageindex;// 当前的页数
	private Integer allpage;// 总的页数
	private List<CstLost> loslist;//分页的集合
	private List<SysUser>  cslist=new ArrayList<SysUser>();//动态查询集合
	private Map<String, Object>  map=new HashMap<String, Object>();
	private cstLos  cstlo;//动态查询的条件实例
	private Integer temp;//标识动态查询条件
	private CstLost cstLost;//获得一个CstLost实例
	
	
	
	public CstLost getCstLost() {
		return cstLost;
	}
	public void setCstLost(CstLost cstLost) {
		this.cstLost = cstLost;
	}
	public Integer getTemp() {
		return temp;
	}
	public void setTemp(Integer temp) {
		this.temp = temp;
	}
	public cstLos getCstlo() {
		return cstlo;
	}
	public void setCstlo(cstLos cstlo) {
		this.cstlo = cstlo;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public List<SysUser> getCslist() {
		return cslist;
	}
	public void setCslist(List<SysUser> cslist) {
		this.cslist = cslist;
	}
	public List<CstLost> getLoslist() {
		return loslist;
	}
	public void setLoslist(List<CstLost> loslist) {
		this.loslist = loslist;
	}
	public Integer getPageindex() {
		return pageindex;
	}
	public void setPageindex(Integer pageindex) {
		this.pageindex = pageindex;
	}
	public Integer getAllpage() {
		return allpage;
	}
	public void setAllpage(Integer allpage) {
		this.allpage = allpage;
	}
	public void setScstLostBiz(ScstLostBiz scstLostBiz) {
		this.scstLostBiz = scstLostBiz;
	}
	
	
	public String scstLostShow(){
		Integer pagesize = 2;
		allpage = scstLostBiz.countSize(pagesize);
		if (pageindex == null || "".equals(pageindex)) {
			pageindex = 1;
		}
		if (pageindex < 1) {
			pageindex = 1;
		}
		if (pageindex > allpage) {
			pageindex = allpage;
		}
		map.put("1", "预警");
		map.put("2", "暂缓流失");
		map.put("3", "已流失");
		loslist=scstLostBiz.searchLose(pagesize, pageindex);//首页显示并分页的集合
		cslist=scstLostBiz.searchUser();//动态查询的集合
		return "lossuccess";
	}
	/**
	 * 动态模糊查询并分页显示
	 */
	public String scstQuery(){
		temp=1;
		Integer pagesize = 2;
		allpage = scstLostBiz.countpage(cstlo, pagesize);
		if (pageindex == null || "".equals(pageindex)) {
			pageindex = 1;
		}
		if (pageindex < 1) {
			pageindex = 1;
		}
		if (pageindex > allpage) {
			pageindex = allpage;
		}
		map.put("1", "预警");
		map.put("2", "暂缓流失");
		map.put("3", "已流失");
		loslist=scstLostBiz.searchTrend(cstlo, pagesize, pageindex);//首页显示并分页的集合
		cslist=scstLostBiz.searchUser();//动态查询的集合
		return "quesuccess";
	}
	
	/**
	 * 确认流失并显示一条信息
	 * @return
	 */
	public String sureShow(){
		cstLost=scstLostBiz.searchOne(cstLost.getLstId());
		return "sursuccess";
	}
	/**
	 * 确认流失并更新更新信息
	 */
	public String sureUpdate(){
		
		scstLostBiz.updateLosure(cstLost);
		return "updsuccess";
	}
	
	/**
	 * 暂缓信息流失并更新到暂缓流失状态
	 */
	public String  deferUpdate(){
		
		scstLostBiz.updateloDefer(cstLost);
		return "defsuccess";
	}
}
