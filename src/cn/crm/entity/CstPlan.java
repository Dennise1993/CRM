package cn.crm.entity;

import java.sql.Timestamp;

/**
 * CstPlan entity. @author MyEclipse Persistence Tools
 */

public class CstPlan implements java.io.Serializable {

	// Fields

	private Long plaId;
	private SalChance salChance;
	private Timestamp plaDate;
	private String plaTodo;
	private String plaResult;
	private String plaFlag;

	// Constructors

	/** default constructor */
	public CstPlan() {
	}

	/** minimal constructor */
	public CstPlan(Long plaId, SalChance salChance, Timestamp plaDate,
			String plaFlag) {
		this.plaId = plaId;
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaFlag = plaFlag;
	}

	/** full constructor */
	public CstPlan(Long plaId, SalChance salChance, Timestamp plaDate,
			String plaTodo, String plaResult, String plaFlag) {
		this.plaId = plaId;
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
		this.plaResult = plaResult;
		this.plaFlag = plaFlag;
	}

	// Property accessors

	public Long getPlaId() {
		return this.plaId;
	}

	public void setPlaId(Long plaId) {
		this.plaId = plaId;
	}

	public SalChance getSalChance() {
		return this.salChance;
	}

	public void setSalChance(SalChance salChance) {
		this.salChance = salChance;
	}

	public Timestamp getPlaDate() {
		return this.plaDate;
	}

	public void setPlaDate(Timestamp plaDate) {
		this.plaDate = plaDate;
	}

	public String getPlaTodo() {
		return this.plaTodo;
	}

	public void setPlaTodo(String plaTodo) {
		this.plaTodo = plaTodo;
	}

	public String getPlaResult() {
		return this.plaResult;
	}

	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}

	public String getPlaFlag() {
		return this.plaFlag;
	}

	public void setPlaFlag(String plaFlag) {
		this.plaFlag = plaFlag;
	}

}