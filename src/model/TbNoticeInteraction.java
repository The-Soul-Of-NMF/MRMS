package model;

/**
 * TbNoticeInteraction entity. @author MyEclipse Persistence Tools
 */

public class TbNoticeInteraction implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser tbUserByToUserId;
	private TbUser tbUserByFromUserId;
	private TbNotice tbNotice;
	private String reservedWord;

	// Constructors

	/** default constructor */
	public TbNoticeInteraction() {
	}

	/** minimal constructor */
	public TbNoticeInteraction(TbUser tbUserByToUserId,
			TbUser tbUserByFromUserId, TbNotice tbNotice) {
		this.tbUserByToUserId = tbUserByToUserId;
		this.tbUserByFromUserId = tbUserByFromUserId;
		this.tbNotice = tbNotice;
	}

	/** full constructor */
	public TbNoticeInteraction(TbUser tbUserByToUserId,
			TbUser tbUserByFromUserId, TbNotice tbNotice, String reservedWord) {
		this.tbUserByToUserId = tbUserByToUserId;
		this.tbUserByFromUserId = tbUserByFromUserId;
		this.tbNotice = tbNotice;
		this.reservedWord = reservedWord;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TbUser getTbUserByToUserId() {
		return this.tbUserByToUserId;
	}

	public void setTbUserByToUserId(TbUser tbUserByToUserId) {
		this.tbUserByToUserId = tbUserByToUserId;
	}

	public TbUser getTbUserByFromUserId() {
		return this.tbUserByFromUserId;
	}

	public void setTbUserByFromUserId(TbUser tbUserByFromUserId) {
		this.tbUserByFromUserId = tbUserByFromUserId;
	}

	public TbNotice getTbNotice() {
		return this.tbNotice;
	}

	public void setTbNotice(TbNotice tbNotice) {
		this.tbNotice = tbNotice;
	}

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}

}