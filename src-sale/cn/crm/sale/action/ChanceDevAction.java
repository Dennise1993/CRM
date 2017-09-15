package cn.crm.sale.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import cn.crm.common.baseaction.BaseAction;
import cn.crm.common.util.PageBean;
import cn.crm.entity.SalChance;
import cn.crm.entity.SysUser;
import cn.crm.sale.page.SalChancePageDev;

/**
 * 这个是模糊查询的实现类 继承了BaseAction的封装方法
 */
@SuppressWarnings("serial")
public class ChanceDevAction extends BaseAction<SalChance> {
	private SalChancePageDev msgpage; // 查询条件

	private Long chaId;
	private SalChance salChance;
	List<SysUser> users;

	public List<SysUser> getUsers() {
		return users;
	}

	public void setUsers(List<SysUser> users) {
		this.users = users;
	}

	public SalChance getSalChance() {
		return salChance;
	}

	public void setSalChance(SalChance salChance) {
		this.salChance = salChance;
	}

	public Long getChaId() {
		return chaId;
	}

	public void setChaId(Long chaId) {
		this.chaId = chaId;
	}

	public SalChancePageDev getMsgpage() {
		return msgpage;
	}

	public void setMsgpage(SalChancePageDev msgpage) {
		this.msgpage = msgpage;
	}

	// 模糊和分页
	public String showSalChanceDev() {
		// msgpage.setChcCreateDate(date);
		PageBean pageBean = salChaneBiz.getSalChanceByIf(pageNum, pageSize,
				msgpage);
		ActionContext.getContext().getValueStack().push(pageBean);// 把pageBean放进值栈中
		return "success";
	}

	// 指派销售机会
	public String AddPatch() {
		// System.out.println(chaId+"---------------------------");
		salChance = salChaneBiz.showDispatch(chaId);
		users = salChaneBiz.usersBySal();
		return "success";
	}

	// 保存指派销售机会
	public String ShowPatch() {
		salChance = salChaneBiz.showDispatch(chaId);
		return "success";
	}

	// 修改销售机会
	public String AddPlan() {
		salChance = salChaneBiz.showPlan(chaId);
		users = salChaneBiz.usersBySal();
		return "success";
	}

	// 保存修改销售机会
	public String AddShowPlan() {
		salChance = salChaneBiz.showPlan(chaId);
		return "success";
	}

}
