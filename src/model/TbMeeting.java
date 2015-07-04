package model;

import java.sql.Time;
import java.util.Date;

/**
 * TbMeeting entity. @author MyEclipse Persistence Tools
 */

public class TbMeeting implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser tbUser;
	private TbMeetingRoom tbMeetingRoom;
	private String title;
	private Date date;
	private Time startTime;
	private Integer duringTime;
	private Integer totalNumber;
	private Integer state;
	private String reservedWord;

	// Constructors

	/** default constructor */
	public TbMeeting() {
	}

	/** minimal constructor */
	public TbMeeting(TbUser tbUser, String title, Date date,
			Integer duringTime, Integer totalNumber, Integer state) {
		this.tbUser = tbUser;
		this.title = title;
		this.date = date;
		this.duringTime = duringTime;
		this.totalNumber = totalNumber;
		this.state = state;
	}

	/** full constructor */
	public TbMeeting(TbUser tbUser, TbMeetingRoom tbMeetingRoom, String title,
			Date date, Time startTime, Integer duringTime, Integer totalNumber,
			Integer state, String reservedWord) {
		this.tbUser = tbUser;
		this.tbMeetingRoom = tbMeetingRoom;
		this.title = title;
		this.date = date;
		this.startTime = startTime;
		this.duringTime = duringTime;
		this.totalNumber = totalNumber;
		this.state = state;
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

	public TbMeetingRoom getTbMeetingRoom() {
		return this.tbMeetingRoom;
	}

	public void setTbMeetingRoom(TbMeetingRoom tbMeetingRoom) {
		this.tbMeetingRoom = tbMeetingRoom;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Integer getDuringTime() {
		return this.duringTime;
	}

	public void setDuringTime(Integer duringTime) {
		this.duringTime = duringTime;
	}

	public Integer getTotalNumber() {
		return this.totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}

}