package model;

import java.util.HashSet;
import java.util.Set;

/**
 * TbUser entity. @author MyEclipse Persistence Tools
 */

public class TbUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbDepartment tbDepartment;
	private String name;
	private String password;
	private Boolean gender;
	private String iconName;
	private String email;
	private Long phone;
	private Boolean workingState;
	private String reservedWord;
	private Set tbNoticeInteractionsForToUserId = new HashSet();
	private Set tbMeetings = new HashSet();
	private Set tbNoticeInteractionsForFromUserId = new HashSet();
	private Set tbAdmins= new HashSet();

	// Constructors

	/** default constructor */
	public TbUser() {
	}

	/** minimal constructor */
	public TbUser(Integer id, TbDepartment tbDepartment, String name,
			String password, Boolean gender, String iconName, String email,
			Long phone, Boolean workingState) {
		this.id = id;
		this.tbDepartment = tbDepartment;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.iconName = iconName;
		this.email = email;
		this.phone = phone;
		this.workingState = workingState;
	}

	/** full constructor */
	public TbUser(Integer id, TbDepartment tbDepartment, String name,
			String password, Boolean gender, String iconName, String email,
			Long phone, Boolean workingState, String reservedWord,
			Set tbNoticeInteractionsForToUserId, Set tbMeetings, Set tbNoticeInteractionsForFromUserId,
			Set tbAdmins) {
		this.id = id;
		this.tbDepartment = tbDepartment;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.iconName = iconName;
		this.email = email;
		this.phone = phone;
		this.workingState = workingState;
		this.reservedWord = reservedWord;
		this.tbNoticeInteractionsForToUserId = tbNoticeInteractionsForToUserId;
		this.tbMeetings = tbMeetings;
		this.tbNoticeInteractionsForFromUserId = tbNoticeInteractionsForFromUserId;
		this.tbAdmins=tbAdmins;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TbDepartment getTbDepartment() {
		return this.tbDepartment;
	}

	public void setTbDepartment(TbDepartment tbDepartment) {
		this.tbDepartment = tbDepartment;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getGender() {
		return this.gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getIconName() {
		return this.iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Boolean getWorkingState() {
		return this.workingState;
	}

	public void setWorkingState(Boolean workingState) {
		this.workingState = workingState;
	}

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}

	public Set getTbNoticeInteractionsForToUserId() {
		return this.tbNoticeInteractionsForToUserId;
	}

	public void setTbNoticeInteractionsForToUserId(
			Set tbNoticeInteractionsForToUserId) {
		this.tbNoticeInteractionsForToUserId = tbNoticeInteractionsForToUserId;
	}

	public Set getTbMeetings() {
		return this.tbMeetings;
	}

	public void setTbMeetings(Set tbMeetings) {
		this.tbMeetings = tbMeetings;
	}
	public Set getTbNoticeInteractionsForFromUserId() {
		return this.tbNoticeInteractionsForFromUserId;
	}

	public void setTbNoticeInteractionsForFromUserId(
			Set tbNoticeInteractionsForFromUserId) {
		this.tbNoticeInteractionsForFromUserId = tbNoticeInteractionsForFromUserId;
	}

	public Set getTbAdmins() {
		return tbAdmins;
	}

	public void setTbAdmins(Set tbAdmins) {
		this.tbAdmins = tbAdmins;
	}





}