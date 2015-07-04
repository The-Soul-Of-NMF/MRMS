package model;

import java.util.HashSet;
import java.util.Set;

/**
 * TbNoticeType entity. @author MyEclipse Persistence Tools
 */

public class TbNoticeType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String reservedWord;
	private Set tbNotices = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbNoticeType() {
	}

	/** minimal constructor */
	public TbNoticeType(String name) {
		this.name = name;
	}

	/** full constructor */
	public TbNoticeType(String name, String reservedWord, Set tbNotices) {
		this.name = name;
		this.reservedWord = reservedWord;
		this.tbNotices = tbNotices;
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

	public Set getTbNotices() {
		return this.tbNotices;
	}

	public void setTbNotices(Set tbNotices) {
		this.tbNotices = tbNotices;
	}

}