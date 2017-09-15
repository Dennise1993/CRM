package cn.crm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRight entity. @author MyEclipse Persistence Tools
 */

public class SysRight implements java.io.Serializable {

	// Fields

	private Long rightCode;
	private SysRight sysRight;//上级权限
	private String rightName;//权限名称
	private String rightUrl;
	private String rightNodeType;//0菜单级别  1按钮级别
	private String rightFlag;//0正常   1删除
	private String rightNodeSrc;//按钮对应图片路径或class样式
	private Set sysRoleRights = new HashSet(0);
	private Set sysRights = new HashSet(0);//下级权限

	// Constructors

	/** default constructor */
	public SysRight() {
	}

	/** minimal constructor */
	public SysRight(Long rightCode, SysRight sysRight, String rightName,
			String rightFlag) {
		this.rightCode = rightCode;
		this.sysRight = sysRight;
		this.rightName = rightName;
		this.rightFlag = rightFlag;
	}

	/** full constructor */
	public SysRight(Long rightCode, SysRight sysRight, String rightName,
			String rightUrl, String rightNodeType, String rightFlag,
			String rightNodeSrc, Set sysRoleRights, Set sysRights) {
		this.rightCode = rightCode;
		this.sysRight = sysRight;
		this.rightName = rightName;
		this.rightUrl = rightUrl;
		this.rightNodeType = rightNodeType;
		this.rightFlag = rightFlag;
		this.rightNodeSrc = rightNodeSrc;
		this.sysRoleRights = sysRoleRights;
		this.sysRights = sysRights;
	}

	// Property accessors

	public Long getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(Long rightCode) {
		this.rightCode = rightCode;
	}

	public SysRight getSysRight() {
		return this.sysRight;
	}

	public void setSysRight(SysRight sysRight) {
		this.sysRight = sysRight;
	}

	public String getRightName() {
		return this.rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public String getRightUrl() {
		return this.rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public String getRightNodeType() {
		return this.rightNodeType;
	}

	public void setRightNodeType(String rightNodeType) {
		this.rightNodeType = rightNodeType;
	}

	public String getRightFlag() {
		return this.rightFlag;
	}

	public void setRightFlag(String rightFlag) {
		this.rightFlag = rightFlag;
	}

	public String getRightNodeSrc() {
		return this.rightNodeSrc;
	}

	public void setRightNodeSrc(String rightNodeSrc) {
		this.rightNodeSrc = rightNodeSrc;
	}

	public Set getSysRoleRights() {
		return this.sysRoleRights;
	}

	public void setSysRoleRights(Set sysRoleRights) {
		this.sysRoleRights = sysRoleRights;
	}

	public Set getSysRights() {
		return this.sysRights;
	}

	public void setSysRights(Set sysRights) {
		this.sysRights = sysRights;
	}

}