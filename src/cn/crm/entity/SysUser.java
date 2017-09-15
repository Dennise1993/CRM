package cn.crm.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Long usrId;
	private SysRole sysRole;
	private String usrName;
	private String usrPassword;
	private String usrFlag;
	private Set cstServicesForSvrCreateId = new HashSet(0);
	private Set logs = new HashSet(0);
	private Set cstServicesForSvrDueId = new HashSet(0);
	private Set salChancesForChcDueId = new HashSet(0);
	private Set notices = new HashSet(0);
	private Set messagesForMsgSendUserId = new HashSet(0);
	private Set schedules = new HashSet(0);
	private Set messagesForMsgReceiveUserId = new HashSet(0);
	private Set cstLosts = new HashSet(0);
	private Set salChancesForChcCreateId = new HashSet(0);
	private Set cstCustomers = new HashSet(0);
	
	/**
	 * 判断本用户是否有指定名称的权限
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean hasRightsByName(String name){
		Set<SysRoleRight> sysRoleRights=sysRole.getSysRoleRights();
		for(SysRoleRight roleRight:sysRoleRights){
			SysRight right =roleRight.getSysRight();
			if(right.getRightName().equals(name)){
				return true;
			}
		}
		return false;
	}
	

	/**
	 * 判断本用户是否有指定名称的权限
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean hasRightsByURL(String privUrl){
		//去掉后面的参数
		int pos = privUrl.indexOf("?");
		if(pos>-1){
			privUrl = privUrl.substring(0,pos);
		}
		//如果url不需要控制，则登录用户就可以使用
		Collection<String> allRights = (Collection<String>) ActionContext.getContext().getApplication().get("allRights");
		if(!allRights.contains(privUrl)){
			//System.out.println("22222");
			return true;
		}
		Set<SysRoleRight> sysRoleRights=sysRole.getSysRoleRights();
		for(SysRoleRight roleRight:sysRoleRights){
			SysRight right =roleRight.getSysRight();
			if(privUrl.equals(right.getRightUrl())){
				//System.out.println("11111");
				return true;
			}
		}
		return false;
	}
	

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(Long usrId, String usrName, String usrPassword,
			String usrFlag) {
		this.usrId = usrId;
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.usrFlag = usrFlag;
	}

	/** full constructor */
	public SysUser(Long usrId, SysRole sysRole, String usrName,
			String usrPassword, String usrFlag, Set cstServicesForSvrCreateId,
			Set logs, Set cstServicesForSvrDueId, Set salChancesForChcDueId,
			Set notices, Set messagesForMsgSendUserId, Set schedules,
			Set messagesForMsgReceiveUserId, Set cstLosts,
			Set salChancesForChcCreateId, Set cstCustomers) {
		this.usrId = usrId;
		this.sysRole = sysRole;
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.usrFlag = usrFlag;
		this.cstServicesForSvrCreateId = cstServicesForSvrCreateId;
		this.logs = logs;
		this.cstServicesForSvrDueId = cstServicesForSvrDueId;
		this.salChancesForChcDueId = salChancesForChcDueId;
		this.notices = notices;
		this.messagesForMsgSendUserId = messagesForMsgSendUserId;
		this.schedules = schedules;
		this.messagesForMsgReceiveUserId = messagesForMsgReceiveUserId;
		this.cstLosts = cstLosts;
		this.salChancesForChcCreateId = salChancesForChcCreateId;
		this.cstCustomers = cstCustomers;
	}

	// Property accessors

	public Long getUsrId() {
		return this.usrId;
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public String getUsrName() {
		return this.usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPassword() {
		return this.usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public String getUsrFlag() {
		return this.usrFlag;
	}

	public void setUsrFlag(String usrFlag) {
		this.usrFlag = usrFlag;
	}

	public Set getCstServicesForSvrCreateId() {
		return this.cstServicesForSvrCreateId;
	}

	public void setCstServicesForSvrCreateId(Set cstServicesForSvrCreateId) {
		this.cstServicesForSvrCreateId = cstServicesForSvrCreateId;
	}

	public Set getLogs() {
		return this.logs;
	}

	public void setLogs(Set logs) {
		this.logs = logs;
	}

	public Set getCstServicesForSvrDueId() {
		return this.cstServicesForSvrDueId;
	}

	public void setCstServicesForSvrDueId(Set cstServicesForSvrDueId) {
		this.cstServicesForSvrDueId = cstServicesForSvrDueId;
	}

	public Set getSalChancesForChcDueId() {
		return this.salChancesForChcDueId;
	}

	public void setSalChancesForChcDueId(Set salChancesForChcDueId) {
		this.salChancesForChcDueId = salChancesForChcDueId;
	}

	public Set getNotices() {
		return this.notices;
	}

	public void setNotices(Set notices) {
		this.notices = notices;
	}

	public Set getMessagesForMsgSendUserId() {
		return this.messagesForMsgSendUserId;
	}

	public void setMessagesForMsgSendUserId(Set messagesForMsgSendUserId) {
		this.messagesForMsgSendUserId = messagesForMsgSendUserId;
	}

	public Set getSchedules() {
		return this.schedules;
	}

	public void setSchedules(Set schedules) {
		this.schedules = schedules;
	}

	public Set getMessagesForMsgReceiveUserId() {
		return this.messagesForMsgReceiveUserId;
	}

	public void setMessagesForMsgReceiveUserId(Set messagesForMsgReceiveUserId) {
		this.messagesForMsgReceiveUserId = messagesForMsgReceiveUserId;
	}

	public Set getCstLosts() {
		return this.cstLosts;
	}

	public void setCstLosts(Set cstLosts) {
		this.cstLosts = cstLosts;
	}

	public Set getSalChancesForChcCreateId() {
		return this.salChancesForChcCreateId;
	}

	public void setSalChancesForChcCreateId(Set salChancesForChcCreateId) {
		this.salChancesForChcCreateId = salChancesForChcCreateId;
	}

	public Set getCstCustomers() {
		return this.cstCustomers;
	}

	public void setCstCustomers(Set cstCustomers) {
		this.cstCustomers = cstCustomers;
	}

}