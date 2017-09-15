package cn.crm.custer.action;

import java.util.List;
import java.util.Map;

import sun.org.mozilla.javascript.internal.ContextAction;
import cn.crm.custer.biz.ScstLinkBiz;
import cn.crm.entity.CstCustomer;
import cn.crm.entity.CstLinkman;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class ScstlinkAction extends ActionSupport {

	private ScstLinkBiz scstlinkBiz;// 得到scstlinkBiz对象
	private CstLinkman cstlinkman;// CstLinkman的对象
	private String ast;// 客户对象的编号
	private String gongname;// 客户对象的名称
	private List<CstLinkman> linlist;// 保存数据的集合
	private Integer pageindex;// 当前的页数
	private Integer allpage;// 总的页数
	private Long linkid;// 联系人的id号

	public CstLinkman getCstlinkman() {
		return cstlinkman;
	}

	public void setCstlinkman(CstLinkman cstlinkman) {
		this.cstlinkman = cstlinkman;
	}

	public Long getLinkid() {
		return linkid;
	}

	public void setLinkid(Long linkid) {
		this.linkid = linkid;
	}

	public String getGongname() {
		return gongname;
	}

	public void setGongname(String gongname) {
		this.gongname = gongname;
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

	public List<CstLinkman> getLinlist() {
		return linlist;
	}

	public void setLinlist(List<CstLinkman> linlist) {
		this.linlist = linlist;
	}

	public void setScstlinkBiz(ScstLinkBiz scstlinkBiz) {
		this.scstlinkBiz = scstlinkBiz;
	}

	public String getAst() {
		return ast;
	}

	public void setAst(String ast) {
		this.ast = ast;
	}

	/**
	 * 负责联系人模块首页显示并分页
	 * 
	 * @return
	 */
	public String cusLinkShow() {
		
		Integer pagesize = 2;
		allpage = scstlinkBiz.countpage(ast, pagesize);
		if (pageindex == null || "".equals(pageindex)) {
			pageindex = 1;
		}
		if (pageindex < 1) {
			pageindex = 1;
		}
		if (pageindex > allpage) {
			pageindex = allpage;
		}
		linlist = scstlinkBiz.searchcstlink(ast, pagesize, pageindex);
			return "linsuccess";

	}

	/**
	 * 编辑数据的时候显示一条信息
	 * 
	 * @return
	 */
	public String cstOneShow() {
		System.out.println("djeionfdk:" + cstlinkman.getLkmId());
		cstlinkman = scstlinkBiz.searchOne(cstlinkman.getLkmId());
		
			return "lsuccess";
	}

	/**
	 * 保存联系人信息
	 */
	public String preserveLink() {
		cstlinkman.setLkmFlag("0");
		CstCustomer cstCustomer = new CstCustomer();
		cstCustomer.setCustNo(ast);
		cstlinkman.setCstCustomer(cstCustomer);
		scstlinkBiz.updateLinkman(cstlinkman);
		return "presuccess";
	}

	/**
	 * 删除联系人信息
	 */
	public String deleteLink() {
		boolean flag = scstlinkBiz.deleLinkman(cstlinkman.getLkmId());
		return "delsuccess";

	}
	/**
	 * 实现页面跳转   
	 * @return
	 */
	public String zhuanLink(){
		return "zhusuccess";
	}

	/**
	 * 保存一条联系人信息
	 */
	public String saveLink() {
		
		cstlinkman.setLkmFlag("0");
		CstCustomer cstCustomer = new CstCustomer();
		cstCustomer.setCustNo(ast);
		cstlinkman.setCstCustomer(cstCustomer);
		scstlinkBiz.saveMan(cstlinkman);

		return "savsuccess";
	}
}
