package cn.crm.custer.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;

import cn.crm.custer.biz.ScstCustomerBiz;
import cn.crm.custer.blur.cstCust;
import cn.crm.entity.BasDict;
import cn.crm.entity.CstCustomer;
import cn.crm.entity.SysUser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 客户关系模型的action
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("all")
public class ScstCustomerAction extends ActionSupport implements
		ModelDriven<cstCust> {
	private Integer allpage;// 划分的总页数
	private Integer pageindex;// 当前页数
	private ScstCustomerBiz customerBiz;
	private List<CstCustomer> cuslist;// 分页显示（集合）
	private cstCust cstCust;// 查询条件类
    private Integer temp;//一个常量
    private CstCustomer tomer;//得到一个CstCustomer实例
    private Map<String, Object> map=new HashMap<String, Object>();//声明一个Map集合
    private List<SysUser> syslist=new ArrayList<SysUser>();//查询所有的经理信息集合
    private List<BasDict>  baslist=new ArrayList<BasDict>();//查询所有的等级
    private Long jingli;//编辑数据时客户经理的id
    private Long dengji;//编辑数据时客户等级的id
    
    
    
    
    
	public List<BasDict> getBaslist() {
		return baslist;
	}

	public void setBaslist(List<BasDict> baslist) {
		this.baslist = baslist;
	}

	public List<SysUser> getSyslist() {
		return syslist;
	}

	public void setSyslist(List<SysUser> syslist) {
		this.syslist = syslist;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Long getJingli() {
		return jingli;
	}

	public void setJingli(Long jingli) {
		this.jingli = jingli;
	}

	public Long getDengji() {
		return dengji;
	}

	public void setDengji(Long dengji) {
		this.dengji = dengji;
	}

	public CstCustomer getTomer() {
		return tomer;
	}

	public void setTomer(CstCustomer tomer) {
		this.tomer = tomer;
	}

	public Integer getTemp() {
		return temp;
	}

	public void setTemp(Integer temp) {
		this.temp = temp;
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

	public List<CstCustomer> getCuslist() {
		return cuslist;
	}

	public void setCuslist(List<CstCustomer> cuslist) {
		this.cuslist = cuslist;
	}

	public void setCustomerBiz(ScstCustomerBiz customerBiz) {
		this.customerBiz = customerBiz;
	}
	
	
	//调用集合方法
    public void getlist(){
    	//查询所有的经理信息集合
        syslist=customerBiz.searchUser();
        //查询所有的等级集合
        baslist=customerBiz.searchBas();
    }
	/**
	 * 客户关系模型首页显示并分页
	 * 
	 * @return
	 */
	public String customerShow() {
		System.out.println("--------------->进入分页方法<---------------");
		Integer pagesize = 4;
		allpage = customerBiz.countPage(pagesize);
		if (pageindex == null || "".equals(pageindex)) {
			pageindex = 1;
		}
		if (pageindex < 1) {
			pageindex = 1;
		}
		if (pageindex > allpage) {
			pageindex = allpage;
		}
        this.getlist();
		cuslist = customerBiz.searchCstCustomer(pagesize, pageindex);
		if (cuslist != null && cuslist.size() > 0 ) {
			return "cussuccess";
		}
		return "cuserror";
	}

	/**
	 * 客户关系模型的模糊查询并分页显示
	 * 
	 * @return
	 */
	public String customerFaintly() {
		temp=1;
		Integer pagesize = 4;
		allpage = customerBiz.faintlyCountPage(cstCust, pagesize);
		
		if (pageindex == null || "".equals(pageindex)) {
			pageindex = 1;
		}
		if (pageindex < 1) {
			pageindex = 1;
		}
		if (pageindex > allpage) {
			pageindex = allpage;
		}		
		this.getlist();
		cuslist = customerBiz.searchFaintly(cstCust, pagesize, pageindex);
		
			return "faisuccess";
		
	}
	
	/**
	 * 通过id显示一条信息
	 */
     public String tomerShow(){
    	 map.put("1", "☆");
    	 map.put("2", "☆☆");
    	 map.put("3", "☆☆☆");
    	 map.put("4", "☆☆☆☆");
    	 map.put("5", "☆☆☆☆☆");
    	
    	 this.getlist();
 		 String str=tomer.getCustNo();
    	 tomer=customerBiz.searchOne(str);
    	 return "tosuccess";
     }
     
     /**
      * 保存编辑的数据
      */
     public String tomerUpda(){
    	 
    	SysUser sysUser=new SysUser();
    	tomer.setSysUser(sysUser);
    	sysUser.setUsrId(jingli);
    	BasDict basDict=new BasDict();
    	basDict.setDictId(dengji);
    	tomer.setBasDict(basDict);
    	customerBiz.updatecustomer(tomer);
    	 return "upsuccess";
     }
     
     
  public String tomerDel(){
	  
	  customerBiz.deletecustomer(tomer);
	  return "delsuccess";
  }
     
     
     
     
	/**
	 * 注入一个实体类
	 */
	public cstCust getModel() {
		if (cstCust == null) {

			cstCust = new cstCust();
		}
		return cstCust;
	}
}
