package model;

import java.util.HashSet;
import java.util.Set;

/**
 * TbMeetingRoomState entity. @author MyEclipse Persistence Tools
 */

public class TbMeetingRoomState implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String reservedWord;
	private Set tbMeetingRooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbMeetingRoomState() {
	}

	/** minimal constructor */
	public TbMeetingRoomState(String name) {
		this.name = name;
	}

	/** full constructor */
	public TbMeetingRoomState(String name, String reservedWord,
			Set tbMeetingRooms) {
		this.name = name;
		this.reservedWord = reservedWord;
		this.tbMeetingRooms = tbMeetingRooms;
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

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}

	public Set getTbMeetingRooms() {
		return this.tbMeetingRooms;
	}

	public void setTbMeetingRooms(Set tbMeetingRooms) {
		this.tbMeetingRooms = tbMeetingRooms;
	}

}