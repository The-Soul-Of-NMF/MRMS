package model;

import java.util.HashSet;
import java.util.Set;

/**
 * TbMeetingState entity. @author MyEclipse Persistence Tools
 */

public class TbMeetingState implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String reservedWord;
	private Set tbMeetings = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbMeetingState() {
	}

	/** minimal constructor */
	public TbMeetingState(String name) {
		this.name = name;
	}

	/** full constructor */
	public TbMeetingState(String name, String reservedWord, Set tbMeetings) {
		this.name = name;
		this.reservedWord = reservedWord;
		this.tbMeetings = tbMeetings;
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

	public Set getTbMeetings() {
		return this.tbMeetings;
	}

	public void setTbMeetings(Set tbMeetings) {
		this.tbMeetings = tbMeetings;
	}

}