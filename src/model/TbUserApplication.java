package model;

/**
 * TbUserApplication entity. @author MyEclipse Persistence Tools
 */

public class TbUserApplication implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbDepartment tbDepartment;
	private String name;
	private String password;
	private Boolean gender;
	private String email;
	private Long phone;
	private String reservedWord;

	// Constructors

	/** default constructor */
	public TbUserApplication() {
	}

	/** minimal constructor */
	public TbUserApplication(TbDepartment tbDepartment, String name,
			String password, Boolean gender, String email, Long phone) {
		this.tbDepartment = tbDepartment;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}

	/** full constructor */
	public TbUserApplication(TbDepartment tbDepartment, String name,
			String password, Boolean gender, String email, Long phone,
			String reservedWord) {
		this.tbDepartment = tbDepartment;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.reservedWord = reservedWord;
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

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}

}