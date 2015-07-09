package service;

import java.util.ArrayList;
import java.util.List;

import dao.ShowMeetingRoom;
import model.TbMeeting;
import model.TbMeetingRoom;

public class ShowMeetingRoomServiceImpl implements ShowMeetingRoomService {

	private ShowMeetingRoom showMeetingRoom;
	@Override
	public ArrayList<TbMeeting> getMeetingRoom() {
		// TODO Auto-generated method stub
		return showMeetingRoom.getMeetingRoom();
	}
	public ShowMeetingRoom getShowMeetingRoom() {
		return showMeetingRoom;
	}
	public void setShowMeetingRoom(ShowMeetingRoom showMeetingRoom) {
		this.showMeetingRoom = showMeetingRoom;
	}
	@Override
	public List<TbMeetingRoom> getMeetingRoom(int minSize) {
		return showMeetingRoom.getMeetingRoom(minSize);
	}

}
