package service;

import dao.DeleteMeetingRoom;

public class DeleteMeetingRoomServiceImpl implements DeleteMeetingRoomService {

	private DeleteMeetingRoom deleteMeetingRoom;
	@Override
	public void deleteS(int id) {
		// TODO Auto-generated method stub
		deleteMeetingRoom.deleteRoom(id);

	}
	public DeleteMeetingRoom getDeleteMeetingRoom() {
		return deleteMeetingRoom;
	}
	public void setDeleteMeetingRoom(DeleteMeetingRoom deleteMeetingRoom) {
		this.deleteMeetingRoom = deleteMeetingRoom;
	}

}
