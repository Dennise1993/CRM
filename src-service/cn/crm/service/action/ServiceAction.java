package cn.crm.service.action;

import java.util.Date;
import java.util.List;

import cn.crm.common.baseaction.ActionHelper;
import cn.crm.common.baseaction.BaseAction;
import cn.crm.common.constants.Constants;
import cn.crm.common.util.PageBean;

import cn.crm.entity.BasDict;
import cn.crm.entity.CstCustomer;
import cn.crm.entity.CstService;
import cn.crm.entity.CstServiceVague;
import cn.crm.entity.SysUser;
import cn.crm.service.biz.ServiceBiz;

import com.opensymphony.xwork2.ActionContext;

/***
 * 处理服务的Action
 * 
 * @author wangjun
 * 
 */
@SuppressWarnings("serial")
public class ServiceAction extends BaseAction<CstService> {
	// 设置cstService
	private CstService cstService = new CstService();
	private String tcustomer;
	private String pid;

	// 服务类型
	private List<BasDict> serviceType;
	// 客户信息
	private List<CstCustomer> customer;
	// 没有分配任务的服务的集合
	private List<CstService> serAllot;
	// 得到分配的所有角色集合
	private List<SysUser> user;
	// 修改ID
	private String updat;
	// 分配角色ID
	private String upuser;

	private Integer temp; // 判断是不是动态查询

	public Integer getTemp() {
		return temp;
	}

	public void setTemp(Integer temp) {
		this.temp = temp;
	}

	private Integer pageIndex = 1; // 第几页
	private Integer pageSize = 4; // 每页显示多少条
	private Integer pageTotal; // 总页数
	private Integer totalSevicce;// 总条数

	private CstServiceVague vague = new CstServiceVague();// 动态模糊查询实体类

	private String name;// 接收模糊查询的姓名
	private String service;// 接收服务类型
	private Date date;// 接收查询时间

	private Integer pageCount;// 总条数
	private Long sertype;// 接受JSP页面传过来的服务类型

	public Long getSertype() {
		return sertype;
	}

