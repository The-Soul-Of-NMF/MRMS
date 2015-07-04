package model;

import java.util.HashSet;
import java.util.Set;

/**
 * TbThing entity. @author MyEclipse Persistence Tools
 */

public class TbThing implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String reservedWord;
	private Set tbMeetingRoomThings = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbThing() {
	}

	/** minimal constructor */
	public TbThing(String name) {
		this.name = name;
	}

	/** full constructor */
	public TbThing(String name, String reservedWord, Set tbMeetingRoomThings) {
		this.name = name;
		this.reservedWord = reservedWord;
		this.tbMeetingRoomThings = tbMeetingRoomThings;
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

	public Set getTbMeetingRoomThings() {
		return this.tbMeetingRoomThings;
	}

	public void setTbMeetingRoomThings(Set tbMeetingRoomThings) {
		this.tbMeetingRoomThings = tbMeetingRoomThings;
	}

}