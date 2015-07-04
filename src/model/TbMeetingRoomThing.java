package model;

/**
 * TbMeetingRoomThing entity. @author MyEclipse Persistence Tools
 */

public class TbMeetingRoomThing implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbThing tbThing;
	private TbMeetingRoom tbMeetingRoom;
	private String reservedWord;

	// Constructors

	/** default constructor */
	public TbMeetingRoomThing() {
	}

	/** minimal constructor */
	public TbMeetingRoomThing(TbThing tbThing, TbMeetingRoom tbMeetingRoom) {
		this.tbThing = tbThing;
		this.tbMeetingRoom = tbMeetingRoom;
	}

	/** full constructor */
	public TbMeetingRoomThing(TbThing tbThing, TbMeetingRoom tbMeetingRoom,
			String reservedWord) {
		this.tbThing = tbThing;
		this.tbMeetingRoom = tbMeetingRoom;
		this.reservedWord = reservedWord;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TbThing getTbThing() {
		return this.tbThing;
	}

	public void setTbThing(TbThing tbThing) {
		this.tbThing = tbThing;
	}

	public TbMeetingRoom getTbMeetingRoom() {
		return this.tbMeetingRoom;
	}

	public void setTbMeetingRoom(TbMeetingRoom tbMeetingRoom) {
		this.tbMeetingRoom = tbMeetingRoom;
	}

	public String getReservedWord() {
		return this.reservedWord;
	}

	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}

}