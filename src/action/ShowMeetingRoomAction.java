package action;

import java.util.ArrayList;

import service.ShowMeetingRoomService;
import model.TbMeeting;

import com.opensymphony.xwork2.ActionSupport;

public class ShowMeetingRoomAction extends ActionSupport {


	private ArrayList<TbMeeting> meetings;
	private ShowMeetingRoomService ShowMeetingRoomService;
	public String execute()
	{
		setMeetings(getShowMeetingRoomService().getMeetingRoom());
		return "suc";
	}
	public ArrayList<TbMeeting> getMeetings() {
		return meetings;
	}
	public void setMeetings(ArrayList<TbMeeting> meetings) {
		this.meetings = meetings;
	}
	public ShowMeetingRoomService getShowMeetingRoomService() {
		return ShowMeetingRoomService;
	}
	public void setShowMeetingRoomService(ShowMeetingRoomService showMeetingRoomService) {
		ShowMeetingRoomService = showMeetingRoomService;
	}
}
