package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.TbMeeting;
import model.TbMeetingRoom;
import model.TbMeetingRoomState;

import org.apache.struts2.ServletActionContext;

import service.ModifyMeetingRoomService;
import service.ShowMeetingRoomService;

import com.opensymphony.xwork2.ActionSupport;

public class ModifyMeetingRoomAction extends ActionSupport {
	private ArrayList<TbMeeting> meetings;
	private ShowMeetingRoomService showMeetingRoomService;
	private ModifyMeetingRoomService meetingRoomService;
	public String execute()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println(request.getParameter("state"));
		int state = Integer.parseInt(request.getParameter("state"));
		int id = Integer.parseInt(request.getParameter("current_id"));
		int number=Integer.parseInt(request.getParameter("number"));
		int personlimit=Integer.parseInt(request.getParameter("personlimit"));
		meetingRoomService.modifyS(state, number, personlimit, id);
		
		setMeetings(getShowMeetingRoomService().getMeetingRoom());
		return "modisucc";
	}
	public ModifyMeetingRoomService getMeetingRoomService() {
		return meetingRoomService;
	}
	public void setMeetingRoomService(ModifyMeetingRoomService meetingRoomService) {
		this.meetingRoomService = meetingRoomService;
	}
	public ArrayList<TbMeeting> getMeetings() {
		return meetings;
	}
	public void setMeetings(ArrayList<TbMeeting> meetings) {
		this.meetings = meetings;
	}
	public ShowMeetingRoomService getShowMeetingRoomService() {
		return showMeetingRoomService;
	}
	public void setShowMeetingRoomService(ShowMeetingRoomService showMeetingRoomService) {
		this.showMeetingRoomService = showMeetingRoomService;
	}
}
