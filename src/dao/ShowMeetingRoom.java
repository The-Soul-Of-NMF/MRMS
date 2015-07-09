package dao;

import java.util.ArrayList;
import java.util.List;

import model.TbMeeting;
import model.TbMeetingRoom;

public interface ShowMeetingRoom {

	ArrayList<TbMeeting> getMeetingRoom();
	List<TbMeetingRoom> getMeetingRoom(int minSize);
}
