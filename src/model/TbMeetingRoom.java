package model;

import java.util.HashSet;
import java.util.Set;

/**
 * TbMeetingRoom entity. @author MyEclipse Persistence Tools
 */

public class TbMeetingRoom implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbMeetingRoomState tbMeetingRoomState;
	private Integer doorNumber;
	private Integer personLimit;
	private String reservedWord;
	private Set tbMeetings = new HashSet(0);
	private Set tbMeetingRoomThings = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbMeetingRoom() {
	}

	/** minimal constructor */
	public TbMeetingRoom(TbMeetingRoomState tbMeetingRoomState,
			Integer doorNumber, Integer personLimit) {
		this.tbMeetingRoomState = tbMeetingRoomState;
		this.doorNumber = doorNumber;
		this.personLimit = personLimit;
	}

	/** full constructor */
	public TbMeetingRoom(TbMeetingRoomState tbMeetingRoomState,
			Integer doorNumber, Integer personLimit, String reservedWord,
			Set tbMeetings, Set tbMeetingRoomThings) {
		this.tbMeetingRoomState = tbMeetingRoomState;
		this.doorNumber = doorNumber;
		this.personLimit = personLimit;
		this.reservedWord = reservedWord;
		this.tbMeetings = tbMeetings;
		this.tbMeetingRoomThings = tbMeetingRoomThings;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TbMeetingRoomState getTbMeetingRoomState() {
		return this.tbMeetingRoomState;
	}

	public void setTbMeetingRoomState(TbMeetingRoomState tbMeetingRoomState) {
		this.tbMeetingRoomState = tbMeetingRoomState;
	}

	public Integer getDoorNumber() {
		return this.doorNumber;
	}

	public void setDoorNumber(Integer doorNumber) {
		this.doorNumber = doorNumber;
	}

	public Integer getPersonLimit() {
		return this.personLimit;
	}

	public void setPersonLimit(Integer personLimit) {
		this.personLimit = personLimit;
	}

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}

	public Set getTbMeetings() {
		return this.tbMeetings;
	}

	public void setTbMeetings(Set tbMeetings) {
		this.tbMeetings = tbMeetings;
	}

	public Set getTbMeetingRoomThings() {
		return this.tbMeetingRoomThings;
	}

	public void setTbMeetingRoomThings(Set tbMeetingRoomThings) {
		this.tbMeetingRoomThings = tbMeetingRoomThings;
	}

}