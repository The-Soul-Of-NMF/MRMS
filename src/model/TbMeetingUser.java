package model;

/**
 * TbMeetingUser entity. @author MyEclipse Persistence Tools
 */

public class TbMeetingUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser tbUser;
	private TbMeeting tbMeeting;
	private String reservedWord;

	// Constructors

	/** default constructor */
	public TbMeetingUser() {
	}

	/** minimal constructor */
	public TbMeetingUser(TbUser tbUser, TbMeeting tbMeeting) {
		this.tbUser = tbUser;
		this.tbMeeting = tbMeeting;
	}

	/** full constructor */
	public TbMeetingUser(TbUser tbUser, TbMeeting tbMeeting, String reservedWord) {
		this.tbUser = tbUser;
		this.tbMeeting = tbMeeting;
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

	public TbMeeting getTbMeeting() {
		return this.tbMeeting;
	}

	public void setTbMeeting(TbMeeting tbMeeting) {
		this.tbMeeting = tbMeeting;
	}

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}

}