package cn.crm.custer.action;

import java.util.List;

import cn.crm.custer.biz.ScstActionBiz;
import cn.crm.entity.CstActivity;
import cn.crm.entity.CstCustomer;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class ScstActiveAction extends ActionSupport {

	private ScstActionBiz scstActionBiz;// 获得接口的对象
	private String ast;// 客户编号
	private String gongname;// 客户名称
	private Integer allpage;// 划分的总页数
	private Integer pageindex;// 当前页数
	private List<CstActivity> actlist;// 活动类的集合
	private CstActivity cstact;// 获取CstActivity的对象

	public CstActivity getCstact() {
		return cstact;
	}

	public void setCstact(CstActivity cstact) {
		this.cstact = cstact;
	}

	public List<CstActivity> getActlist() {
		return actlist;
	}

	public void setActlist(List<CstActivity> actlist) {
		this.actlist = actlist;
	}

	public Integer getAllpage() {
		return allpage;
	}

	public void setAllpage(Integer allpage) {
		this.allpage = allpage;
	}

	public Integer getPageindex() {
		return pageindex;
	}

	public void setPageindex(Integer pageindex) {
		this.pageindex = pageindex;
	}

	public String getAst() {
		return ast;
	}

	public void setAst(String ast) {
		this.ast = ast;
	}

	public String getGongname() {
		return gongname;
	}

	public void setGongname(String gongname) {
		this.gongname = gongname;
	}

	public void setScstActionBiz(ScstActionBiz scstActionBiz) {
		this.scstActionBiz = scstActionBiz;
	}

	/**
	 * 活动的首页显示并分页
	 * 
	 * @return
	 */
	public String sActivity() {

		Integer pagesize = 2;
		allpage = scstActionBiz.countActivity(ast, pagesize);
		if (pageindex == null || "".equals(pageindex)) {
			pageindex = 1;
		}
		if (pageindex < 1) {
			pageindex = 1;
		}
		if (pageindex > allpage) {
			pageindex = allpage;
		}
		actlist = scstActionBiz.searchActivity(ast, pagesize, pageindex);
		
			return "actsuccess";
	}

	/**
	 * 编辑数据的时候显示一条信息
	 */
	public String scstShow() {
		cstact = scstActionBiz.searchOne(cstact.getAtvId());
		
			return "scsuccess";
	}
   /**
    * 保存一条数据并跳转到活动的首页
    */
	public String scstOne(){

		scstActionBiz.updateActivity(cstact);
		
		return "onesuccess";
	}

  /**
   * 删除一条数据并跳转到活动的首页
   */

   public String deleteActive(){
	   
	   scstActionBiz.delactivity(cstact);
	   
	   return "delsuccess";
   }
  /**
   * 跳转到添加页面
   * @return
   */
  public String scstadd(){
	  
	  return "adsuccess";
  }

  /**
   * 添加一条活动信息并跳转到活动首页显示
   */
  public String scstAddOne(){
	  CstCustomer cstCustomer=new CstCustomer();
	  cstCustomer.setCustNo(ast);
	  cstact.setCstCustomer(cstCustomer);
	  cstact.setAtvFlag("0");
	  scstActionBiz.saveActivity(cstact);
	  return "savesuccess";
  }




}
