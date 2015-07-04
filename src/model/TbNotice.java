package model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TbNotice entity. @author MyEclipse Persistence Tools
 */

public class TbNotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbNoticeType tbNoticeType;
	private String information;
	private Timestamp sendTime;
	private String reservedWord;
	private Set tbNoticeInteractions = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbNotice() {
	}

	/** minimal constructor */
	public TbNotice(TbNoticeType tbNoticeType, String information,
			Timestamp sendTime) {
		this.tbNoticeType = tbNoticeType;
		this.information = information;
		this.sendTime = sendTime;
	}

	/** full constructor */
	public TbNotice(TbNoticeType tbNoticeType, String information,
			Timestamp sendTime, String reservedWord, Set tbNoticeInteractions) {
		this.tbNoticeType = tbNoticeType;
		this.information = information;
		this.sendTime = sendTime;
		this.reservedWord = reservedWord;
		this.tbNoticeInteractions = tbNoticeInteractions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TbNoticeType getTbNoticeType() {
		return this.tbNoticeType;
	}

	public void setTbNoticeType(TbNoticeType tbNoticeType) {
		this.tbNoticeType = tbNoticeType;
	}

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}

	public Set getTbNoticeInteractions() {
		return this.tbNoticeInteractions;
	}

	public void setTbNoticeInteractions(Set tbNoticeInteractions) {
		this.tbNoticeInteractions = tbNoticeInteractions;
	}

}