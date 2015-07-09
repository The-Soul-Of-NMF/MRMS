package model;

/**
 * TbAdmin entity. @author MyEclipse Persistence Tools
 */

public class TbAdmin implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser tbUser;
	private Boolean superAdmin;
	private String reservedWord;

	// Constructors

	/** default constructor */
	public TbAdmin() {
	}

	/** minimal constructor */
	public TbAdmin(TbUser tbUser, Boolean superAdmin) {
		this.tbUser = tbUser;
		this.superAdmin = superAdmin;
	}

	/** full constructor */
	public TbAdmin(TbUser tbUser, Boolean superAdmin, String reservedWord) {
		this.tbUser = tbUser;
		this.superAdmin = superAdmin;
		this.reservedWord = reservedWord;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public Boolean getSuperAdmin() {
		return this.superAdmin;
	}

	public void setSuperAdmin(Boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}

}