	public void setSertype(Long sertype) {
		this.sertype = sertype;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getTotalSevicce() {
		return totalSevicce;
	}

	public void setTotalSevicce(Integer totalSevicce) {
		this.totalSevicce = totalSevicce;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public String getUpuser() {
		return upuser;
	}

	public void setUpuser(String upuser) {
		this.upuser = upuser;
	}

	public String getUpdat() {
		return updat;
	}

	public void setUpdat(String updat) {
		this.updat = updat;
	}

	public List<SysUser> getUser() {
		return user;
	}

	public void setUser(List<SysUser> user) {
		this.user = user;
	}

	public List<CstService> getSerAllot() {
		return serAllot;
	}

	public void setSerAllot(List<CstService> serAllot) {
		this.serAllot = serAllot;
	}

	public List<CstCustomer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<CstCustomer> customer) {
		this.customer = customer;
	}

	public List<BasDict> getServiceType() {
		return serviceType;
	}

	public void setServiceType(List<BasDict> serviceType) {
		this.serviceType = serviceType;
	}

	public ServiceBiz getServiceBiz() {
		return serviceBiz;
	}

	public void setServiceBiz(ServiceBiz serviceBiz) {
		this.serviceBiz = serviceBiz;

	}

	public String getTcustomer() {
		return tcustomer;
	}

	public void setTcustomer(String tcustomer) {
		this.tcustomer = tcustomer;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Override
	public CstService getModel() {

		return cstService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CstServiceVague getVague() {
		return vague;
	}

	public void setVague(CstServiceVague vague) {
		this.vague = vague;
	}

	public CstService getCstService() {
		return cstService;
	}

	public void setCstService(CstService cstService) {
		this.cstService = cstService;
	}

	/**
	 * 1.1保存之前进入此方法加载数据
	 * 
	 * @return
	 */
	public String addServicce() {
		// ApplicationContext act = new ClassPathXmlApplicationContext(
		// "applicationContext.xml");
		// serviceBiz = (ServiceBizImpl) act.getBean("serviceBiz");
		SysUser user = (SysUser) ActionHelper.getSession(Constants.LOGIN_USER);//得到登陆的用户
		cstService.setSysUserBySvrCreateId(user);  //存储用户信息
		serviceType = serviceBiz.getServiceType(); // 得到所有服务类型
		Long maxID = (Long) serviceBiz.getMaxId().get(0); // 得到最大的ID
		cstService.setSvrId((maxID + 1)); // 得到新的ID
		System.out.println(cstService.getSvrId());
		cstService.setSvrCreateDate(new Date()); // 设置新的时间
		customer = serviceBiz.getAllCstCustomer();// 得到所有的客户信息
		return "success";
	}

	/**
	 * 1.2保存方法
	 * 
	 * @return
	 */
	public String save() {
		try {
			// System.out.println("---------------------" + tcustomer);
			// ApplicationContext act = new ClassPathXmlApplicationContext(
			// "applicationContext.xml");
			// serviceBiz = (ServiceBizImpl) act.getBean("serviceBiz");
			SysUser user = (SysUser) ActionHelper.getSession(Constants.LOGIN_USER);
			Long id = user.getUsrId();
			user.setUsrId(id);
			cstService.setSysUserBySvrCreateId(user);// 临时添加用户信息
			// System.out.println("---------------------" + pid);
			// System.out.println("yonghu" + user.getUsrId());
			CstCustomer cs = new CstCustomer(); // 保存客户的信息
			cs.setCustNo(tcustomer);
			cstService.setCstCustomer(cs);
			BasDict ba = new BasDict(); // 保存服务类型
			// System.out.println(Long.parseLong(pid));
			ba.setDictId(Long.parseLong(pid));
			cstService.setBasDict(ba);
			cstService.setSvrStatus("0");// 设置服务状态。0为未分配
			serviceBiz.saveNewService(cstService);
			return "success";
		} catch (Exception e) {
			return ERROR;
		}
		// return null;

	}

	/**
	 * 2.1分配服务前进入此方法加载数据.根据分页
	 * 
	 * @return
	 */
	public String allotservice() {
		customer = serviceBiz.getAllCstCustomer();// 得到所有的客户信息
		serviceType = serviceBiz.getServiceType();// 得到所有服务类型
		user = serviceBiz.getAllotUser(); // 得到所有客户经理，为他们分配服务
		
		SysUser user1 = (SysUser) ActionHelper.getSession(Constants.LOGIN_USER);
		
		vague.setid(sertype);// 设置动态查询服务类型
		vague.setDate(date);// 设置动态查询时间
		vague.setName(name);// 设置查询公司名字
		PageBean bean = serviceBiz.getAllByPage(user1 ,vague, pageNum, pageSize);

		ActionContext.getContext().getValueStack().push(bean);

		return "success";

	}

	/**
	 * 2.2修改分配角色，改变服务状态
	 * 
	 * @return
	 */
	public String saveAllot() {
		// System.out.println("user" + upuser);
		// // System.out.println("@@@@@@@@2222" + updat);
		// serviceType=serviceBiz.getServiceType();

		CstService cstService1 = serviceBiz.getOneService(updat).get(0);// 得到一个新的服务类实体
		cstService1.setSvrStatus("1");// 分配角色后服务状态显示为1
		SysUser user = new SysUser();
		user.setUsrId(Long.valueOf(upuser));
		cstService1.setSvrDueDate(new Date());
		cstService1.setSysUserBySvrDueId(user);
		serviceBiz.saveAllotUser(cstService1);

		return "success";
	}

	/**
	 * 2.3删除一条服务。修改状态为2
	 * 
	 * @return
	 */
	public String deleteService() {
		CstService cstService1 = serviceBiz.getOneService(updat).get(0);
		cstService1.setSvrStatus("2");// 分配角色后服务状态显示为2
		serviceBiz.saveAllotUser(cstService1); // 修改状态
		return "success";
	}

	/**
	 * 3.1 服务分配，根据用户查出该用户所有没有分配的服务
	 */
	public String dealSeivice() {
		// 先得到一个用户
		SysUser user = (SysUser) ActionHelper.getSession(Constants.LOGIN_USER);
		String id = String.valueOf(user.getUsrId());
		totalSevicce = serviceBiz.getCountServiceByID(id).size();

		customer = serviceBiz.getAllCstCustomer();// 得到所有的客户信息
		serviceType = serviceBiz.getServiceType();// 得到所有服务类型

		vague.setid(sertype);// 设置动态查询服务类型
		vague.setDate(date);// 设置动态查询时间
		vague.setName(name);// 设置查询公司名字
		PageBean bean = serviceBiz.getServiceByID(id, vague, pageNum, pageSize);

		ActionContext.getContext().getValueStack().push(bean);

		return "success";

	}

	/**
	 * 3.2处理分配的服务，先根据ID得到一条服务，
	 * 
	 * @return
	 */
	public String disposeService() {
		cstService = serviceBiz.getOneService(updat).get(0); // 根据ID得到一条服务，页面显示
		cstService.setSvrDealDate(new Date()); // 得到处理时间

		return "success";
	}

	/**
	 * 3.3 处理修改分配服务，在对此服务进行修改，更改服务状态为 3（3已处理）
	 * 
	 */
	public String saveService() {
		String id = String.valueOf(cstService.getSvrId());
		String neirong = cstService.getSvrDeal(); // 得到服务反馈内容
		CstService cstService2 = serviceBiz.getOneService(id).get(0); // 根据ID得到需要修改的服务
		cstService2.setSvrDeal(neirong); // 修改处理服务内容
		cstService2.setSvrDealDate(new Date()); // 设置处理时间
		cstService2.setSvrStatus("3");// 更改服务状态为 3（3已处理）
		serviceBiz.saveAllotUser(cstService2); // 保存修改服务
		return "success";

	}

	/**
	 * 4.1 服务反馈+动态查询
	 */

	public String feedService() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
		// 先得到一个用户
		// String id = "5";
		SysUser user = (SysUser) ActionHelper.getSession(Constants.LOGIN_USER);
		String id = String.valueOf(user.getUsrId());

		totalSevicce = serviceBiz.getFeedServiceByID(id).size();// 得到所有没有反馈的服务
		customer = serviceBiz.getAllCstCustomer();// 得到所有的客户信息
		serviceType = serviceBiz.getServiceType();// 得到所有服务类型
		vague.setid(sertype);// 设置动态查询服务类型
		vague.setDate(date);// 设置动态查询时间
		vague.setName(name);// 设置查询公司名字
		PageBean bean = serviceBiz.getFeedService(id, vague, pageNum, pageSize);
		ActionContext.getContext().getValueStack().push(bean);

		return "success";
	}

	/**
	 * 4.2处理服务反馈，加载数据
	 */
	public String feedBake() {

		System.out.println(updat);
		cstService = serviceBiz.getOneService(updat).get(0); // 根据ID得到一条服务
		System.out.println("nrirong" + cstService.getSvrResult());
		return "success";
	}

	/**
	 * 4.3保存反馈的处理
	 * 
	 * @return
	 */
	public String feedBakeSave() {
		// CstService cstService2=serviceBiz.getOneService(id).get(0);
		String id = String.valueOf(cstService.getSvrId());
		CstService cstService2 = serviceBiz.getOneService(id).get(0); // 根据ID得到需要修改的服务
		cstService2.setSvrResult(cstService.getSvrResult());
		cstService2.setSvrSatisfy(cstService.getSvrSatisfy());
		cstService2.setSvrStatus("4");// 更改服务状态为4（4 已处理反馈）
		serviceBiz.saveAllotUser(cstService2); // 保存修改服务

		return "success";
	}

	/**
	 * 5.1 服务归档 +动态模糊查询
	 * 
	 * @return
	 */
	public String filing() {
		serviceType = serviceBiz.getServiceType();// 得到所有服务类型
		vague.setid(sertype);// 设置动态查询服务类型
		vague.setDate(date);// 设置动态查询时间
		PageBean bean = serviceBiz.getFileService(vague, pageNum, pageSize);
		ActionContext.getContext().getValueStack().push(bean);
		return "success";
	}

	/**
	 * 5.2，根据ID得到一条服务
	 * 
	 */
	public String filingOne() {
		System.out.println(updat);
		cstService = serviceBiz.getOneService(updat).get(0); // 根据ID得到一条服务
		return "success";
	}
}
