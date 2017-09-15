package cn.crm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private Long roleId;
	private String roleName;
	private String roleDesc;
	private String roleFlag;
	private Set sysUsers = new HashSet(0);
	private Set sysRoleRights = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** minimal constructor */
	public SysRole(Long roleId, String roleName, String roleFlag) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleFlag = roleFlag;
	}

	/** full constructor */
	public SysRole(Long roleId, String roleName, String roleDesc,
			String roleFlag, Set sysUsers, Set sysRoleRights) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.roleFlag = roleFlag;
		this.sysUsers = sysUsers;
		this.sysRoleRights = sysRoleRights;
	}

	// Property accessors

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleFlag() {
		return this.roleFlag;
	}

	public void setRoleFlag(String roleFlag) {
		this.roleFlag = roleFlag;
	}

	public Set getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(Set sysUsers) {
		this.sysUsers = sysUsers;
	}

	public Set getSysRoleRights() {
		return this.sysRoleRights;
	}

	public void setSysRoleRights(Set sysRoleRights) {
		this.sysRoleRights = sysRoleRights;
	}

}