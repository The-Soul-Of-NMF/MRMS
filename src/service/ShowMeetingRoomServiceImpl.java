package service;

import java.util.ArrayList;

import dao.ShowMeetingRoom;
import model.TbMeeting;

public class ShowMeetingRoomServiceImpl implements ShowMeetingRoomService {

	private ShowMeetingRoom ShowMeetingRoom;
	@Override
	public ArrayList<TbMeeting> getMeetingRoom() {
		// TODO Auto-generated method stub
		return ShowMeetingRoom.getMeetingRoom();
	}
	public ShowMeetingRoom getShowMeetingRoom() {
		return ShowMeetingRoom;
	}
	public void setShowMeetingRoom(ShowMeetingRoom showMeetingRoom) {
		ShowMeetingRoom = showMeetingRoom;
	}

}
