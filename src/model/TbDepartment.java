package model;

import java.util.HashSet;
import java.util.Set;

/**
 * TbDepartment entity. @author MyEclipse Persistence Tools
 */

public class TbDepartment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer totalNumber;
	private Boolean state;
	private String reservedWord;
	private Set tbUsers = new HashSet(0);
	private Set tbUserApplications = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbDepartment() {
	}

	/** minimal constructor */
	public TbDepartment(String name, Integer totalNumber, Boolean state) {
		this.name = name;
		this.totalNumber = totalNumber;
		this.state = state;
	}

	/** full constructor */
	public TbDepartment(String name, Integer totalNumber, Boolean state,
			String reservedWord,Set tbUsers,
			Set tbUserApplications) {
		this.name = name;
		this.totalNumber = totalNumber;
		this.state = state;
		this.reservedWord = reservedWord;
		this.tbUsers = tbUsers;
		this.tbUserApplications = tbUserApplications;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalNumber() {
		return this.totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}
	public Set getTbUsers() {
		return this.tbUsers;
	}

	public void setTbUsers(Set tbUsers) {
		this.tbUsers = tbUsers;
	}

	public Set getTbUserApplications() {
		return this.tbUserApplications;
	}

	public void setTbUserApplications(Set tbUserApplications) {
		this.tbUserApplications = tbUserApplications;
	}

}