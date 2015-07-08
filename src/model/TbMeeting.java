package model;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbMeeting entity. @author MyEclipse Persistence Tools
 */

public class TbMeeting implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser tbUser;
	private TbMeetingRoom tbMeetingRoom;
	private TbMeetingState tbMeetingState;
	private String title;
	private Date date;
	private Time startTime;
	private Integer duringTime;
	private Integer totalNumber;
	private String description;
	private String reservedWord;
	private Set tbMeetingUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbMeeting() {
	}

	/** minimal constructor */
	public TbMeeting(TbUser tbUser, TbMeetingState tbMeetingState,
			String title, Date date, Integer duringTime, Integer totalNumber,
			String description) {
		this.tbUser = tbUser;
		this.tbMeetingState = tbMeetingState;
		this.title = title;
		this.date = date;
		this.duringTime = duringTime;
		this.totalNumber = totalNumber;
		this.description = description;
	}

	/** full constructor */
	public TbMeeting(TbUser tbUser, TbMeetingRoom tbMeetingRoom,
			TbMeetingState tbMeetingState, String title, Date date,
			Time startTime, Integer duringTime, Integer totalNumber,
			String description, String reservedWord, Set tbMeetingUsers) {
		this.tbUser = tbUser;
		this.tbMeetingRoom = tbMeetingRoom;
		this.tbMeetingState = tbMeetingState;
		this.title = title;
		this.date = date;
		this.startTime = startTime;
		this.duringTime = duringTime;
		this.totalNumber = totalNumber;
		this.description = description;
		this.reservedWord = reservedWord;
		this.tbMeetingUsers = tbMeetingUsers;
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

	public TbMeetingState getTbMeetingState() {
		return this.tbMeetingState;
	}

	public void setTbMeetingState(TbMeetingState tbMeetingState) {
		this.tbMeetingState = tbMeetingState;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}

	public Set getTbMeetingUsers() {
		return this.tbMeetingUsers;
	}

	public void setTbMeetingUsers(Set tbMeetingUsers) {
		this.tbMeetingUsers = tbMeetingUsers;
	}

}