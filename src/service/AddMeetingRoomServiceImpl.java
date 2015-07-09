package service;

import dao.AddMeetingRoom;
import model.TbMeetingRoom;

public class AddMeetingRoomServiceImpl implements AddMeetingRoomService {

	private AddMeetingRoom addMeetingRoom;
	public AddMeetingRoom getAddMeetingRoom() {
		return addMeetingRoom;
	}
	public void setAddMeetingRoom(AddMeetingRoom addMeetingRoom) {
		this.addMeetingRoom = addMeetingRoom;
	}
	@Override
	public void addMeetingRoomS(TbMeetingRoom room) {
		// TODO Auto-generated method stub
		addMeetingRoom.addMeeting(room);
	}

}
